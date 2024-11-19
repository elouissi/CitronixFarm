package com.elouissi.sitronix.web.rest.VM;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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

}
