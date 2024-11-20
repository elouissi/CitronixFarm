package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.ChampRepository;
import com.elouissi.sitronix.service.ChampInterface;
import org.springframework.stereotype.Service;

@Service
public class ChampService implements ChampInterface {
    private final ChampRepository champRepository;
    private final FermeService fermeService;

    public ChampService(ChampRepository champRepository,FermeService fermeService) {
        this.champRepository = champRepository;
        this.fermeService = fermeService;
    }

    @Override
    public Champ save(Champ champ, Ferme ferme) {
    champ.setFerme(ferme);
    ferme.getChamps().add(champ);
        fermeService.update(ferme, ferme.getId());
    return champRepository.save(champ);

    }

    @Override
    public void delete(Champ ferme) {

    }
}
