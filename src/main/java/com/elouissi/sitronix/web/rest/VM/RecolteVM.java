package com.elouissi.sitronix.web.rest.VM;

import com.elouissi.sitronix.domain.enums.Saison;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecolteVM {
    private Integer id;
    private Float quantiteTotale;
    private LocalDate dateRecolte;
    private Saison saison;
    private List<Integer> detailRecolteIds;
    private List<Integer> venteIds;
}