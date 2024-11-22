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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQuantite_totale() {
        return quantite_totale;
    }

    public void setQuantite_totale(Float quantite_totale) {
        this.quantite_totale = quantite_totale;
    }

    public LocalDate getDate_recolte() {
        return date_recolte;
    }

    public void setDate_recolte(LocalDate date_recolte) {
        this.date_recolte = date_recolte;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    private Integer id;
    private Float quantite_totale;
    private LocalDate date_recolte;
    private Saison saison;

}