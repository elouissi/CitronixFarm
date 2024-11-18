package com.elouissi.sitronix.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate date_vente;
    private String client;
    private Float revenu;
    private Float quantite;
    private Float prix_unitaire;
    @ManyToOne
    private Recolte recolte;

}
