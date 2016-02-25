package com.epam.anuar.editor.text;

import java.util.ArrayList;
import java.util.List;

public abstract class SentencePart extends Sentence{
    List<Word> words = new ArrayList<Word>();
    List<PunctuationMark> punctuationMarks = new ArrayList<PunctuationMark>();
}
