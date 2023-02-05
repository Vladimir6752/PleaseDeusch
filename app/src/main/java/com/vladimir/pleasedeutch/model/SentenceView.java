package com.vladimir.pleasedeutch.model;

import android.text.Html;
import android.text.Spanned;

public class SentenceView {
    private final String sentence;

    public SentenceView(String sentence) {
        this.sentence = sentence;
    }

    public Spanned getFormattedWithWord(String formattedWord) {
        String next = "<strong>bold</strong>";


        return Html.fromHtml(next, 0);
        //txtv.setText( builder, TextView.BufferType.SPANNABLE);
    }

    public String getSentence() {
        return sentence;
    }

    public int getLength() {
        return sentence.length();
    }
}
