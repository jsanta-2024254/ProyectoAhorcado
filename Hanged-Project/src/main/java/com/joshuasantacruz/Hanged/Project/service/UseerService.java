package com.joshuasantacruz.Hanged.Project.service;

import com.joshuasantacruz.Hanged.Project.model.Useer;

import java.util.List;

public interface UseerService {

    List<Useer> getAllUseers();

    List<Useer> getAll();
    Useer getUseerById(Integer user_code);
    Useer savedUseer (Useer useer);
    Useer updateUseer (Integer code_user, Useer useer);
    boolean deleteUseer(Integer id);
}
