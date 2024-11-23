package com.elouissi.sitronix.service.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CombinationDTO {
    @NotNull(message = "L'id du champ est requis")
    @Positive(message = "L'id du champ doit être un nombre positif")
    private Integer champ;
    public LocalDate getDate_recolte() {
        return date_recolte;
    }

    public Integer getChamp() {
        return champ;
    }

    public void setChamp(Integer champ) {
        this.champ = champ;
    }

    public void setDate_recolte(LocalDate date_recolte) {
        this.date_recolte = date_recolte;
    }

    @NotNull(message = "Date is required")
    private LocalDate date_recolte;

}
