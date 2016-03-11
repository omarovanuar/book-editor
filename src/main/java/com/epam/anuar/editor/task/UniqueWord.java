package com.epam.anuar.editor.task;

import com.epam.anuar.editor.service.Service;
import com.epam.anuar.editor.text.SentencePart;
import com.epam.anuar.editor.text.Text;
import com.epam.anuar.editor.text.Word;

import static com.epam.anuar.editor.service.Service.*;

public class UniqueWord {
    public static String findUniqueWord(Text text, StringBuilder sb) {
        for (int i = 0; i < getSentenceSize(text, 0 ,0); i++) {
            for (int j = 0; j < getSentencePartSize(text, 0, 0, i); j++) {
                if (getWord(text, 0, 0, i, j) != SentencePart.EMPTY_WORD) {
                    String unique = getWord(text, 0, 0, i, j).getWordString(new StringBuilder());
                    compareUniqueWord(text, unique, sb);
                }
            }
        }
        return sb.toString();
    }

    public static void compareUniqueWord(Text text, String unique, StringBuilder sb) {
        StringBuilder tempSb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < getTextSize(text); i++) {
            for (int j = 0; j < getParagraphSize(text, i); j++) {
                if (i == 0 && j == 0) {
                    i++;
                }
                for (int k = 0; k < getSentenceSize(text, i, j); k++) {
                    for (int l = 0; l < getSentencePartSize(text, i, j, k); l++) {
                        if (getWord(text, i, j, k, l) != SentencePart.EMPTY_WORD) {
                            if (unique.equalsIgnoreCase(getWord(text, i, j, k, l).getWordString(tempSb))) {
                                count++;
                                break;
                            }
                            tempSb.setLength(0);
                        } else break;
                    }
                }
            }
        }

        if (count == 0) {
            sb.append(unique + "\n");
        }
    }
}
