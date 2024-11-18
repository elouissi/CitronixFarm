package com.elouissi.sitronix.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Ferme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private Float superficie;
    private LocalDate date_creation;
    private String localisation;
    @OneToMany
    private List<Champ> champs;
}
