package com.joshuasantacruz.Hanged.Project.repository;

import com.joshuasantacruz.Hanged.Project.model.Useer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UseerRepository extends JpaRepository<Useer, Integer> {
    boolean existsByUserName(String userName);
}

