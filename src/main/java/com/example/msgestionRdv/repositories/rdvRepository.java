package com.example.msgestionRdv.repositories;

import com.example.msgestionRdv.entities.rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface rdvRepository extends JpaRepository<rdv,Long> {
}
