package com.epam.anuar.editor.parse;

import com.epam.anuar.editor.text.*;

public class Parser {
    public static Text parseText (String value) {
        Text text = new Text();
        String[] paragraphArray = value.split("(?<=[\\n])");
        for (String partOfArray : paragraphArray) {
            partOfArray = partOfArray.trim();
            Paragraph paragraph = parseParagraph(partOfArray);
            text.add(paragraph);
        }
        return text;
    }

    private static Paragraph parseParagraph (String value) {
        Paragraph paragraph = new Paragraph();
        String[] sentenceArray = value.split("(?<=[.?!])");
        for (String partOfArray : sentenceArray) {
            partOfArray = partOfArray.trim();
            Sentence sentence = parseSentence(partOfArray);
            paragraph.add(sentence);
        }
            return paragraph;
    }

    private static Sentence parseSentence(String value) {
        Sentence sentence = new Sentence();
        String[] sentencePartArray = value.split("(?= [a-zA-Z\\p{Punct}])");
        for (String partOfArray : sentencePartArray) {
            partOfArray = partOfArray.trim();
            SentencePart sentencePart = parseSentencePart(partOfArray);
            sentence.add(sentencePart);
        }
        return sentence;
    }

    private static SentencePart parseSentencePart(String value) {
        SentencePart sentencePart = new SentencePart();
        String[] wordAndPunctArray = value.split("(?<=[\\p{Punct}])|(?=[\\p{Punct}])");
        for (int i = 0; i < wordAndPunctArray.length; i++) {
            String partOfArray = wordAndPunctArray[i];
            partOfArray = partOfArray.trim();


            if (partOfArray.matches("[\\p{Punct}]")){
                Punctuation punctuation = parsePunctuation(partOfArray);
                sentencePart.add(punctuation);
                sentencePart.add(SentencePart.EMPTY_WORD);
            } else {
                Word word = parseWord(partOfArray);
                sentencePart.add(word);
                sentencePart.add(SentencePart.EMPTY_PUNCT);
            }
        }
        return sentencePart;
    }

    private static Word parseWord(String value) {
        Word word = new Word();
        char[] CharArray = value.toCharArray();
        for (char partOfArray : CharArray) {
            Letter letter = Letter.of(partOfArray);
            word.add(letter);
        }
        return word;
    }

    private static Punctuation parsePunctuation(String value) {
        Punctuation punctuation = new Punctuation();
        char[] CharArray = value.toCharArray();
        for (char partOfArray : CharArray) {
            PunctuationChar punctuationChar = PunctuationChar.of(partOfArray);
            punctuation.add(punctuationChar);
        }
        return punctuation;
    }
}
