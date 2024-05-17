package com.example.msgestionRdv;

import com.example.msgestionRdv.entities.medecin;
import com.example.msgestionRdv.entities.patient;
import com.example.msgestionRdv.entities.rdv;
import com.example.msgestionRdv.repositories.medecinRepository;
import com.example.msgestionRdv.repositories.patientRepository;
import com.example.msgestionRdv.repositories.rdvRepository;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@SpringBootApplication

public class MsGestionRdvApplication implements CommandLineRunner {

	@Resource
	medecinRepository medecinRepository;

	@Resource
	patientRepository patientRepository;

	@Resource
	rdvRepository rdvRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsGestionRdvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		medecin med1 = medecinRepository.save(new medecin(null,"Dr walid","Tlemcen","walid@gmail.com",null));

		medecin med2 = medecinRepository.save(new medecin(null,"Dr moh","Mostaganem","moh@gmail.com",null));

		patient pat1=patientRepository.save(new patient(null,"brahim","brahim@gmail.com",null));
		patient pat2=patientRepository.save(new patient(null,"wassim","wassim@gmail.com",null));



	}
}
