package com.example.msgestionRdv.repositories;

import com.example.msgestionRdv.entities.medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource
public interface medecinRepository extends JpaRepository<medecin,Long> {
    Optional<medecin> findByNomM(String nomM);
    Optional<medecin> findByWilaya(String wilaya);
}
