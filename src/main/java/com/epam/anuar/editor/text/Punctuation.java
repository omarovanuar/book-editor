package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Punctuation extends SentencePart {
    List<PunctuationChar> punctuationChars = new ArrayList<>();

    public void add(PunctuationChar punctuationChar) {
        punctuationChars.add(punctuationChar);
    }

    public String getPunctuationString(StringBuilder sb) {
        for (PunctuationChar punctuationChar : punctuationChars) {
            sb.append(punctuationChar.getPunctuationCharString());
        }
        return sb.toString();
    }
}
