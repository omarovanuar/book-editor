package com.epam.anuar.editor.service;

import com.epam.anuar.editor.text.*;

public class Service {
    public static Paragraph getParagraph(Text text, int indexOfParagraph) {
        return text.getParagraph(indexOfParagraph);
    }

    public static Sentence getSentence(Text text, int indexOfParagraph, int indexOfSentence) {
        return getParagraph(text, indexOfParagraph).getSentence(indexOfSentence);
    }

    public static SentencePart getSentencePart(Text text, int indexOfParagraph, int indexOfSentence, int indexOfSentencePart) {
        return getSentence(text, indexOfParagraph, indexOfSentence).getSentencePart(indexOfSentencePart);
    }

    public static Word getWord(Text text, int indexOfParagraph, int indexOfSentence, int indexOfSentencePart, int indexOfWord) {
        return getSentencePart(text, indexOfParagraph, indexOfSentence, indexOfSentencePart).getWord(indexOfWord);
    }

    public static Punctuation getPunctuation(Text text, int indexOfParagraph, int indexOfSentence, int indexOfSentencePart, int indexOfPunctuation) {
        return getSentencePart(text, indexOfParagraph, indexOfSentence, indexOfSentencePart).getPunctuation(indexOfPunctuation);
    }

    public static Letter getLetter(Text text, int indexOfParagraph, int indexOfSentence, int indexOfSentencePart,
                                   int indexOfWord, int indexOfLetter) {
        return getWord(text, indexOfParagraph, indexOfSentence, indexOfSentencePart, indexOfWord).getLetter(indexOfLetter);
    }

    public static int getTextSize(Text text) {
        return text.getParagraphs().size();
    }

    public static int getParagraphSize(Text text, int indexOfParagraph) {
        return getParagraph(text, indexOfParagraph).getSentences().size();
    }

    public static int getSentenceSize(Text text, int indexOfParagraph, int indexOfSentence) {
        return getSentence(text, indexOfParagraph, indexOfSentence).getSentenceParts().size();
    }

    public static int getSentencePartSize(Text text, int indexOfParagraph, int indexOfSentence, int indexOfSentencePart) {
        return getSentencePart(text, indexOfParagraph, indexOfSentence, indexOfSentencePart).getWords().size();
    }

    /** Get last word in current SentencePart, that performs sequence of words and punctuation.
     * (for example in SentencePart: "<hello,,;;part'@  this method returns: part)
     *
     * @param text editing text;
     * @param indexOfParagraph index of the current Paragraph;
     * @param indexOfSentence index of the current Sentence;
     * @param indexOfSentencePart index of the current SentencePart;
     * @return last word of SentencePart.
     */

    public static Word getLastWordInSentencePart(Text text, int indexOfParagraph, int indexOfSentence, int indexOfSentencePart) {
        int notEmptyLastWordIndex = getSentencePartSize(text, indexOfParagraph, indexOfSentence, indexOfSentencePart)-1;
        for (int i = 0; i < getSentencePartSize(text, indexOfParagraph, indexOfSentence, indexOfSentencePart); i++) {
            if (getWord(text, indexOfParagraph, indexOfSentence, indexOfSentencePart,
                    notEmptyLastWordIndex).equals(SentencePart.EMPTY_WORD)) {
                notEmptyLastWordIndex--;
            } else {
                break;
            }
        }
        return getWord(text, indexOfParagraph, indexOfSentence, indexOfSentencePart, notEmptyLastWordIndex);
    }

    /** Get first word in current SentencePart, that performs sequence of words and punctuation.
     * (for example in SentencePart: "<hello,,;;part'@  this method returns: hello)
     *
     * @param text editing text;
     * @param indexOfParagraph index of the current Paragraph;
     * @param indexOfSentence index of the current Sentence;
     * @param indexOfSentencePart index of the current SentencePart;
     * @return first word of SentencePart.
     */
    public static Word getFirstWordInSentencePart(Text text, int indexOfParagraph, int indexOfSentence, int indexOfSentencePart) {
        int notEmptyFirstWordIndex = 0;
        for (int i = 0; i < getSentencePartSize(text, indexOfParagraph, indexOfSentence, indexOfSentencePart); i++) {
            if (getWord(text, indexOfParagraph, indexOfSentence, indexOfSentencePart,
                    notEmptyFirstWordIndex).equals(SentencePart.EMPTY_WORD)) {
                notEmptyFirstWordIndex++;
            } else {
                break;
            }
        }
        return getWord(text, indexOfParagraph, indexOfSentence, indexOfSentencePart, notEmptyFirstWordIndex);
    }

    /**Put last word of the sentence instead of first. Punctuations of the sentence stay origin.
     *
     * @param text editing text;
     * @param iPar index of the current Paragraph;
     * @param iSent index of the current Sentence;
     * @param iSentP index of the current SentencePart;
     * @param sb StringBuilder for new text.
     */
    public static void replaceFirstWord(Text text, int iPar, int iSent, int iSentP, StringBuilder sb) {
        if (getSentencePartSize(text, iPar, iSent, iSentP) > 1) {
            for (int l = 0; l < getSentencePartSize(text, iPar, iSent, iSentP); l++) {
                if (getPunctuation(text, iPar, iSent, iSentP, l).equals(SentencePart.EMPTY_PUNCT)) {
                    getLastWordInSentencePart(text, iPar, iSent, getSentenceSize(text, iPar ,iSent)-1).getWordString(sb);
                } else {
                    getPunctuation(text, iPar, iSent, iSentP, l).getPunctuationString(sb);
                }
            }
        } else {
            getWord(text, iPar, iSent, getSentenceSize(text, iPar ,iSent)-1, 0).getWordString(sb);
        }
    }

    /**Put first word of the sentence instead of last. Punctuations of the sentence stay origin.
     *
     * @param text editing text;
     * @param iPar index of the current Paragraph;
     * @param iSent index of the current Sentence;
     * @param iSentP index of the current SentencePart;
     * @param sb StringBuilder for new text.
     */

    public static void replaceLastWord(Text text, int iPar, int iSent, int iSentP, StringBuilder sb) {
        if (getSentencePartSize(text, iPar, iSent, iSentP) > 1) {
            for (int l = 0; l < getSentencePartSize(text, iPar, iSent, iSentP); l++) {
                if (getPunctuation(text, iPar, iSent, iSentP, l).equals(SentencePart.EMPTY_PUNCT)) {
                    getFirstWordInSentencePart(text, iPar, iSent, 0).getWordString(sb);
                } else {
                    getPunctuation(text, iPar, iSent, getSentenceSize(text, iPar ,iSent)-1, l).getPunctuationString(sb);
                }
            }
        } else {
            getWord(text, iPar, iSent, 0, 0).getWordString(sb);
        }
    }
}
