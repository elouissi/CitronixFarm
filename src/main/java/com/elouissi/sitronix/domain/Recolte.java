package com.elouissi.sitronix.domain;

import com.elouissi.sitronix.domain.enums.Saison;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Recolte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Float quantite_totale ;
    private LocalDate date_recolte;

    @Enumerated(EnumType.STRING)
    private Saison saison;
    @OneToMany
    private List<DetailRecolte> detailRecoltes;
    @OneToMany
    private List<Vente> ventes;
}
