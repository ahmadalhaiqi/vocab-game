package com.ahmadalhaiqi.vocabgame;

public class Word {
    private long id;
    private String english;
    private String melayu;
    private String level;
    private String category;

    public Word(long id, String english, String melayu, String level, String category) {
        this.id = id;
        this.english = english;
        this.melayu = melayu;
        this.level = level;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getEnglish() {
        return english;
    }

    public String getMelayu() {
        return melayu;
    }

    public String getLevel() {
        return level;
    }

    public String getCategory() {
        return category;
    }
}
