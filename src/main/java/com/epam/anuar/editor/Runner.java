package com.epam.anuar.editor;

import com.epam.anuar.editor.text.Text;

public class Runner {
    /*public static void main(String[] args) {
        String filename = "book-ex.txt";
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
        }
    }*/
    public static char[] ch = new char[128];

    public static void main(String[] args) {

        for (int i = 0; i < 127; i++) {
            ch[i] = (char) i;
            System.out.println(ch[i]);
        }

    }
}
