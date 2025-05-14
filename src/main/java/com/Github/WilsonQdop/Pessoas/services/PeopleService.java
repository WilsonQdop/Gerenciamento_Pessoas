package com.Github.WilsonQdop.Pessoas.services;

import com.Github.WilsonQdop.Pessoas.dtos.PeoplesDTO;
import com.Github.WilsonQdop.Pessoas.entities.PeoplesEntity;
import com.Github.WilsonQdop.Pessoas.exceptions.PeopleNotFoundException;
import com.Github.WilsonQdop.Pessoas.repositories.PeoplesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PeopleService {

    @Autowired
    private PeoplesRepository peoplesRepository;

    public PeoplesEntity findPeople(UUID id) {
        return this.peoplesRepository.findById(id).
                orElseThrow(() -> new PeopleNotFoundException("Pessoa com id " + id + " não encontrado"));
    }

    public PeoplesEntity createPeople (PeoplesEntity data) {
        PeoplesEntity newPeople = new PeoplesEntity();

        newPeople.setName(data.getName());
        newPeople.setCpf(data.getCpf());
        newPeople.setYear(data.getYear());

        return this.peoplesRepository.save(newPeople);
    }

    public void deletePeople(UUID id) {
        PeoplesEntity people = this.findPeople(id);

        this.peoplesRepository.delete(people);
    }

    public PeoplesEntity updatePeople (PeoplesEntity people, UUID id) {
        PeoplesEntity updatePeople = this.findPeople(id);

        updatePeople.setName(people.getName());
        updatePeople.setCpf(people.getCpf());
        updatePeople.setYear(people.getYear());

        return this.peoplesRepository.save(updatePeople);

    }
}
