package com.elouissi.sitronix.service.DTO;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecolteDTO {


    public LocalDate getDate_recolte() {
        return date_recolte;
    }

    public void setDate_recolte(LocalDate date_recolte) {
        this.date_recolte = date_recolte;
    }

    @NotNull(message = "Date is required")
    @Future(message = "Date must be in the future")
    private LocalDate date_recolte;

}
