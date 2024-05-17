package com.example.msgestionRdv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class rdvRes {
    private Long idr;
    private Date date;
    private String medecinNom;
    private String patientNom;
}
