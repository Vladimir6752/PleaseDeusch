package com.vladimir.pleasedeutch.listeners;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

import com.vladimir.pleasedeutch.databinding.ExampleSentencesWordViewBinding;
import com.vladimir.pleasedeutch.views.ExampleSentencesWordView;

public class OnTouchExampleSentence implements View.OnTouchListener {
    private final com.vladimir.pleasedeutch.databinding.ExampleSentencesWordViewBinding binding;
    private final ExampleSentencesWordView exampleSentencesWordView;
    private boolean isClosed = true;

    public OnTouchExampleSentence(ExampleSentencesWordViewBinding binding, ExampleSentencesWordView exampleSentencesWordView) {
        this.exampleSentencesWordView = exampleSentencesWordView;
        this.binding = binding;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() != MotionEvent.ACTION_DOWN)
            return true;

        if(isClosed)
            exampleSentencesWordView.openSentence();
        else
            exampleSentencesWordView.closeSentence();

        isClosed = !isClosed;

        return true;
    }
}
