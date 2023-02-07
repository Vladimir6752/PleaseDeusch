package com.vladimir.pleasedeutch.listeners;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintSet;

import com.vladimir.pleasedeutch.databinding.SubmitWordButtonsBinding;
import com.vladimir.pleasedeutch.utilities.WordModelChanger;
import com.vladimir.pleasedeutch.views.SubmitWordButtonsView;

public class OnTouchSubmitWordButtonsListener implements View.OnTouchListener {
    private final float standardBiasInCenter = 0.5f;
    private final com.vladimir.pleasedeutch.databinding.SubmitWordButtonsBinding binding;
    private final SubmitWordButtonsView submitWordButtonsView;
    private float savedBeginTouchX;
    private float amountTranslation;
    private float rawTouchX;

    public OnTouchSubmitWordButtonsListener(SubmitWordButtonsBinding binding, SubmitWordButtonsView submitWordButtonsView) {
        this.submitWordButtonsView = submitWordButtonsView;
        this.binding = binding;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(((SubmitWordButtonsView) binding.getRoot()).currentWordCardView.getAnimation() != null)
            return true;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setBeginTouchData(event);
                return true;
            case MotionEvent.ACTION_MOVE:
                handleMoveButtons(event);
                return true;
            default:
                resetButtonsPosition();
                return true;
        }
    }

    private void handleMoveButtons(MotionEvent event) {
        if(wordHasMovedAllRight() && event.getRawX() > rawTouchX) return;

        if(wordHasMovedAllLeft() && event.getRawX() < rawTouchX) return;

        moveButtons(event);
    }

    private void moveButtons(MotionEvent event) {
        amountTranslation = (int) (event.getRawX() - savedBeginTouchX);
        float bias = 0.5f + amountTranslation / SubmitWordButtonsView.widthInPixels;
        float backgroundAlpha = Math.abs(amountTranslation) / SubmitWordButtonsView.MAX_TRANSLATION_X_PX;

        setBiasInCenter(bias);

        setTranslation(amountTranslation);

        setBackgroundsAlphas(backgroundAlpha, bias);

        rawTouchX = event.getRawX();
    }

    private void setBackgroundsAlphas(float alpha, float bias) {
        if(bias > standardBiasInCenter)
            binding.submitWordBackground.setAlpha(alpha);
        else
            binding.repeatWordBackground.setAlpha(alpha);
    }

    private void resetButtonsPosition() {
        setTranslation(0);
        setBackgroundsAlphas(0, 0);
        setBiasInCenter(standardBiasInCenter);

        handleChangeWord();
        amountTranslation = 0;
    }

    private void handleChangeWord() {
        boolean isRightSide = wordHasMovedAllRight();
        boolean isLeftSide = wordHasMovedAllLeft();

        if(!isLeftSide && !isRightSide) return;

        WordModelChanger.changeWord(
                isLeftSide
        );
    }

    private boolean wordHasMovedAllLeft() {
        return amountTranslation <= -SubmitWordButtonsView.MAX_TRANSLATION_X_PX;
    }

    private boolean wordHasMovedAllRight() {
        return amountTranslation >= SubmitWordButtonsView.MAX_TRANSLATION_X_PX;
    }

    private void setBeginTouchData(MotionEvent event) {
        savedBeginTouchX = event.getRawX();
    }

    private void setBiasInCenter(float bias) {
        ConstraintSet constraintSet = submitWordButtonsView.getConstraintSet();
        constraintSet.setHorizontalBias(binding.separatorForBackgrounds.getId(), bias);

        submitWordButtonsView.applyConstraintSet(constraintSet);
    }

    private void setTranslation(float amountTranslation) {
        binding.repeatWordImage.setTranslationX(amountTranslation);
        binding.repeatWordText.setTranslationX(amountTranslation);
        binding.submitWordImage.setTranslationX(amountTranslation);
        binding.submitWordText.setTranslationX(amountTranslation);
        binding.centerSeparator.setTranslationX(amountTranslation);
    }
}
