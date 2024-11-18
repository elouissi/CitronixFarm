package com.elouissi.sitronix.repository;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.domain.Recolte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecolteRepository extends JpaRepository<Recolte,Integer> {
}
