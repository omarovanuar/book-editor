package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class SentencePart extends Sentence{
    List<Word> words = new ArrayList<>();
    List<Punctuation> punctuations = new ArrayList<>();

    public void add(Word word) {
        words.add(word);
    }
    public void add(Punctuation punctuation) {
        punctuations.add(punctuation);
    }

    public String getSentencePartString(StringBuilder sb) {
        for (int i = 0; i < Math.max(words.size(), punctuations.size()); i++) {
            words.get(i).getWordString(sb);
            if (punctuations.size() != 0) punctuations.get(i).getPunctuationString(sb);
        }
        return sb.toString();
    }
}
