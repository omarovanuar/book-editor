package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends Paragraph{
    List<Word> words = new ArrayList<Word>();

    public void add(Word sentencePart) {
        words.add(sentencePart);
    }

    public String getSentenceString(StringBuilder sb) {
        for (int i = 0; i < words.size(); i++) {
            words.get(i).getWordString(sb);
            sb.append(" ");
        }
        return sb.toString();
    }
}
