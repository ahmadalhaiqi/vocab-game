// MainActivity.java
// Hosts the WordGuessActivityFragment on a phone and both the
// WordGuessActivityFragment and GuessSettingsActivityFragment on a tablet
package com.ahmadalhaiqi.vocabgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Set;

public class WordGuessActivity extends AppCompatActivity {
    // keys for reading data from SharedPreferences
    public static final String CHOICES = "pref_numberOfChoices";
    public static final String LEVEL = "pref_levelToInclude";
    public static final String CATEGORIES = "pref_categoriesToInclude";

    private boolean phoneDevice = true; // used to force portrait mode
    private boolean preferencesChanged = true; // d id guess_preferences change?

    // configure the WordGuessActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_guess);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set default values in the app's SharedPreferences
        PreferenceManager.setDefaultValues(this, R.xml.guess_preferences, false);

        // register listener for SharedPreferences changes
        PreferenceManager.getDefaultSharedPreferences(this).
                registerOnSharedPreferenceChangeListener(
                        preferencesChangeListener);

        // determine screen size
        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        // if device is a tablet, set phoneDevice to false
        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE ||
                screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE)
            phoneDevice = false; // not a phone-sized device

        // if running on phone-sized device, allow only portrait orientation
        if (phoneDevice)
            setRequestedOrientation(
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    // called after onCreate completes execution
    @Override
    protected void onStart() {
        super.onStart();

        if (preferencesChanged) {
            // now that the default guess_preferences have been set,
            // initialize WordGuessActivityFragment and start the quiz
            WordGuessActivityFragment quizFragment = (WordGuessActivityFragment)
                    getSupportFragmentManager().findFragmentById(
                            R.id.quessFragment);
            quizFragment.updateGuessRows(
                    PreferenceManager.getDefaultSharedPreferences(this));
            quizFragment.updateLevel(
                    PreferenceManager.getDefaultSharedPreferences(this));
            quizFragment.updateCategories(
                    PreferenceManager.getDefaultSharedPreferences(this));
            quizFragment.resetQuiz();
            preferencesChanged = false;
        }
    }

    // show menu if app is running on a phone or a portrait-oriented tablet
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // get the device's current orientation
        int orientation = getResources().getConfiguration().orientation;

        // display the app's menu only in portrait orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            // inflate the menu
            getMenuInflater().inflate(R.menu.menu_word_guess, menu);
            return true;
        } else
            return false;
    }

    // displays the GuessSettingsActivity when running on a phone
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent preferencesIntent = new Intent(this, GuessSettingsActivity.class);
                startActivity(preferencesIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    // listener for changes to the app's SharedPreferences
    private OnSharedPreferenceChangeListener preferencesChangeListener =
            new OnSharedPreferenceChangeListener() {
                // called when the user changes the app's guess_preferences
                @Override
                public void onSharedPreferenceChanged(
                        SharedPreferences sharedPreferences, String key) {
                    preferencesChanged = true; // user changed app setting

                    WordGuessActivityFragment quizFragment = (WordGuessActivityFragment)
                            getSupportFragmentManager().findFragmentById(
                                    R.id.quessFragment);

                    if (key.equals(CHOICES)) { // # of choices to display changed
                        quizFragment.updateGuessRows(sharedPreferences);
                        quizFragment.resetQuiz();
                    } else if (key.equals(LEVEL)) { // level to include changed
                        quizFragment.updateLevel(sharedPreferences);
                        quizFragment.resetQuiz();
                    } else if (key.equals(CATEGORIES)) { // categories to include changed
                        Set<String> categories =
                                sharedPreferences.getStringSet(CATEGORIES, null);

                        if (categories != null && categories.size() > 0) {
                            quizFragment.updateCategories(sharedPreferences);
                            quizFragment.resetQuiz();
                        } else {
                            // must select one region--set North America as default
                            SharedPreferences.Editor editor =
                                    sharedPreferences.edit();
                            categories.add(getString(R.string.default_category));
                            editor.putStringSet(CATEGORIES, categories);
                            editor.apply();

                            Toast.makeText(WordGuessActivity.this,
                                    R.string.default_category_message,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    Toast.makeText(WordGuessActivity.this,
                            R.string.restarting_quiz,
                            Toast.LENGTH_SHORT).show();
                }
            };
}


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
