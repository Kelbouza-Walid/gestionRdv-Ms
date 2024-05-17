package com.example.msgestionRdv.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
public class patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;

    @Column(length = 20)
    private String nom;

    @Column(length = 20)
    private  String email;


    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<rdv> rdvs;

}
