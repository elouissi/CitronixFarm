package com.elouissi.sitronix.domain;

import com.elouissi.sitronix.domain.enums.Saison;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQuantite_totale() {
        return quantite_totale;
    }

    public void setQuantite_totale(Float quantite_totale) {
        this.quantite_totale = quantite_totale;
    }

    public LocalDate getDate_recolte() {
        return date_recolte;
    }

    public void setDate_recolte(LocalDate date_recolte) {
        this.date_recolte = date_recolte;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public List<DetailRecolte> getDetailRecoltes() {
        return detailRecoltes;
    }

    public void setDetailRecoltes(List<DetailRecolte> detailRecoltes) {
        this.detailRecoltes = detailRecoltes;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }
}
