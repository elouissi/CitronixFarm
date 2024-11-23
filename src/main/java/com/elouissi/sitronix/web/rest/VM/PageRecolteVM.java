package com.elouissi.sitronix.web.rest.VM;

import com.elouissi.sitronix.domain.enums.Saison;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRecolteVM {
    private Integer id;
    private Float quantite_totale;
    private LocalDate date_recolte;
    private Saison saison;
    private List<DetailRecolteVM> detailRecolteVMList;

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

    public List<DetailRecolteVM> getDetailRecolteVMList() {
        return detailRecolteVMList;
    }

    public void setDetailRecolteVMList(List<DetailRecolteVM> detailRecolteVMList) {
        this.detailRecolteVMList = detailRecolteVMList;
    }
}
