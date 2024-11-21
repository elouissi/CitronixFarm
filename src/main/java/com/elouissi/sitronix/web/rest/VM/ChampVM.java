package com.elouissi.sitronix.web.rest.VM;

import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
public class ChampVM {


    @NotNull(message = "La superficie est requise")
    @PositiveOrZero(message = "La superficie doit être positive ou égale à zéro")
    @DecimalMin(value = "0.1", inclusive = true, message = "La superficie doit être d'au moins 0.1 hec")
    private Float superficie;

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }
}
