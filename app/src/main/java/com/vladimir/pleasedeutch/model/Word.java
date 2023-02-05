package com.vladimir.pleasedeutch.model;

public class Word {
    private final String beforeTranslate;
    private final String afterTranslate;
    private final String categoryName;

    public Word(String beforeTranslate, String afterTranslate, String categoryName) {
        this.beforeTranslate = beforeTranslate;
        this.afterTranslate = afterTranslate;
        this.categoryName = categoryName;
    }

    public String getBeforeTranslate() {
        return beforeTranslate;
    }

    public String getAfterTranslate() {
        return afterTranslate;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
