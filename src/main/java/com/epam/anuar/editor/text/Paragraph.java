package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Text{
    List<Sentence> sentences = new ArrayList<>();

    public void add(Sentence sentence) {
        sentences.add(sentence);
    }

    public String getParagraphString(StringBuilder sb) {
        for (Sentence sentence : sentences) {
            sentence.getSentenceString(sb);
        }
        return sb.toString();
    }

    public Sentence getSentence(int index) {
        return sentences.get(index);
    }
}
