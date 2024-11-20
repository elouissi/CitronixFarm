package com.elouissi.sitronix.repository;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampRepository extends JpaRepository<Champ,Integer> {
    public Optional<Champ> deleteChampByFerme(Ferme ferme);
}
