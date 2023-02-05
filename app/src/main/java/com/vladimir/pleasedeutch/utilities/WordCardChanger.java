package com.vladimir.pleasedeutch.utilities;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.vladimir.pleasedeutch.R;
import com.vladimir.pleasedeutch.databinding.ActivityMainBinding;
import com.vladimir.pleasedeutch.model.Word;
import com.vladimir.pleasedeutch.views.WordCardView;

public class WordCardChanger {
    private static com.vladimir.pleasedeutch.databinding.ActivityMainBinding binding;
    private static boolean isSecondCardOnDisplay = true;
    private static Animation fadeAnimation;
    private static Animation appearanceAnimation;

    public static void init(ActivityMainBinding binding) {
        WordCardChanger.binding = binding;

        fadeAnimation = AnimationUtils.loadAnimation(
                binding.getRoot().getContext(),
                R.anim.card_fade_anim
        );
        appearanceAnimation = AnimationUtils.loadAnimation(
                binding.getRoot().getContext(),
                R.anim.card_appearance_anim
        );

        fadeAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                getCurrentWordCardView().closeAllExampleSentences();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        appearanceAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                getCurrentWordCardView().closeAllExampleSentences();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public static void changeCard() {
        isSecondCardOnDisplay = !isSecondCardOnDisplay;

        startAnimationsChange();
    }

    private static void startAnimationsChange() {
        if(isSecondCardOnDisplay) {
            binding.wordCardViewSecond.startAnimation(appearanceAnimation);
            binding.wordCardViewFirst.startAnimation(fadeAnimation);
        } else {
            binding.wordCardViewFirst.startAnimation(appearanceAnimation);
            binding.wordCardViewSecond.startAnimation(fadeAnimation);
        }
    }

    public static WordCardView getCurrentWordCardView() {
        return isSecondCardOnDisplay
                ?
                binding.wordCardViewSecond
                :
                binding.wordCardViewFirst;
    }

    public static void setWordInCards(Word word) {
        getCurrentWordCardView().setWord(word);

        binding.wordCardViewFirst.getAnimation().setAnimationListener(
                new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        binding.wordCardViewFirst.setWord(word);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                }
        );
    }
}
