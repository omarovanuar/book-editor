package com.epam.anuar.editor.text;

public class Letter extends Word{
    private char value;

    public Letter(char value) {
        this.value = value;
    }


    public static Letter of(char value) {
        if (Cache.isSet(value)) return Cache.letterArray[value];
        return new Letter(value);
    }

    public String getLetterString() {
        return String.valueOf(value);
    }

    private static class Cache {
        static Letter[] letterArray = new Letter[65536];
        static {
            for (int i = 0; i < 127; i++) {
                letterArray[i] = new Letter((char) i);
            }
        }
        public static boolean isSet(char value) {
            return value == letterArray[value].value;
        }
    }


}
