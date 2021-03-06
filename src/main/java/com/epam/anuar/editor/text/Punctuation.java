package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Punctuation extends SentencePart {
    public List<PunctuationChar> punctuationChars = new ArrayList<>();

    public void add(PunctuationChar punctuationChar) {
        punctuationChars.add(punctuationChar);
    }

    public String getPunctuationString(StringBuilder sb) {
        for (PunctuationChar punctuationChar : punctuationChars) {
            sb.append(punctuationChar.getPunctuationCharString());
        }
        return sb.toString();
    }

    public PunctuationChar getPunctuationChar(int index) {
        return punctuationChars.get(index);
    }
}
