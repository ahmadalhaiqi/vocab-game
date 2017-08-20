// MainActivityFragment.java
// Contains the Vocabulary Game logic
package com.ahmadalhaiqi.vocabgame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ahmadalhaiqi.vocabgame.database.DbHelper;
import com.ahmadalhaiqi.vocabgame.database.Schema;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WordGuessActivityFragment extends Fragment {
    // String used when logging error messages
    private static final String TAG = "VocabGame Activity";

    private static final int WORDS_IN_QUIZ = 10;

    private List<Word> wordsList;           // all words in database
    private List<Word> quizWordsList;       // words in current quiz
    private Set<String> categoriesSet;      // word categories in current quiz
    private String level;                   // level of words in current quiz (e.g. basic)
    private String correctAnswer;           // correct melayu word for the current english word
    private int totalGuesses;               // number of guesses made
    private int correctAnswers;             // number of correct guesses
    private int guessRows;                  // number of rows displaying guess Buttons
    private SecureRandom random;            // used to randomize the quiz
    private Handler handler;                // used to delay loading next word
    private Animation shakeAnimation;       // animation for incorrect guess

    private LinearLayout quizLinearLayout;       // layout that contains the quiz
    private TextView questionNumberTextView;     // shows current question #
    private ImageView wordImageView;             // displays a word illustration
    private LinearLayout[] guessLinearLayouts;   // rows of answer Buttons
    private TextView answerTextView;             // displays correct answer
    private TextView wordTextView;               // displays the english word

    private DbHelper mDbHelper;
    private SQLiteDatabase db;

    // configures the WordGuessActivityFragment when its View is created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.fragment_word_guess, container, false);

        wordsList = new ArrayList<>();
        quizWordsList = new ArrayList<>();
        random = new SecureRandom();
        handler = new Handler();

        // load the shake animation that's used for incorrect answers
        shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.incorrect_shake);
        shakeAnimation.setRepeatCount(3); // animation repeats 3 times

        // get references to GUI components
        quizLinearLayout =
                (LinearLayout) view.findViewById(R.id.quizLinearLayout);
        questionNumberTextView =
                (TextView) view.findViewById(R.id.questionNumberTextView);
        wordImageView = (ImageView) view.findViewById(R.id.wordImageView);
        guessLinearLayouts = new LinearLayout[4];
        guessLinearLayouts[0] =
                (LinearLayout) view.findViewById(R.id.row1LinearLayout);
        guessLinearLayouts[1] =
                (LinearLayout) view.findViewById(R.id.row2LinearLayout);
        guessLinearLayouts[2] =
                (LinearLayout) view.findViewById(R.id.row3LinearLayout);
        guessLinearLayouts[3] =
                (LinearLayout) view.findViewById(R.id.row4LinearLayout);
        answerTextView = (TextView) view.findViewById(R.id.answerTextView);
        wordTextView = (TextView) view.findViewById(R.id.wordTextView);

        // configure listeners for the guess Buttons
        for (LinearLayout row : guessLinearLayouts) {
            for (int column = 0; column < row.getChildCount(); column++) {
                Button button = (Button) row.getChildAt(column);
                button.setOnClickListener(guessButtonListener);
            }
        }

        // set questionNumberTextView's text
        questionNumberTextView.setText(
                getString(R.string.question, 1, WORDS_IN_QUIZ));
        return view; // return the fragment's view for display
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDbHelper = new DbHelper(getContext());
        db = mDbHelper.getReadableDatabase();
    }

    // update guessRows based on value in SharedPreferences
    public void updateGuessRows(SharedPreferences sharedPreferences) {
        // get the number of guess buttons that should be displayed
        String choices =
                sharedPreferences.getString(WordGuessActivity.CHOICES, null);
        guessRows = Integer.parseInt(choices) / 2;

        // hide all guess button LinearLayouts
        for (LinearLayout layout : guessLinearLayouts)
            layout.setVisibility(View.GONE);

        // display appropriate guess button LinearLayouts
        for (int row = 0; row < guessRows; row++)
            guessLinearLayouts[row].setVisibility(View.VISIBLE);
    }

    // update words level for quiz based on values in SharedPreferences
    public void updateLevel(SharedPreferences sharedPreferences) {
        level = sharedPreferences.getString(WordGuessActivity.LEVEL, null);
    }

    // update word categories for quiz based on values in SharedPreferences
    public void updateCategories(SharedPreferences sharedPreferences) {
        categoriesSet =
                sharedPreferences.getStringSet(WordGuessActivity.CATEGORIES, null);
    }

    // set up and start the next quiz
    public void resetQuiz() {
        wordsList.clear();    // empty list of all words
        wordsList = selectWordsByCategory();

        correctAnswers = 0; // reset the number of correct answers made
        totalGuesses = 0; // reset the total number of guesses the user made
        quizWordsList.clear(); // clear prior list of quiz countries

        int wordCounter = 1;
        int numberOfWords = wordsList.size();

        // add WORDS_IN_QUIZ random file names to the quizWordsList
        while (wordCounter <= WORDS_IN_QUIZ) {
            int randomIndex = random.nextInt(numberOfWords);

            // get the random file name
            Word word = wordsList.get(randomIndex);

            // if the region is enabled and it hasn't already been chosen
            if (!quizWordsList.contains(word)) {
                quizWordsList.add(word); // add the file to the list
                ++wordCounter;
            }
        }

        loadNextWord(); // start the quiz by loading the first word
    }

    // after the user guesses a correct word, load the next word
    private void loadNextWord() {
        // get file name of the next word and remove it from the list
        Word nextWord = quizWordsList.remove(0);
        correctAnswer = nextWord.getMelayu();   // update the correct answer
        answerTextView.setText("");             // clear answerTextView

        // display current question number
        questionNumberTextView.setText(getString(
                R.string.question, (correctAnswers + 1), WORDS_IN_QUIZ));

        // extract the category from the next word object
        String category = nextWord.getCategory();
        // extract the english vocab from the next word object
        String english = nextWord.getEnglish();

        // display the english version of the next word in wordTextView
        wordTextView.setText(english);

        // use AssetManager to load next image from assets folder
        AssetManager assets = getActivity().getAssets();

        // get an InputStream to the asset representing the next word
        // and try to use the InputStream
        try (InputStream stream =
                     assets.open(level + "/" + category + "/" + english + ".png")) {
            // load the asset as a Drawable and display on the wordImageView
            Drawable word = Drawable.createFromStream(stream, english);
            wordImageView.setImageDrawable(word);

            animate(false); // animate the word onto the screen
        } catch (IOException exception) {
            wordImageView.setImageDrawable(getResources().getDrawable(R.drawable.noimage, null));
            Log.e(TAG, "Error loading " + english, exception);
        }

        Collections.shuffle(wordsList); // shuffle words

        // put the correct answer at the end of wordsList
        int correct = wordsList.indexOf(nextWord);
        wordsList.add(wordsList.remove(correct));

        // add 2, 4, 6 or 8 guess Buttons based on the value of guessRows
        for (int row = 0; row < guessRows; row++) {
            // place Buttons in currentTableRow
            for (int column = 0;
                 column < guessLinearLayouts[row].getChildCount();
                 column++) {
                // get reference to Button to configure
                Button newGuessButton =
                        (Button) guessLinearLayouts[row].getChildAt(column);
                newGuessButton.setEnabled(true);

                // get melayu word and set it as newGuessButton's text
                String melayu = wordsList.get((row * 2) + column).getMelayu();
                newGuessButton.setText(melayu);
            }
        }

        // randomly replace one Button with the correct answer
        int row = random.nextInt(guessRows); // pick random row
        int column = random.nextInt(2); // pick random column
        LinearLayout randomRow = guessLinearLayouts[row]; // get the row
        ((Button) randomRow.getChildAt(column)).setText(correctAnswer);
    }

    // animates the entire quizLinearLayout on or off screen
    private void animate(boolean animateOut) {
        // prevent animation into the the UI for the first word
        if (correctAnswers == 0)
            return;

        // calculate center x and center y
        int centerX = (quizLinearLayout.getLeft() +
                quizLinearLayout.getRight()) / 2; // calculate center x
        int centerY = (quizLinearLayout.getTop() +
                quizLinearLayout.getBottom()) / 2; // calculate center y

        // calculate animation radius
        int radius = Math.max(quizLinearLayout.getWidth(),
                quizLinearLayout.getHeight());

        Animator animator;

        // if the quizLinearLayout should animate out rather than in
        if (animateOut) {
            // create circular reveal animation
            animator = ViewAnimationUtils.createCircularReveal(
                    quizLinearLayout, centerX, centerY, radius, 0);
            animator.addListener(
                    new AnimatorListenerAdapter() {
                        // called when the animation finishes
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            loadNextWord();
                        }
                    }
            );
        } else { // if the quizLinearLayout should animate in
            animator = ViewAnimationUtils.createCircularReveal(
                    quizLinearLayout, centerX, centerY, 0, radius);
        }

        animator.setDuration(500); // set animation duration to 500 ms
        animator.start(); // start the animation
    }

    // called when a guess Button is touched
    private OnClickListener guessButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Button guessButton = ((Button) v);
            String guess = guessButton.getText().toString();
            String answer = correctAnswer;
            ++totalGuesses; // increment number of guesses the user has made

            if (guess.equals(answer)) { // if the guess is correct
                ++correctAnswers; // increment the number of correct answers

                // display correct answer in green text
                answerTextView.setText(getString(R.string.answer, answer));
                answerTextView.setTextColor(
                        getResources().getColor(R.color.correct_answer,
                                getContext().getTheme()));

                disableButtons(); // disable all guess Buttons

                // if the user has correctly identified WORDS_IN_QUIZ words
                if (correctAnswers == WORDS_IN_QUIZ) {
                    // DialogFragment to display quiz stats and start new quiz
                    DialogFragment quizResults =
                            new DialogFragment() {
                                // create an AlertDialog and return it
                                @Override
                                public Dialog onCreateDialog(Bundle bundle) {
                                    AlertDialog.Builder builder =
                                            new AlertDialog.Builder(getActivity());
                                    builder.setMessage(
                                            getString(R.string.results,
                                                    totalGuesses,
                                                    (1000 / (double) totalGuesses)));

                                    // "Reset Quiz" Button
                                    builder.setPositiveButton(R.string.reset_quiz,
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog,
                                                                    int id) {
                                                    resetQuiz();
                                                }
                                            }
                                    );

                                    return builder.create(); // return the AlertDialog
                                }
                            };

                    // use FragmentManager to display the DialogFragment
                    quizResults.setCancelable(false);
                    quizResults.show(getFragmentManager(), "quiz results");
                } else { // answer is correct but quiz is not over
                    // load the next word after a 2-second delay
                    handler.postDelayed(
                            new Runnable() {
                                @Override
                                public void run() {
                                    animate(true); // animate the word off the screen
                                }
                            }, 2000); // 2000 milliseconds for 2-second delay
                }
            } else { // answer was incorrect
                wordImageView.startAnimation(shakeAnimation); // play shake
                wordTextView.startAnimation(shakeAnimation); // play shake

                // display "Incorrect!" in red
                answerTextView.setText(R.string.incorrect_answer);
                answerTextView.setTextColor(getResources().getColor(
                        R.color.incorrect_answer, getContext().getTheme()));
                guessButton.setEnabled(false); // disable incorrect answer
            }
        }
    };

    // utility method that disables all answer Buttons
    private void disableButtons() {
        for (int row = 0; row < guessRows; row++) {
            LinearLayout guessRow = guessLinearLayouts[row];
            for (int i = 0; i < guessRow.getChildCount(); i++)
                guessRow.getChildAt(i).setEnabled(false);
        }
    }

    private List selectWordsByCategory() {
        try {
            // Define a projection that specifies which columns from the database
            // you will actually use after this query.
            String[] projection = {
                    Schema.Words._ID,
                    Schema.Words.COLUMN_ENGLISH,
                    Schema.Words.COLUMN_MELAYU,
                    Schema.Words.COLUMN_LEVEL,
                    Schema.Words.COLUMN_CATEGORY
            };
            // Filter results WHERE "title" = 'My Title'
            String selection = Schema.Words.COLUMN_CATEGORY + " IN (" +
                    TextUtils.join(",", Collections.nCopies(categoriesSet.size(), "?")) + ")" +
                    " AND " + Schema.Words.COLUMN_LEVEL + " = '" + level + "'";
            String[] selectionArgs = categoriesSet.toArray(new String[categoriesSet.size()]);

            Cursor cursor = db.query(
                    Schema.Words.TABLE_WORDS,           // The table to query
                    projection,                         // The columns to return
                    selection,                          // The columns for the WHERE clause
                    selectionArgs,                      // The values for the WHERE clause
                    null,                               // don't group the rows
                    null,                               // don't filter by row groups
                    null                                // The sort order
            );

            List words = new ArrayList<>();
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                Word word = new Word(
                        cursor.getLong(cursor.getColumnIndex(Schema.Words._ID)),
                        cursor.getString(cursor.getColumnIndex(Schema.Words.COLUMN_ENGLISH)),
                        cursor.getString(cursor.getColumnIndex(Schema.Words.COLUMN_MELAYU)),
                        cursor.getString(cursor.getColumnIndex(Schema.Words.COLUMN_LEVEL)),
                        cursor.getString(cursor.getColumnIndex(Schema.Words.COLUMN_CATEGORY))
                );
                words.add(word);
            }
            cursor.close();
            return words;
        } catch (Exception e) {
            Log.e("ahmed: " + this.getClass().getCanonicalName(), e.getMessage() + e.getStackTrace().toString());
        }
        return null;
    }

    @Override
    public void onDestroy() {
        mDbHelper.close();
        super.onDestroy();
    }
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
