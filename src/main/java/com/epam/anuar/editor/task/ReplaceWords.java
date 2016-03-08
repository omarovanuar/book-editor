package com.epam.anuar.editor.task;

import com.epam.anuar.editor.text.Text;

import static com.epam.anuar.editor.service.Service.*;

public class ReplaceWords {


    /**
     * exceptions:
     * - with single punctuation in beginning of sentence.
     */
    public static String replaceWords(Text text, StringBuilder sb) {
        for (int i = 0; i < getTextSize(text); i++) {
            for (int j = 0; j < getParagraphSize(text, i); j++) {
                for (int k = 0; k < getSentenceSize(text, i, j); k++) {
                    if (k == 0) {
                        replaceFirstWord(text, i, j, k, sb);
                    } else if (k == getSentenceSize(text, i ,j)-1) {
                        replaceLastWord(text, i, j, k, sb);
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
