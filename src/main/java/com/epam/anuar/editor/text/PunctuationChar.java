package com.epam.anuar.editor.text;

public class PunctuationChar extends Punctuation {
    private char value;

    public PunctuationChar(char value) {
        this.value = value;
    }


    public static PunctuationChar of(char value) {
        if (Cache.isSet(value)) return Cache.punctuationCharArray[value];
        return new PunctuationChar(value);
    }

    public String getPunctuationCharString() {
        return String.valueOf(value);
    }

    private static class Cache {
        static PunctuationChar[] punctuationCharArray = new PunctuationChar[65536];
        static {
            for (int i = 0; i < 127; i++) {
                punctuationCharArray[i] = new PunctuationChar((char) i);
            }
        }
        public static boolean isSet(char value) {
            return value == punctuationCharArray[value].value;
        }
    }
}
