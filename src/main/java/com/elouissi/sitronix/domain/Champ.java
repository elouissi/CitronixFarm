package com.elouissi.sitronix.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Champ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float superficie;
    @ManyToOne
    private Ferme ferme;
    @OneToMany
    private List<Arbre> arbres;
}
