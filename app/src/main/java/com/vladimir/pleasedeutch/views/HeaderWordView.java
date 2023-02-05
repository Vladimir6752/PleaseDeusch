package com.vladimir.pleasedeutch.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.vladimir.pleasedeutch.R;
import com.vladimir.pleasedeutch.databinding.HeaderWordViewBinding;
import com.vladimir.pleasedeutch.model.Word;

public class HeaderWordView extends ConstraintLayout {
    private HeaderWordViewBinding binding;

    public HeaderWordView(@NonNull Context context) {
        super(context, null);
    }

    public HeaderWordView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        init();
    }

    public HeaderWordView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    public HeaderWordView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        inflate(getContext(), R.layout.header_word_view, this);
        binding = HeaderWordViewBinding.bind(this);
    }

    public void setWord(Word word) {
        binding.nameWordCategory.setText(word.getCategoryName());
    }
}
