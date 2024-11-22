package com.elouissi.sitronix.service;

import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.web.rest.VM.RecolteVM;
import org.hibernate.query.Page;

import java.util.List;
import java.util.Optional;

public interface RecolteInterface {
    Recolte save(Recolte recolte);
    Optional<Recolte> findById(Integer id);
    List<Recolte> findAll();
    Recolte update(Integer id, Recolte recolte);
    void delete(Integer id);
    List<Recolte> findBySaison(String saison);
    boolean isValidRecolteForSeason(Recolte recolte);
    Float calculateTotalQuantity(Integer recolteId);
}
