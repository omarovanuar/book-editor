package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends Paragraph{
    List<SentencePart> sentenceParts = new ArrayList<>();

    public void add(SentencePart sentencePart) {
        sentenceParts.add(sentencePart);
    }

    public int getSentencePartsSize() {
        int counter = 0;
        for (SentencePart s : sentenceParts) {
            if (s != null) {
                counter++;
            }
        }
        return counter;
    }

    public String getSentenceString(StringBuilder sb) {
        for (SentencePart sentencePart : sentenceParts) {
            sentencePart.getSentencePartString(sb);
            sb.append(" ");
        }
        return sb.toString();
    }

    public SentencePart getSentencePart(int index) {
        return sentenceParts.get(index);
    }
}
