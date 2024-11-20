package com.elouissi.sitronix.service;

import com.elouissi.sitronix.domain.Ferme;

import java.util.Optional;

public interface FermeInterface {
    public Ferme save(Ferme ferme);
    public void delete(Ferme ferme);
    public Ferme getFermeId(Integer id);
    public Ferme update(Ferme ferme, Integer id);

}
