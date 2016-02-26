package com.epam.anuar.editor.parse;

import com.epam.anuar.editor.text.*;

public class Parser {
    public static Text parseText (String value) {
        Text text = new Text();
        String[] paragraphArray = value.split("(?<=[\\n])");
        for (String partOfArray : paragraphArray) {
            partOfArray.trim();
            Paragraph paragraph = parseParagraph(partOfArray);
            text.add(paragraph);
        }
        return text;
    }

    private static Paragraph parseParagraph (String value) {
        Paragraph paragraph = new Paragraph();
        String[] sentenceArray = value.split("(?<=[.?!])");
        for (String partOfArray : sentenceArray) {
            partOfArray.trim();
            Sentence sentence = parseSentence(partOfArray);
            paragraph.add(sentence);
        }
            return paragraph;
    }

    private static Sentence parseSentence(String value) {
        Sentence sentence = new Sentence();
        String[] WordArray = value.split("(?<=[ ])");
        for (String partOfArray : WordArray) {
            partOfArray.trim();
            Word word = parseWord(partOfArray);
            sentence.add(word);
        }
        return sentence;
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
