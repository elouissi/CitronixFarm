package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.Vente;
import com.elouissi.sitronix.repository.RecolteRepository;
import com.elouissi.sitronix.repository.VenteRepository;
import com.elouissi.sitronix.service.VenteInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service")
public class VenteService implements VenteInterface {
    private VenteRepository venteRepository;
    private final RecolteService recolteService;

    public VenteService(VenteRepository venteRepository,
                        RecolteService recolteService) {
        this.venteRepository = venteRepository;
        this.recolteService = recolteService;
    }

    @Override
    public Vente save(Integer recolteId, Vente vente) {
        Optional<Recolte> recolte = recolteService.findById(recolteId);
        if (recolte.isPresent()) {
            if (venteRepository.existsByRecolte(recolte.get())){
               throw new RuntimeException("cette recolte est deja vendus") ;
            }
            vente.setRecolte(recolte.get());
            vente.setRevenu(vente.getQuantite() * vente.getPrix_unitaire());
            return venteRepository.save(vente);
        }
        throw new RuntimeException("Recolte not found with id: " + recolteId);
    }
    @Override
    public Optional<Vente> findById(Integer id) {
        return Optional.ofNullable(venteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vente not found with id: " + id)));
    }

    @Override
    public List<Vente> findAll() {
        return venteRepository.findAll();
    }

    public Vente update(Integer id, Vente updatedVente) {
        return venteRepository.findById(id)
                .map(vente -> {
                    vente.setDate_vente(updatedVente.getDate_vente());
                    vente.setClient(updatedVente.getClient());
                    vente.setQuantite(updatedVente.getQuantite());
                    vente.setPrix_unitaire(updatedVente.getPrix_unitaire());
                    vente.setRevenu(vente.getQuantite() * vente.getPrix_unitaire());
                    return venteRepository.save(vente);
                })
                .orElseThrow(() -> new RuntimeException("Vente not found with id: " + id));
    }

    public void delete(Integer id) {
        if (venteRepository.existsById(id)) {
            venteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Vente not found with id: " + id);
        }
    }

    @Override
    public List<Vente> findByClient(String client) {
        return venteRepository.findByClient(client);
    }

    @Override
    public boolean isValidVenteForSeason(Vente vente) {
        return false;
    }

    @Override
    public Float calculateTotalQuantity(Integer venteId) {
        return null;
    }


}
