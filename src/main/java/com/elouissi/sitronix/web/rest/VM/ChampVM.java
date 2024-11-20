package com.elouissi.sitronix.web.rest.VM;

import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChampVM {


    @NotNull(message = "La superficie est requise")
    @PositiveOrZero(message = "La superficie doit être positive ou égale à zéro")
    private Float superficie;

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }
}