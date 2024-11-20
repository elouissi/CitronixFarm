package com.elouissi.sitronix.service;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;

import java.util.Optional;

public interface ChampInterface {
    public Champ save(Champ champ,Ferme ferme);
    public void delete(Champ champ);
    public Optional<Champ> deleteByFerme(Ferme ferme);

}
