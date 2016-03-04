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

    //unfinished method
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


}
