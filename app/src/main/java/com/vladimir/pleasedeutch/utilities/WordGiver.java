package com.vladimir.pleasedeutch.utilities;

import com.vladimir.pleasedeutch.model.Word;

import java.util.ArrayList;
import java.util.List;

public class WordGiver {
    public static List<Word> allWords = new ArrayList<>();
    public static List<Word> learnedWords = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            allWords.add(
                    new Word(
                            "слово" + i,
                            "word" + i,
                            "Топ " + i
                    )
            );
        }
    }

    private WordGiver() {}

    public static Word getNewWord() {
        return allWords.remove((int) (Math.random() * allWords.size()));
    }

    public static void setWordLearned(Word word) {
        learnedWords.add(word);
    }
}
