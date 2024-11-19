package com.elouissi.sitronix.web.rest.VM;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FermeVM {
    @NotNull(message = "le nom du ferme est requis")
    private String name;
    @NotBlank(message = "La location est requis")
    private String location;
    @NotNull(message = "Le totle est requis")
    @PositiveOrZero(message = "Le totale doit être positif ou égal à zéro")
    private Double totalArea;

}
