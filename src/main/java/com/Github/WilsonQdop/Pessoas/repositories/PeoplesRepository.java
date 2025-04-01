package com.Github.WilsonQdop.Pessoas.repositories;


import com.Github.WilsonQdop.Pessoas.entities.PeoplesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PeoplesRepository extends JpaRepository<PeoplesEntity, UUID> {
}
