package com.elouissi.sitronix.service;

import com.elouissi.sitronix.domain.Ferme;

public interface ChampInterface {
    public Ferme save(Ferme ferme);
    public void delete(Ferme ferme);

}
