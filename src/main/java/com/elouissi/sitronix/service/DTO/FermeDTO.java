package com.elouissi.sitronix.service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FermeDTO {
    @NotNull(message = "le nom du ferme est requis")
    private String nom;
    @NotBlank(message = "La location est requis")
    private String location;
    @NotNull(message = "Le totle est requis")
    private Double totalArea;

}
