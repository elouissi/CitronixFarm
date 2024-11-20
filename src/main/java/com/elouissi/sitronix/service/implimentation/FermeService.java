package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.FermeRepository;
import com.elouissi.sitronix.service.FermeInterface;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FermeService implements FermeInterface {

    private final FermeRepository fermeRepository;



    public FermeService(FermeRepository fermeRepository) {
        this.fermeRepository = fermeRepository;

    }

    @Override
    public Ferme save(Ferme ferme) {
        if (ferme.getNom() == null || ferme.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la ferme est obligatoire.");
        }
        return fermeRepository.save(ferme);
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
