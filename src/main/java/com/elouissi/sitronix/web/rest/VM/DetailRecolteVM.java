package com.elouissi.sitronix.web.rest.VM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailRecolteVM {
    private float quantite_recoltee;
    private ArbreVM arbreVM;

    public float getQuantite_recoltee() {
        return quantite_recoltee;
    }

    public void setQuantite_recoltee(float quantite_recoltee) {
        this.quantite_recoltee = quantite_recoltee;
    }

    public ArbreVM getArbreVM() {
        return arbreVM;
    }

    public void setArbreVM(ArbreVM arbreVM) {
        this.arbreVM = arbreVM;
    }
}
