package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Arbre;
import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.repository.ArbreRepository;
import com.elouissi.sitronix.service.ArbreInterface;
import com.elouissi.sitronix.service.ArbreInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ArbreService implements ArbreInterface {

    private final ArbreRepository arbreRepository;
    private final ChampService champService;

    public ArbreService(ArbreRepository arbreRepository,ChampService champService) {
        this.arbreRepository = arbreRepository;
        this.champService = champService;
    }

    @Override
    public Arbre saveArbre(Integer champId) {
        Champ champ = champService.getChampId(champId);
        if (champ == null) {
            throw new EntityNotFoundException("Champ avec ID " + champId + " non trouvé.");
        }

        Integer some = champ.getArbres().size();
        Float nombreHectar =  (champ.getSuperficie() );
        int division = (int) (some / nombreHectar);


        if ( division > 100){
            throw new IllegalArgumentException("vous avez dépasser Le nombre des arbres par hectar.");

        }

        Arbre arbre = new Arbre();
        arbre.setDate_plantation(LocalDate.now());

        arbre.setChamp(champ);
        champ.getArbres().add(arbre);
        return arbreRepository.save(arbre);
    }
    public Arbre getArbreId(Integer id) {
        return arbreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arbre avec ID " + id + " non trouvée"));
    }

    @Override
    public Optional<Arbre> deleteByChamp(Champ champ) {
        if (champ == null) {
            throw new IllegalArgumentException("La champ ne peut pas être null.");
        }
        return arbreRepository.deleteArbreByChamp(champ);
    }

    @Override
    public void delete(Arbre arbre) {
        if (arbre == null) {
            throw new IllegalArgumentException("Le arbre à supprimer ne peut pas être null.");
        }
        arbreRepository.delete(arbre);
    }
    public Arbre update(Arbre arbre, Integer id) {
        Arbre existingArbre = arbreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arbre avec ID " + id + " non trouvée"));

        if (arbre.getChamp() != null) {
            existingArbre.setChamp(arbre.getChamp());
        }

        if (arbre.getDetailRecoltes() != null) {
            existingArbre.setDetailRecoltes(arbre.getDetailRecoltes());
        }

        return arbreRepository.save(existingArbre);
    }

}
