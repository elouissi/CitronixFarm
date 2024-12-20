package com.elouissi.sitronix.repository;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {
    List<Vente> findByClient(String client);
    boolean existsByRecolte(Recolte recolte);
}
