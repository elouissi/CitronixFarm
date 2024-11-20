package com.elouissi.sitronix.service;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;

public interface ChampInterface {
    public Champ save(Champ champ,Ferme ferme);
    public void delete(Champ champ);

}
