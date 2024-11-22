package com.elouissi.sitronix.service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailRecolteDTO {


    @NotNull(message = "L'id de recolte est requis")
    @Positive(message = "L'id de recolte doit être un nombre positif")
    private Integer recolte;

    @NotNull(message = "L'id de l'arbre est requis")
    @Positive(message = "L'id de l'arbre doit être un nombre positif")
    private Integer arbre;

    public Integer getRecolte() {
        return recolte;
    }

    public void setRecolte(Integer recolte) {
        this.recolte = recolte;
    }

    public Integer getArbre() {
        return arbre;
    }

    public void setArbre(Integer arbre) {
        this.arbre = arbre;
    }
}
