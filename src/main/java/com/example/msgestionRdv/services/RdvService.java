package com.example.msgestionRdv.services;

import com.example.msgestionRdv.dto.rdvReq;
import com.example.msgestionRdv.dto.rdvRes;
import com.example.msgestionRdv.entities.medecin;
import com.example.msgestionRdv.entities.patient;
import com.example.msgestionRdv.entities.rdv;
import com.example.msgestionRdv.repositories.medecinRepository;
import com.example.msgestionRdv.repositories.patientRepository;
import com.example.msgestionRdv.repositories.rdvRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RdvService {

    private final rdvRepository rdvRepository;
    private final medecinRepository medecinRepository;
    private final patientRepository patientRepository;

    public void createRdv(rdvReq rdvReq) {

        Optional<medecin> medecinOptional = medecinRepository.findByNomM(rdvReq.getMedecinNom());
        Optional<patient> patientOptional = patientRepository.findByNom(rdvReq.getPatientNom());

        if (medecinOptional.isPresent() ) {
            medecin medecin = medecinOptional.get();
            patient patient = patientOptional.get();

            rdv Rdv = rdv.builder()
                    .date(rdvReq.getDate())
                    .medecin(medecin)
                    .patient(patient)
                    .build();


            rdv savedRdv = rdvRepository.save(Rdv);
            log.info("Rdv {} is saved", savedRdv.getIdr());
        } else {
            log.error("Médecin ou patient introuvable pour créer le rendez-vous");
        }
    }

    public List<rdvRes> getAllRdv(){
        List<rdv> rdvs = rdvRepository.findAll();
        return rdvs.stream().map(this::mapToRdvRes).collect(Collectors.toList());
    }

    private rdvRes mapToRdvRes(rdv rdv) {
        rdvRes rdvRes = new rdvRes();
        rdvRes.setIdr(rdv.getIdr());
        rdvRes.setDate((Date) rdv.getDate());

        if (rdv.getMedecin() != null) {
            rdvRes.setMedecinNom(rdv.getMedecin().getNomM());
        }


        if (rdv.getPatient() != null) {
            rdvRes.setPatientNom(rdv.getPatient().getNom());
        }

        return rdvRes;
    }
}
