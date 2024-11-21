package com.elouissi.sitronix.service;

import com.elouissi.sitronix.domain.Arbre;
import com.elouissi.sitronix.domain.Champ;

import java.util.Optional;

public interface ArbreInterface {
    public Arbre update(Integer idChamp, Integer id);
    public void delete(Arbre arbre) ;
    public Arbre getArbreId(Integer id) ;
    public Optional<Arbre> deleteByChamp(Champ champ) ;
    public Arbre saveArbre(Integer id) ;

    }