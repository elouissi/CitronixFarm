package com.elouissi.sitronix.service;

import com.elouissi.sitronix.domain.DetailRecolte;
import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.enums.Saison;

import java.util.List;
import java.util.Optional;

public interface DetailRecolteInterface {
    public List<DetailRecolte> save(Integer idChamp, Integer idRecolte) ;

    Optional<DetailRecolte> findById(Integer id);
    List<DetailRecolte> findAll();
    DetailRecolte update(Integer id, DetailRecolte detailRecolte);
    void delete(Integer id);
    boolean isValidDetailRecolteForSeason(DetailRecolte detailRecolte);
    Float calculateTotalQuantity(Integer recolteId);
}
