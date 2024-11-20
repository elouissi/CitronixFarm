package com.elouissi.sitronix.repository;

import com.elouissi.sitronix.domain.Ferme;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface FermeRepository extends JpaRepository<Ferme,Integer> {
    public Ferme getFermeById(Integer id);
    public Page<Ferme> findAll(Pageable pageable);
}
