package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends Paragraph{
    List<SentencePart> sentenceParts = new ArrayList<>();

    public void add(SentencePart sentencePart) {
        sentenceParts.add(sentencePart);
    }

    public String getSentenceString(StringBuilder sb) {
        for (SentencePart sentencePart : sentenceParts) {
            sentencePart.getSentencePartString(sb);
            sb.append(" ");
        }
        return sb.toString();
    }
}
