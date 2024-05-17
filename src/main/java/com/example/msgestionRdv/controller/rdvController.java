package com.example.msgestionRdv.controller;

import com.example.msgestionRdv.dto.rdvReq;
import com.example.msgestionRdv.dto.rdvRes;
import com.example.msgestionRdv.services.RdvService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rdv")

public class rdvController {

    private final RdvService rdvService;

    public rdvController(RdvService rdvService) {
        this.rdvService = rdvService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRdv(@RequestBody rdvReq rdvReq) {
        rdvService.createRdv(rdvReq);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rendez-vous créé avec succès.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<rdvRes>> getAllRdv() {
        List<rdvRes> allRdv = rdvService.getAllRdv();
        return ResponseEntity.ok().body(allRdv);
    }


}
