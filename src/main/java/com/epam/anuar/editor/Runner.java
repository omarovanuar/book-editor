package com.epam.anuar.editor;

import com.epam.anuar.editor.parse.Parser;
import com.epam.anuar.editor.task.ReplaceWords;
import com.epam.anuar.editor.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        String filename = "book-ex.txt";
        String value = "";
        String tmp;
        FileReader fr = null;
        BufferedReader br;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            while ((tmp = br.readLine()) != null){
                value += tmp + "\n";
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fr != null) {
                fr.close();
            }
        }


        System.out.println(value);
        Text t = Parser.parseText(value);
        System.out.println(t.getTextString(new StringBuilder()));
        System.out.println(ReplaceWords.replaceWords(t, new StringBuilder()));
    }


}
