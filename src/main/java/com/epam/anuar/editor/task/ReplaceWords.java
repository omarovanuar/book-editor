package com.epam.anuar.editor.task;

import com.epam.anuar.editor.text.Text;

import static com.epam.anuar.editor.factory.TextFactory.*;

public class ReplaceWords {

    public static String replaceWords(Text text, StringBuilder sb) {
        for (int i = 0; i < getParagraphsSize(text); i++) {
            for (int j = 0; j < getSentencesSize(text, i); j++) {
                for (int k = 0; k < getSentencePartsSize(text, i, j); k++) {
                    if (k == 0) {
                        getWord(text, i, j, getSentencePartsSize(text, i ,j)-1, 0).getWordString(sb);
                        if (getWordsSize(text, i, j, k) > 1) {
                            getPunctuation(text, i, j, 0, 1).getPunctuationString(sb);
                        }
                    } else if (k == getSentencePartsSize(text, i ,j)-1) {
                        getWord(text, i, j, 0, 0).getWordString(sb);
                        if (getWordsSize(text, i, j, k) > 1) {
                            getPunctuation(text, i, j, getSentencePartsSize(text, i ,j)-1, 1).getPunctuationString(sb);
                        }
                    } else {
                        getSentencePart(text, i, j, k).getSentencePartString(sb);
                    }
                    sb.append(" ");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
