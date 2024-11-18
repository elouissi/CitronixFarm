package com.elouissi.sitronix.domain;

import jakarta.persistence.*;

@Entity
public class DetailRecolte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float quantite_recoltee;
    @ManyToOne
    private Arbre arbre;
    @ManyToOne
    private Recolte recolte;
}
