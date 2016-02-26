package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Text{
    List<Sentence> sentences = new ArrayList<Sentence>();

    public void add(Sentence sentence) {
        sentences.add(sentence);
    }

    public String getParagraphString(StringBuilder sb) {
        for (int i = 0; i < sentences.size(); i++) {
            sentences.get(i).getSentenceString(sb);
        }
        return sb.toString();
    }
}
