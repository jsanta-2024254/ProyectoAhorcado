package com.joshuasantacruz.Hanged.Project.repository;

import com.joshuasantacruz.Hanged.Project.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<Words, Integer> {
}
