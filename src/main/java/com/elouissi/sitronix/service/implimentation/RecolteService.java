package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.enums.Saison;
import com.elouissi.sitronix.repository.RecolteRepository;
import com.elouissi.sitronix.service.RecolteInterface;
import com.elouissi.sitronix.utils.SaisonUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
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
        return recolteRepository.findById(id);
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
    public List<Recolte> findBySaison(Saison saison) {
        return recolteRepository.getRecoltesBySaison(saison);
    }

    @Override
    public boolean isValidRecolteForSeason(Recolte recolte) {
        if (recolte == null || recolte.getDate_recolte() == null || recolte.getSaison() == null) {
            throw new IllegalArgumentException("La récolte, sa date ou sa saison ne peuvent pas être nulles.");
        }

        LocalDate date = recolte.getDate_recolte();
        Saison saison = recolte.getSaison();

        return !recolteRepository.existsBySaisonAndDateRecolteInRange(
                saison,
                date.withDayOfYear(1),
                date.withDayOfYear(date.lengthOfYear())
        );
    }


    @Override
    public Float calculateTotalQuantity(Integer recolteId) {
        return null;
    }
}
