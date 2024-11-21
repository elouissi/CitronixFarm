package com.elouissi.sitronix.web.rest.VM;

import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
public class ChampVM {


    @NotNull(message = "La superficie est requise")
    @PositiveOrZero(message = "La superficie doit être positive ou égale à zéro")
    @Min(value = 1000, message = "La superficie doit être d'au moins 1000 m²")
    private Float superficie;

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }
}
