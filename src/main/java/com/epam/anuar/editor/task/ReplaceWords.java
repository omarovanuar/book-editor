package com.epam.anuar.editor.task;

import com.epam.anuar.editor.text.SentencePart;
import com.epam.anuar.editor.text.Text;

import static com.epam.anuar.editor.service.Service.*;

public class ReplaceWords {

    public static String replaceWords(Text text, StringBuilder sb) {
        for (int i = 0; i < getTextSize(text); i++) {
            for (int j = 0; j < getParagraphSize(text, i); j++) {
                for (int k = 0; k < getSentenceSize(text, i, j); k++) {
                    if (k == 0) {
                        if (getSentencePartSize(text, i, j, k) > 1) {
                            for (int l = 0; l < getSentencePartSize(text, i, j, k); l++) {
                                if (getPunctuation(text, i, j, k, l).equals(SentencePart.EMPTY_PUNCT)) {
                                    getLastWordInSentencePart(text, i, j, getSentenceSize(text, i ,j)-1).getWordString(sb);
                                } else {
                                    getPunctuation(text, i, j, k, l).getPunctuationString(sb);
                                }
                            }
                        } else {
                            getWord(text, i, j, getSentenceSize(text, i ,j)-1, 0).getWordString(sb);
                        }
                    } else if (k == getSentenceSize(text, i ,j)-1) {
                        if (getSentencePartSize(text, i, j, k) > 1) {
                            for (int l = 0; l < getSentencePartSize(text, i, j, k); l++) {
                                if (getPunctuation(text, i, j, k, l).equals(SentencePart.EMPTY_PUNCT)) {
                                    getFirstWordInSentencePart(text, i, j, 0).getWordString(sb);
                                } else {
                                    getPunctuation(text, i, j, getSentenceSize(text, i ,j)-1, l).getPunctuationString(sb);
                                }
                            }
                        } else {
                            getWord(text, i, j, 0, 0).getWordString(sb);
                        }
                    } else {
                        getSentencePart(text, i, j, k).getSentencePartString(sb);
                    }
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
