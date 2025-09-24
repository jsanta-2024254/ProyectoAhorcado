package com.joshuasantacruz.Hanged.Project.service;

import com.joshuasantacruz.Hanged.Project.model.Words;
import com.joshuasantacruz.Hanged.Project.repository.WordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsServiceImplements implements WordsService {

    private final WordsRepository wordsRepository;

    public WordsServiceImplements(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    @Override
    public List<Words> getAllWords() {
        return wordsRepository.findAll();
    }

    @Override
    public Words getWordById(Integer code_word) {
        return wordsRepository.findById(code_word).orElse(null);
    }

    @Override
    public Words saveWord(Words word) {
        return wordsRepository.save(word);
    }

    @Override
    public Words updateWord(Integer code_word, Words word) {
        Words existingWord = wordsRepository.findById(code_word).orElse(null);
        if (existingWord != null) {
            existingWord.setWord(word.getWord());
            existingWord.setHint(word.getHint());
            return wordsRepository.save(existingWord);
        }
        return null;
    }

    @Override
    public boolean deleteWord(Integer code_word) {
        wordsRepository.deleteById(code_word);
        return false;
    }
}
