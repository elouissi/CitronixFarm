package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.ChampRepository;
import com.elouissi.sitronix.service.ChampInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChampService implements ChampInterface {

    private final ChampRepository champRepository;

    public ChampService(ChampRepository champRepository) {
        this.champRepository = champRepository;
    }

    @Override
    public Champ save(Champ champ, Ferme ferme) {
        if (ferme == null) {
            throw new IllegalArgumentException("La ferme associée ne peut pas être null.");
        }
        champ.setFerme(ferme);
        ferme.getChamps().add(champ);

        return champRepository.save(champ);
    }
    public Champ getChampId(Integer id) {
        return champRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Champ avec ID " + id + " non trouvée"));
    }

    @Override
    public Optional<Champ> deleteByFerme(Ferme ferme) {
        if (ferme == null) {
            throw new IllegalArgumentException("La ferme ne peut pas être null.");
        }
       return champRepository.deleteChampByFerme(ferme);
    }

    @Override
    public void delete(Champ champ) {
        if (champ == null) {
            throw new IllegalArgumentException("Le champ à supprimer ne peut pas être null.");
        }
        champRepository.delete(champ);
    }
    public static Float calculerSommeSuperficiesChamps(Ferme ferme) {
        if (ferme == null || ferme.getChamps() == null) {
            return 0f;
        }
        return ferme.getChamps().stream()
                .map(Champ::getSuperficie)
                .filter(superficie -> superficie != null)
                .reduce(0f, Float::sum);
    }
    public Champ update(Champ champ, Integer id) {
        Champ existingChamp = champRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Champ avec ID " + id + " non trouvée"));

        if (champ.getSuperficie() != null) {
            existingChamp.setSuperficie(champ.getSuperficie());
        }

        if (champ.getArbres() != null) {
            existingChamp.setArbres(champ.getArbres());
        }

        return champRepository.save(existingChamp);
    }

}
