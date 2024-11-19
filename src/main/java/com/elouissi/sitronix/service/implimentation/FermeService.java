package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.ChampRepository;
import com.elouissi.sitronix.repository.FermeRepository;
import com.elouissi.sitronix.service.FermeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service1")
public class FermeService implements FermeInterface {
    @Autowired
    private FermeRepository fermeRepository;
    @Autowired
    private ChampRepository champRepository;

    @Override
    public Ferme save(Ferme ferme) {
        Ferme savedFerme = fermeRepository.save(ferme);

        if (ferme.getChamps() != null && !ferme.getChamps().isEmpty()) {
            for (Champ champ : ferme.getChamps()) {
                champ.setFerme(savedFerme);
                champRepository.save(champ);
            }
        }
        return savedFerme;
    }


    @Override
    public void delete(Ferme ferme) {

    }
}
