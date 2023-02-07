package com.vladimir.pleasedeutch.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.vladimir.pleasedeutch.R;
import com.vladimir.pleasedeutch.databinding.SubmitWordButtonsBinding;
import com.vladimir.pleasedeutch.listeners.OnTouchSubmitWordButtonsListener;

public class SubmitWordButtonsView extends ConstraintLayout {
    private final ConstraintSet constraintSet = new ConstraintSet();
    private SubmitWordButtonsBinding binding;
    public static int widthInPixels;
    public static int MAX_TRANSLATION_X_PX;
    public WordCardView currentWordCardView;

    public SubmitWordButtonsView(@NonNull Context context) {
        this(context, null);
    }

    public SubmitWordButtonsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SubmitWordButtonsView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SubmitWordButtonsView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.submit_word_buttons, this);
        binding = com.vladimir.pleasedeutch.databinding.SubmitWordButtonsBinding.bind(this);

        setConstants();

        constraintSet.clone(this);

        setOnTouchListener(new OnTouchSubmitWordButtonsListener(binding, this));
    }

    private void setConstants() {
        post(() -> {
            widthInPixels = getWidth();
            MAX_TRANSLATION_X_PX = widthInPixels / 7;
        });
    }

    public ConstraintSet getConstraintSet() {
        return constraintSet;
    }

    public void applyConstraintSet(ConstraintSet set) {
        set.applyTo(this);
    }
}
