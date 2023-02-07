package com.vladimir.pleasedeutch.utilities;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.vladimir.pleasedeutch.R;
import com.vladimir.pleasedeutch.activities.MainActivity;
import com.vladimir.pleasedeutch.databinding.ActivityMainBinding;
import com.vladimir.pleasedeutch.model.Word;
import com.vladimir.pleasedeutch.views.WordCardView;

public class WordCardChanger {
    private static com.vladimir.pleasedeutch.databinding.ActivityMainBinding binding;
    private static Animation fadeAnimation;
    private static Animation appearanceAnimation;
    private static WordCardView appearanceWordCard;
    private static WordCardView currentWordCard;
    private static ViewGroup.LayoutParams targetLayoutParams;

    private WordCardChanger() {}

    public static void init(ActivityMainBinding binding) {
        WordCardChanger.binding = binding;
        currentWordCard = binding.wordCardViewCurrent;
        targetLayoutParams = binding.wordCardViewCurrent.getLayoutParams();

        fadeAnimation = AnimationUtils.loadAnimation(
                binding.getRoot().getContext(),
                R.anim.card_fade_anim
        );
        appearanceAnimation = AnimationUtils.loadAnimation(
                binding.getRoot().getContext(),
                R.anim.card_appearance_anim
        );
    }

    public static void changeCard(Word newWord) {
        updateAppearanceWordCard(newWord);
        appearanceWordCard.setVisibility(View.VISIBLE);
        appearanceWordCard.startAnimation(appearanceAnimation);

        currentWordCard.startAnimation(fadeAnimation);

        binding.getRoot().postDelayed(() -> {
            binding.getRoot().removeView(currentWordCard);
            currentWordCard = appearanceWordCard;
        }, appearanceAnimation.getDuration() + 200);
    }

    private static void updateAppearanceWordCard(Word newWord) {
        WordCardView wordCardView = new WordCardView(MainActivity.binding.getRoot().getContext());
        wordCardView.setLayoutParams(targetLayoutParams);
        wordCardView.setWord(newWord);
        wordCardView.setVisibility(View.GONE);
        binding.getRoot().addView(wordCardView, 0);
        appearanceWordCard = wordCardView;
    }

    public static WordCardView getCurrentWordCardView() {
        return currentWordCard;
    }
}
