package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Text{
    public List<Sentence> sentences = new ArrayList<>();

    public void add(Sentence sentence) {
        sentences.add(sentence);
    }

    public String getParagraphString(StringBuilder sb) {
        for (int i = 0; i < sentences.size(); i++) {
            Sentence sentence = sentences.get(i);
            sentence.getSentenceString(sb);
        }
        return sb.toString();
    }

    public Sentence getSentence(int index) {
        return sentences.get(index);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
