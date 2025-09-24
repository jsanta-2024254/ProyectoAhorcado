package com.joshuasantacruz.Hanged.Project.service;

import com.joshuasantacruz.Hanged.Project.model.Words;

import java.util.List;

public interface WordsService {

    List<Words> getAllWords();
    Words getWordById(Integer code_word);
    Words saveWord(Words word);
    Words updateWord(Integer code_word, Words word);
    boolean deleteWord(Integer code_word);
}
