package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.ChampRepository;
import com.elouissi.sitronix.repository.FermeRepository;
import com.elouissi.sitronix.service.FermeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("service1")
public class FermeService implements FermeInterface {
    @Autowired
    private FermeRepository fermeRepository;
    @Autowired
    private ChampRepository champRepository;

    @Override
    public Ferme save(Ferme ferme) {
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

    @Override
    public void delete(Ferme ferme) {

    }
    @Override
    public Ferme getFermeId(Integer id){
        return fermeRepository.getFermeById(id);

    }
}
