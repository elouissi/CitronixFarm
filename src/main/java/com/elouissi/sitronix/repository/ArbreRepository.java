package com.elouissi.sitronix.repository;

import com.elouissi.sitronix.domain.Arbre;
import com.elouissi.sitronix.domain.Ferme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbreRepository extends JpaRepository<Arbre,Integer> {
}
