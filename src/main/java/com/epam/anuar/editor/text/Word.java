package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Word extends SentencePart{
    public List<Letter> letters = new ArrayList<>();

    public void add(Letter letter) {
        letters.add(letter);
    }

    public String getWordString(StringBuilder sb) {
        for (Letter letter : letters) {
            sb.append(letter.getLetterString());
        }
        return sb.toString();
    }

    public Letter getLetter(int index) {
        return letters.get(index);
    }
}
