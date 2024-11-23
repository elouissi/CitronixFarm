package com.elouissi.sitronix.repository;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.enums.Saison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecolteRepository extends JpaRepository<Recolte,Integer> {

    @Query("SELECT COUNT(r) > 0 FROM Recolte r WHERE r.saison = :saison AND r.date_recolte BETWEEN :startDate AND :endDate")
    boolean existsBySaisonAndDateRecolteInRange(
            @Param("saison") Saison saison,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
    List<Recolte> getRecoltesBySaison(Saison saison);
}

