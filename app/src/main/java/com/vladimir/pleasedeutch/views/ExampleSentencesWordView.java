package com.vladimir.pleasedeutch.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.vladimir.pleasedeutch.R;
import com.vladimir.pleasedeutch.databinding.ExampleSentencesWordViewBinding;
import com.vladimir.pleasedeutch.listeners.OnTouchExampleSentence;

public class ExampleSentencesWordView extends ConstraintLayout {
    private ExampleSentencesWordViewBinding binding;

    public ExampleSentencesWordView(@NonNull Context context) {
        this(context, null);
    }

    public ExampleSentencesWordView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExampleSentencesWordView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ExampleSentencesWordView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.example_sentences_word_view, this);
        binding = ExampleSentencesWordViewBinding.bind(this);

        setOnTouchListener(new OnTouchExampleSentence(binding, this));
    }


    public void closeSentence() {
        binding.exampleSentencesTextAfterTranslate.setVisibility(View.GONE);
        binding.arrow.setRotationX(0);
        setBackground(null);
    }

    public void openSentence() {
        binding.exampleSentencesTextAfterTranslate.setVisibility(View.VISIBLE);
        binding.arrow.setRotationX(180);
        setBackgroundResource(R.drawable.background_light_gray);
    }
}
