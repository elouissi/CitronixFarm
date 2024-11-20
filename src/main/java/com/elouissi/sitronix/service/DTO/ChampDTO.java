package com.elouissi.sitronix.service.DTO;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChampDTO {


    private Float superficie;

    public Float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Float superficie) {
        this.superficie = superficie;
    }
}
