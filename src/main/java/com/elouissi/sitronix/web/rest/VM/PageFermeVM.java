package com.elouissi.sitronix.web.rest.VM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageFermeVM {
    private String nom;

    private String localisation;


    private LocalDate date_creation;


    private Float superficie;

    private List<PageChampVM> champs;

    public List<PageChampVM> getChamps() {
        return champs;
    }

    public void setChamps(List<PageChampVM> champs) {
        this.champs = champs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public LocalDate getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }
}
