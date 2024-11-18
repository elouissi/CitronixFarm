package com.elouissi.sitronix.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Arbre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate date_plantation;
    @ManyToOne
    private Champ champ;
    @OneToMany
    private List<DetailRecolte> detailRecoltes;
}
