package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class SentencePart extends Sentence{
    public List<Word> words = new ArrayList<>();
    public List<Punctuation> punctuations = new ArrayList<>();
    public static final Word EMPTY_WORD = new Word();
    public static final Punctuation EMPTY_PUNCT = new Punctuation();

    public void add(Word word) {
        words.add(word);
    }
    public void add(Punctuation punctuation) {
        punctuations.add(punctuation);

    }

    public String getSentencePartString(StringBuilder sb) {
        for (int i = 0; i < Math.max(words.size(), punctuations.size()); i++) {
            if (i < words.size()) words.get(i).getWordString(sb);
            if (i < punctuations.size()) punctuations.get(i).getPunctuationString(sb);
        }
        return sb.toString();
    }

    public Word getWord(int index) {
        return words.get(index);
    }

    public Punctuation getPunctuation(int index) {
        return punctuations.get(index);
    }

    public List<Word> getWords() {
        return words;
    }

    public List<Punctuation> getPunctuations() {
        return punctuations;
    }
}
