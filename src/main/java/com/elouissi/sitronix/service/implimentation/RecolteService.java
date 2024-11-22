package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.enums.Saison;
import com.elouissi.sitronix.repository.RecolteRepository;
import com.elouissi.sitronix.service.RecolteInterface;
import com.elouissi.sitronix.utils.SaisonUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.util.List;
import java.util.Optional;

public class RecolteService implements RecolteInterface {

private final RecolteRepository recolteRepository;

    public RecolteService(RecolteRepository recolteRepository) {
        this.recolteRepository = recolteRepository;
    }

    @Override
    public Recolte save(Recolte recolte) {
        Saison saison = SaisonUtil.getSaisonFromDate(recolte.getDate_recolte());
        recolte.setSaison(saison);
        recolte.setQuantite_totale(0f);

        if (!isValidRecolteForSeason(recolte)) {
            throw new IllegalArgumentException("Une récolte existe déjà pour cette saison");
        }


        return recolteRepository.save(recolte) ;
    }

    @Override
    public Optional<Recolte> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Recolte> findAll() {
        return null;
    }

    @Override
    public Recolte update(Integer id, Recolte recolte) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Recolte> findBySaison(String saison) {
        return null;
    }

    @Override
    public boolean isValidRecolteForSeason(Recolte recolte) {
        return false;
    }

    @Override
    public Float calculateTotalQuantity(Integer recolteId) {
        return null;
    }
}
