package com.elouissi.sitronix.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailRecolte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQuantite_recoltee() {
        return quantite_recoltee;
    }

    public void setQuantite_recoltee(Float quantite_recoltee) {
        this.quantite_recoltee = quantite_recoltee;
    }

    public Arbre getArbre() {
        return arbre;
    }

    public void setArbre(Arbre arbre) {
        this.arbre = arbre;
    }

    public Recolte getRecolte() {
        return recolte;
    }

    public void setRecolte(Recolte recolte) {
        this.recolte = recolte;
    }

    private Float quantite_recoltee;
    @ManyToOne
    private Arbre arbre;
    @ManyToOne
    private Recolte recolte;
}
