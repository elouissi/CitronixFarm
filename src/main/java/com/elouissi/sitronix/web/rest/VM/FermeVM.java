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
    private String nom;

    private Float superficie;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }
}
