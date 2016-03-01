package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Text {
    List<Paragraph> paragraphs = new ArrayList<>();

    public void add(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public String getTextString(StringBuilder sb) {
        for (Paragraph paragraph : paragraphs) {
            paragraph.getParagraphString(sb);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Paragraph getParagraph(int index) {
        return paragraphs.get(index);
    }

}
