package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Arbre;
import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.DetailRecolte;
import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.repository.DetailRecolteRepository;
import com.elouissi.sitronix.service.DetailRecolteInterface;
import com.elouissi.sitronix.utils.ProductiviteUtil;
import com.elouissi.sitronix.web.errors.ArbreDejaRecolter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DetailRecolteService implements DetailRecolteInterface {
    private final DetailRecolteRepository detailRecolteRepository;
    private final ChampService champService;
    private final RecolteService recolteService;

    public DetailRecolteService(DetailRecolteRepository detailRecolteRepository, ChampService champService, RecolteService recolteService) {
        this.detailRecolteRepository = detailRecolteRepository;
        this.champService = champService;
        this.recolteService = recolteService;
    }



    @Transactional
    @Override
    public List<DetailRecolte> save(Integer idChamp, Integer idRecolte) {
        Champ champ = champService.getChampId(idChamp);
        if (champ == null) {
            throw new NoSuchElementException("Champ avec l'ID " + idChamp + " n'a pas été trouvé.");
        }

        Recolte recolte = recolteService.findById(idRecolte)
                .orElseThrow(() -> new NoSuchElementException("Récolte avec l'ID " + idRecolte + " n'a pas été trouvée."));

        List<DetailRecolte> detailsRecolte = new ArrayList<>();

        for (Arbre arbre : champ.getArbres()) {
            if (detailRecolteRepository.existsDetailRecolteByArbre(arbre)) {
                throw new ArbreDejaRecolter("l'arbre est deja recolter");
            }
            DetailRecolte detailRecolte = new DetailRecolte();
            detailRecolte.setRecolte(recolte);
            detailRecolte.setArbre(arbre);

            if (arbre.getDate_plantation().getMonthValue() > 2 && arbre.getDate_plantation().getMonthValue() < 12){

            Float productivite = (float) (arbre.calculerProductivite() - ( arbre.calculerProductivite() * 0.3));

            }
            Float productivite = arbre.calculerProductivite();
            detailRecolte.setQuantite_recoltee(productivite);

            detailsRecolte.add(detailRecolteRepository.save(detailRecolte));
        }

        return detailsRecolte;
    }


    @Override
    public Optional<DetailRecolte> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<DetailRecolte> findAll() {
        return null;
    }

    @Override
    public DetailRecolte update(Integer id, DetailRecolte detailRecolte) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public boolean isValidDetailRecolteForSeason(DetailRecolte detailRecolte) {
        return false;
    }

    @Override
    public Float calculateTotalQuantity(Integer recolteId) {
        return null;
    }
}
