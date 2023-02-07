package com.vladimir.pleasedeutch.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.vladimir.pleasedeutch.R;
import com.vladimir.pleasedeutch.databinding.WordCardViewBinding;
import com.vladimir.pleasedeutch.model.Word;

public class WordCardView extends LinearLayout {
    private com.vladimir.pleasedeutch.databinding.WordCardViewBinding binding;
    private Word currentWord = new Word("Приветствуем вас!", "Willkommen!", "");

    public WordCardView(Context context) {
        this(context, null);
    }

    public WordCardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WordCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public WordCardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.word_card_view, this);

        binding = WordCardViewBinding.bind(this);

        setWord(currentWord);

        binding.submitWordButtonsLayout.currentWordCardView = this;
    }

    public void setWord(Word word) {
        binding.headerWordCard.setWord(word);
        binding.wordTranslate.setWord(word);
        currentWord = word;
    }

    public Word getCurrentWord() {
        return currentWord;
    }

    public void closeAllExampleSentences() {
        binding.exampleSentence1.closeSentence();
        binding.exampleSentence2.closeSentence();
        binding.exampleSentence3.closeSentence();
    }
}
