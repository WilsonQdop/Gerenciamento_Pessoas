package com.Github.WilsonQdop.Pessoas.controllers;

import com.Github.WilsonQdop.Pessoas.dtos.PeoplesDTO;
import com.Github.WilsonQdop.Pessoas.entities.PeoplesEntity;
import com.Github.WilsonQdop.Pessoas.repositories.PeoplesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/peoples")
public class PeoplesController {

    @Autowired
    private PeoplesRepository peoplesRepository;

    @PostMapping
    public ResponseEntity<PeoplesEntity> addPeople (@RequestBody PeoplesDTO peoplesDTO) {
        PeoplesEntity people = new PeoplesEntity();
        BeanUtils.copyProperties(peoplesDTO, people);

        PeoplesEntity savedPeople = this.peoplesRepository.save(people);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPeople);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> returnPeople (@PathVariable UUID id) {
        Optional<PeoplesEntity> foundPeople = this.peoplesRepository.findById(id);

        return foundPeople.<ResponseEntity<Object>>map(peoplesEntity -> ResponseEntity.status(HttpStatus.OK).body(peoplesEntity))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada! "));
    }

}
