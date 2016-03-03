package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Text {
    public List<Paragraph> paragraphs = new ArrayList<>();

    public void add(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public String getTextString(StringBuilder sb) {
        for (int i = 0; i < paragraphs.size(); i++) {
            Paragraph paragraph = paragraphs.get(i);
            paragraph.getParagraphString(sb);
            sb.append("\n");
        }
        return sb.toString();
    }


    public Paragraph getParagraph(int index) {
        return paragraphs.get(index);
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }
}
