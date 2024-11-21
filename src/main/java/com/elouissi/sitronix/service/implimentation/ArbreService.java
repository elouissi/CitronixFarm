package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Arbre;
import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.repository.ArbreRepository;
import com.elouissi.sitronix.service.ArbreInterface;
import com.elouissi.sitronix.service.ArbreInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
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


        int currentMonth = LocalDate.now().minusMonths(7).getMonthValue();
        if (currentMonth < 3 || currentMonth >5)
        {
            throw new IllegalArgumentException("voous devez creer une arbre dans la date de plantation entre mai et mars");
        }


        if ( division > 100){
            throw new IllegalArgumentException("vous avez dépasser Le nombre des arbres par hectar.");

        }

        Arbre arbre = new Arbre();
        arbre.setDate_plantation(LocalDate.now().minusMonths(7));

        arbre.setChamp(champ);
        champ.getArbres().add(arbre);
        return arbreRepository.save(arbre);
    }
    public Arbre getArbreId(Integer id) {
        return arbreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arbre avec ID " + id + " non trouvée"));
    }
    public Integer getAge(Arbre arbre){
        LocalDate dateArbre = arbre.getDate_plantation();
        Period age = Period.between(dateArbre,LocalDate.now());
        return age.getYears();

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
    public Arbre update(Integer idArbre, Integer idChamp) {
        Arbre existingArbre = arbreRepository.findById(idArbre)
                .orElseThrow(() -> new RuntimeException("Arbre avec ID " + idArbre + " non trouvée"));
        Champ champ = champService.getChampId(idChamp);
        if (champ == null){
            throw new NullPointerException("le champ ne trouve pas");
        }
        if (existingArbre.getChamp() != null) {
            existingArbre.setChamp(champ);
        }


        return arbreRepository.save(existingArbre);
    }

}
