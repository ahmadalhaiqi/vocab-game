package com.ahmadalhaiqi.vocabgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.guessWordButton)
            startActivity(new Intent(this, WordGuessActivity.class));
        else
            startActivity(new Intent(this, WordSpellActivity.class));
    }
}
