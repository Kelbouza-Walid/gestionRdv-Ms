package com.example.msgestionRdv.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class rdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idr;


    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medcin_id")
    private medecin medecin;

    @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "patient_id")
    private patient patient;

}
