package com.elouissi.sitronix.web.rest.VM;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FermeVM {
    @NotNull(message = "le nom du ferme est requis")
    private String nom;

    @NotBlank(message = "La location est requis")
    private String localisation;

    @NotNull(message = "Date is required")
    @Future(message = "Date must be in the future")
    private LocalDate date_creation;

    @NotNull(message = "La superficie est requise")
    @PositiveOrZero(message = "La superficie doit être positive ou égale à zéro")
    private Float superficie;

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
