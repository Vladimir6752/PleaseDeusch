package com.vladimir.pleasedeutch.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.vladimir.pleasedeutch.R;
import com.vladimir.pleasedeutch.databinding.WordTranslateViewBinding;
import com.vladimir.pleasedeutch.model.Word;

public class WordTranslateView extends ConstraintLayout {
    private WordTranslateViewBinding binding;

    public WordTranslateView(@NonNull Context context) {
        this(context, null);
    }

    public WordTranslateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WordTranslateView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public WordTranslateView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.word_translate_view, this);

        binding = WordTranslateViewBinding.bind(this);
    }

    public void setWord(Word word) {
        binding.wordAfterTranslate.setText(word.getAfterTranslate());
        binding.wordBeforeTranslate.setText(word.getBeforeTranslate());
    }
}
