package com.vladimir.pleasedeutch.utilities;

import com.vladimir.pleasedeutch.databinding.ActivityMainBinding;
import com.vladimir.pleasedeutch.model.Word;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordModelChanger {
    private static final int WORDS_AMOUNT_IN_QUEUE = 5;
    public static Queue<Word> wordQueue = new LinkedList<>();
    public static List<Word> allWord = new ArrayList<>();
    private static ActivityMainBinding binding;

    private WordModelChanger() {}

    static {
        for (int i = 0; i < 10; i++) {
            allWord.add(
                    new Word(
                    "слово" + i,
                    "word" + i,
                    "Топ " + i
                    )
            );
        }
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

        WordCardChanger.changeCard();

        setCurrentWordObject(
                wordQueueNotFilled() ?
                        getNewRandomWord()
                        :
                        wordQueue.poll()
        );
    }

    private static Word getNewRandomWord() {
        //TODO Change to call
        // return WordGiver.getNewWord()
        int randomIndex = (int) (Math.random() * allWord.size());
        Word randomWord = allWord.get(randomIndex);

        allWord.remove(randomIndex);

        if(randomWord != getCurrentWord() && randomWord != null) {
            return randomWord;
        }
        return getNewRandomWord();
    }

    private static void handleWordSubmitDirection(boolean isLeftSide) {
        if(isLeftSide)
            setCurrentWordInQueue();
        else
            setCurrentWordInLearned();
    }

    private static boolean wordQueueNotFilled() {
        return wordQueue.size() < WORDS_AMOUNT_IN_QUEUE;
    }

    private static void setCurrentWordInQueue() {
        if(wordQueueNotFilled())
            wordQueue.add(getCurrentWord());
    }

    private static void setCurrentWordInLearned() {
        wordQueue.remove(
                getCurrentWord()
        );

        //TODO Change to call
        // WordGiver.setWordLearned(
        //     getCurrentWord()
        // )
    }

    private static void setCurrentWordObject(Word word) {
        WordCardChanger.setWordInCards(word);
    }

    private static Word getCurrentWord() {
        return WordCardChanger.getCurrentWordCardView().getCurrentWord();
    }

    public static void init(ActivityMainBinding binding) {
        WordModelChanger.binding = binding;
    }
}
