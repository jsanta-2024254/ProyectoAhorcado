package com.joshuasantacruz.Hanged.Project.service;

import com.joshuasantacruz.Hanged.Project.model.Useer;
import com.joshuasantacruz.Hanged.Project.repository.UseerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseerServiceImplements implements UseerService {

    private final UseerRepository useerRepository;


    public UseerServiceImplements(UseerRepository useerRepository) {
        this.useerRepository = useerRepository;
    }

    @Override
    public List<Useer> getAllUseers() {
        return useerRepository.findAll();
    }

    @Override
    public Useer getUseerById(Integer user_code) {
        return useerRepository.findById(user_code).orElse(null);
    }

    @Override
    public Useer savedUseer(Useer useer) {
        if (useerRepository.existsByUserName(useer.getUserName())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }
        return useerRepository.save(useer);
    }

    @Override
    public Useer updateUseer(Integer code_user, Useer useer) {
        Useer existing = useerRepository.findById(code_user)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!existing.getUserName().equals(useer.getUserName()) &&
                useerRepository.existsByUserName(useer.getUserName())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }

        existing.setUserName(useer.getUserName());
        existing.setUserPassword(useer.getUserPassword());
        return useerRepository.save(existing);
    }

    @Override
    public boolean deleteUseer(Integer id) {
        useerRepository.deleteById(id);
        return false;
    }

    @Override
    public List<Useer> getAll() {
        return useerRepository.findAll();
    }
}
