package com.ahmadalhaiqi.vocabgame.database;

import android.provider.BaseColumns;

public final class Schema  {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Schema() {}

    /* Inner class that defines the Words table */
    public static class Words implements BaseColumns {
        public static final String TABLE_WORDS = "words";
        public static final String COLUMN_ENGLISH = "english";
        public static final String COLUMN_MELAYU = "melayu";
        public static final String COLUMN_LEVEL = "level";
        public static final String COLUMN_CATEGORY = "category";

        public static final String SQL_CREATE_WORDS =
                "CREATE TABLE " + TABLE_WORDS + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_ENGLISH + " TEXT," +
                        COLUMN_MELAYU + " TEXT," +
                        COLUMN_LEVEL + " TEXT," +
                        COLUMN_CATEGORY + " TEXT" + ");";
        public static final String SQL_DELETE_WORDS =
                "DROP TABLE IF EXISTS " + TABLE_WORDS;
    }

    /* Inner class that defines the Scores table */
    public static class Scores implements BaseColumns {
        public static final String TABLE_SCORES = "scores";
        public static final String COLUMN_WHEN = "thetime";
        public static final String COLUMN_SCORE = "score";

        public static final String SQL_CREATE_SCORES =
                "CREATE TABLE " + TABLE_SCORES + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_WHEN + " TEXT," +
                        COLUMN_SCORE + " TEXT" + ");";
        public static final String SQL_DELETE_SCORES =
                "DROP TABLE IF EXISTS " + TABLE_SCORES;
    }

    /* Inner class that defines the Scores table */
    public static class Mistakes implements BaseColumns {
        public static final String TABLE_MISTAKES = "mistakes";
        public static final String COLUMN_WHEN = "thetime";
        public static final String COLUMN_WORD = "word";

        public static final String SQL_CREATE_MISTAKES =
                "CREATE TABLE " + TABLE_MISTAKES + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_WHEN + " TEXT," +
                        COLUMN_WORD + " INTEGER" + ");";
        public static final String SQL_DELETE_MISTAKES =
                "DROP TABLE IF EXISTS " + TABLE_MISTAKES;
    }
}
