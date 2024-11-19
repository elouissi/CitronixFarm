package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.FermeRepository;
import com.elouissi.sitronix.service.FermeInterface;
import com.elouissi.sitronix.web.errors.ChampsPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service2")
public class FermeListSerivce implements FermeInterface {
    @Autowired
    private FermeRepository fermeRepository;

    @Override
    public Ferme save(Ferme ferme) {
        Ferme savedFerme = fermeRepository.save(ferme);

        if (ferme.getChamps() != null && !ferme.getChamps().isEmpty()) {
            throw new ChampsPresentException("La ferme ne doit pas contenir de champs lors de la sauvegarde.");
        }
        return savedFerme;

    }
    public List<Ferme> getFermesWithArea() {
        List<Ferme> allFermes =  fermeRepository.findAll();
        return allFermes.stream().filter(farm -> farm.getChamps().stream()
                .mapToDouble(Champ::getSuperficie)
                .sum() > 4000
        ).toList();
    }

    @Override
    public void delete(Ferme ferme) {

    }
}
