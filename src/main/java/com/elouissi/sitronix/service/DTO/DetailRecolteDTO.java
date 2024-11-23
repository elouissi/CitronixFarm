package com.elouissi.sitronix.service.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DetailRecolteDTO {

    @NotNull(message = "L'id de recolte est requis")
    @Positive(message = "L'id de recolte doit être un nombre positif")
    private Integer recolte;

    @NotNull(message = "L'id du champ est requis")
    @Positive(message = "L'id du champ doit être un nombre positif")
    private Integer champ;

    public Integer getRecolte() {
        return recolte;
    }

    public void setRecolte(Integer recolte) {
        this.recolte = recolte;
    }

    public Integer getChamp() {
        return champ;
    }

    public void setChamp(Integer champ) {
        this.champ = champ;
    }
}
