package com.example.msgestionRdv.repositories;

import com.example.msgestionRdv.entities.medecin;
import com.example.msgestionRdv.entities.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface patientRepository extends JpaRepository<patient,Long> {
    Optional<patient> findByNom(String nomM);
}
