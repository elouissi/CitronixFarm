package com.elouissi.sitronix.service;

import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.Vente;
import com.elouissi.sitronix.domain.enums.Saison;

import java.util.List;
import java.util.Optional;

public interface VenteInterface {
    Vente save(Integer idRecolte, Vente vente);
    Optional<Vente> findById(Integer id);
    List<Vente> findAll();
    Vente update(Integer id, Vente vente);
    void delete(Integer id);
    List<Vente> findByClient(String client);
    boolean isValidVenteForSeason(Vente vente);
    Float calculateTotalQuantity(Integer venteId);
}
