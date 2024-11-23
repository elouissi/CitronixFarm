package com.elouissi.sitronix.web.rest.VM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenteVM {
    private Integer id;

    private LocalDate date_vente;
    private String client;
    private Float revenu;
    private Float quantite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Float prix_unitaire;

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
}
