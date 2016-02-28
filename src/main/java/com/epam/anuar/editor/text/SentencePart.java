package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class SentencePart extends Sentence{
    List<Word> words = new ArrayList<Word>();

    public void add(Word word) {
        words.add(word);
    }

    public String getSentencePartString(StringBuilder sb) {
        for (int i = 0; i < words.size(); i++) {
            words.get(i).getWordString(sb);
        }
        return sb.toString();
    }
}
