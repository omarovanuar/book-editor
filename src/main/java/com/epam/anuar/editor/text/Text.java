package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public class Text {
    List<Paragraph> paragraphs = new ArrayList<Paragraph>();

    public void add(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public String getTextString(StringBuilder sb) {
        for (int i = 0; i < paragraphs.size(); i++) {
            paragraphs.get(i).getParagraphString(sb);
            sb.append("\n");
        }
        return sb.toString();
    }

}
