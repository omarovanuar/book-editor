package com.epam.anuar.editor;

import com.epam.anuar.editor.parse.Parser;
import com.epam.anuar.editor.text.Text;

public class Runner {

    static String value = "Hello,         ';my friend.\n" +
            "This is my text processing program! It's so simple, but very hard for me.\n" +
            "                        I hope it will be easier in future, cause i            can become crazy. My, appreciations? Ok.";
    public static void main(String[] args) {





        /*String filename = "book-ex.txt";
        Scanner scan = null;
        try {
            FileReader fl = new FileReader(filename);
            scan = new Scanner(fl);
            while (scan.hasNext()) {
                System.out.print(scan.next() + " ");
            }

        } catch (FileNotFoundException e){
            System.err.println(e);
        } finally {
            if (scan != null) {
                scan.close();
            }
        }*/

        System.out.println(value);
        System.out.println();
        Text t = Parser.parseText(value);
        StringBuilder sb = new StringBuilder();
        String string = t.getTextString(sb);
        System.out.println(string);
    }


}
