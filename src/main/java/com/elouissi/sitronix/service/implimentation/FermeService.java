package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.FermeRepository;
import com.elouissi.sitronix.repository.impl.FermeRepositoryImpl;
import com.elouissi.sitronix.service.FermeInterface;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FermeService implements FermeInterface {

    private final FermeRepository fermeRepository;
    private final ChampService champService;
    private final FermeRepositoryImpl fermeRepositoryImpl;

    public FermeService(FermeRepository fermeRepository, ChampService champService, FermeRepositoryImpl fermeRepositoryImpl) {
        this.fermeRepository = fermeRepository;
        this.champService = champService;
        this.fermeRepositoryImpl = fermeRepositoryImpl;
    }






    @Override
    public Ferme save(Ferme ferme) {
        if (ferme.getNom() == null || ferme.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la ferme est obligatoire.");
        }
        return fermeRepository.save(ferme);
    }


    public Page<Ferme>  searchFermes(String nom, Double minSuperficie, Double maxSuperficie, String localisation, Pageable pageable){
        return fermeRepositoryImpl.searchFermes(nom,minSuperficie,maxSuperficie,localisation,pageable);
    }
    public Ferme update(Ferme ferme, Integer id) {
        return fermeRepository.findById(id)
                .map(existingFerme -> {
                    existingFerme.setNom(ferme.getNom());
                    existingFerme.setSuperficie(ferme.getSuperficie());
                    existingFerme.setDate_creation(ferme.getDate_creation());
                    existingFerme.setLocalisation(ferme.getLocalisation());
                    existingFerme.setChamps(ferme.getChamps());
                    return fermeRepository.save(existingFerme);
                })
                .orElseThrow(() -> new RuntimeException("Ferme avec ID " + id + " non trouvée"));
    }

    @Transactional
    @Override
    public void delete(Ferme ferme) {
        if (ferme == null) {
            throw new IllegalArgumentException("La ferme à supprimer ne peut pas être null.");
        }
        champService.deleteByFerme(ferme);
        fermeRepository.delete(ferme);
    }
    public Page<Ferme> getAllFermes(Pageable pageable) {
        return fermeRepository.findAll(pageable);

    }

    @Override
    public Ferme getFermeId(Integer id) {
        return fermeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferme avec ID " + id + " non trouvée"));
    }


}
