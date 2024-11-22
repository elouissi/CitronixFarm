package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Arbre;
import com.elouissi.sitronix.domain.DetailRecolte;
import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.repository.DetailRecolteRepository;
import com.elouissi.sitronix.service.DetailRecolteInterface;
import com.elouissi.sitronix.utils.ProductiviteUtil;
import com.elouissi.sitronix.web.rest.VM.DetailRecolteVM;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DetailRecolteService implements DetailRecolteInterface {
    private final DetailRecolteRepository detailRecolteRepository;
    private final ArbreService arbreService;
    private final RecolteService recolteService;

    public DetailRecolteService(DetailRecolteRepository detailRecolteRepository, ArbreService arbreService, RecolteService recolteService) {
        this.detailRecolteRepository = detailRecolteRepository;
        this.arbreService = arbreService;
        this.recolteService = recolteService;
    }



    @Override
    public DetailRecolte save(Integer idArbre, Integer idRecolte) {
        Arbre arbre = arbreService.getArbreId(idArbre);
        Recolte recolte = recolteService.findById(idRecolte)
                .orElseThrow(() -> new NoSuchElementException("Recolte avec l'ID " + idRecolte + " n'a pas été trouvée."));
        DetailRecolte detailRecolte = new DetailRecolte();
        detailRecolte.setRecolte(recolte);
        detailRecolte.setArbre(arbre);
        Float prodictivité = ProductiviteUtil.calculerProductivite(arbre);
        detailRecolte.setQuantite_recoltee(prodictivité);

        return detailRecolteRepository.save(detailRecolte);
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
