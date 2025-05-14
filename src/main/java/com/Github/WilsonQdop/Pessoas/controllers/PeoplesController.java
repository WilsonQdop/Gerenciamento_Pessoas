package com.Github.WilsonQdop.Pessoas.controllers;

import com.Github.WilsonQdop.Pessoas.dtos.PeoplesDTO;
import com.Github.WilsonQdop.Pessoas.entities.PeoplesEntity;
import com.Github.WilsonQdop.Pessoas.repositories.PeoplesRepository;
import com.Github.WilsonQdop.Pessoas.services.PeopleService;
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
    private PeopleService peopleService;

    @PostMapping
    public ResponseEntity<PeoplesEntity> createPeople(@RequestBody PeoplesEntity data) {
        PeoplesEntity newPeople = this.peopleService.createPeople(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPeople);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeoplesEntity> findPeople(@PathVariable UUID id) {
        PeoplesEntity findPeople = this.peopleService.findPeople(id);

        return ResponseEntity.status(HttpStatus.OK).body(findPeople);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePeople(@PathVariable UUID id) {
        this.peopleService.deletePeople(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PeoplesEntity> updatePeople(@PathVariable UUID id, @RequestBody PeoplesEntity data) {
        PeoplesEntity people = this.peopleService.updatePeople(data, id);
        return ResponseEntity.status(HttpStatus.OK).body(people);
    }

}
