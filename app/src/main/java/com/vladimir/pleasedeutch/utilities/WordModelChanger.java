package com.vladimir.pleasedeutch.utilities;

import com.vladimir.pleasedeutch.databinding.ActivityMainBinding;
import com.vladimir.pleasedeutch.model.Word;

import java.util.LinkedList;
import java.util.Queue;

public class WordModelChanger {
    private static final int WORDS_AMOUNT_IN_QUEUE = 5;
    public static Queue<Word> wordQueue = new LinkedList<>();
    private static ActivityMainBinding binding;

    private WordModelChanger() {}

    public static void init(ActivityMainBinding binding) {
        WordModelChanger.binding = binding;
    }

    /**
     * Единственный публичный метод класса {@link WordModelChanger}
     * не считая метода инициализации. Используется в
     * {@link com.vladimir.pleasedeutch.listeners.OnTouchSubmitWordButtonsListener}
     * @param isLeftSide было ли слово из UI направленно в правую сторону
     * (левая сторона - слово будет добавленно в очередь для изучения,
     * правая сторона - слово будет направленно в уже выученное)
     * @see com.vladimir.pleasedeutch.views.SubmitWordButtonsView
     * */
    public static void changeWord(boolean isLeftSide) {
        handleWordSubmitDirection(isLeftSide);

        WordCardChanger.changeCard(
                wordQueueNotFilled()
                        ?
                        WordGiver.getNewWord()
                        :
                        wordQueue.poll()
        );
    }

    private static void handleWordSubmitDirection(boolean isLeftSide) {
        Word currentWord = getCurrentWordObject();

        if(isLeftSide)
            setCurrentWordInQueue(currentWord);
        else
            setCurrentWordInLearned(currentWord);
    }

    private static boolean wordQueueNotFilled() {
        return wordQueue.size() < WORDS_AMOUNT_IN_QUEUE;
    }

    private static void setCurrentWordInQueue(Word currentWord) {
        if(wordQueueNotFilled())
            wordQueue.add(currentWord);
    }

    private static void setCurrentWordInLearned(Word currentWord) {
        wordQueue.remove(currentWord);

        WordGiver.setWordLearned(currentWord);
    }

    private static Word getCurrentWordObject() {
        return WordCardChanger.getCurrentWordCardView().getCurrentWord();
    }
}
