package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Word extends SentencePart{
    List<Letter> letters = new ArrayList<Letter>();

    public void add(Letter letter) {
        letters.add(letter);
    }

    public String getWordString(StringBuilder sb) {
        for (int i = 0; i < letters.size(); i++) {
            sb.append(letters.get(i).getLetterString());
        }
        return sb.toString();
    }


}
