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
    @OneToOne
    private Recolte recolte;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(LocalDate date_vente) {
        this.date_vente = date_vente;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Float getRevenu() {
        return revenu;
    }

    public void setRevenu(Float revenu) {
        this.revenu = revenu;
    }

    public Float getQuantite() {
        return quantite;
    }

    public void setQuantite(Float quantite) {
        this.quantite = quantite;
    }

    public Float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public Recolte getRecolte() {
        return recolte;
    }

    public void setRecolte(Recolte recolte) {
        this.recolte = recolte;
    }


}
