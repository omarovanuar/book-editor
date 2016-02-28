package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends Paragraph{
    List<SentencePart> sentenceParts = new ArrayList<SentencePart>();

    public void add(SentencePart sentencePart) {
        sentenceParts.add(sentencePart);
    }

    public String getSentenceString(StringBuilder sb) {
        for (int i = 0; i < sentenceParts.size(); i++) {
            sentenceParts.get(i).getSentencePartString(sb);
            sb.append(" ");
        }
        return sb.toString();
    }
}
