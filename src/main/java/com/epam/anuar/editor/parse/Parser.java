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
        String[] sentencePartArray = value.split("(?= [a-zA-Z])");
        for (String partOfArray : sentencePartArray) {
            partOfArray = partOfArray.trim();
            SentencePart sentencePart = parseSentencePart(partOfArray);
            sentence.add(sentencePart);
        }
        return sentence;
    }

    private static SentencePart parseSentencePart(String value) {
        SentencePart sentencePart = new SentencePart();
        String[] wordArray = value.split("(?=[.,!?;:])");
        for (String partOfArray : wordArray) {
            partOfArray = partOfArray.trim();
            Word word = parseWord(partOfArray);
            sentencePart.add(word);
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
}
