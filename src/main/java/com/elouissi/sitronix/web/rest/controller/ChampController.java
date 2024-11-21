package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.service.DTO.ChampDTO;
import com.elouissi.sitronix.service.implimentation.ChampService;
import com.elouissi.sitronix.service.implimentation.FermeService;
import com.elouissi.sitronix.web.rest.VM.ChampVM;
import com.elouissi.sitronix.web.rest.VM.mapper.ChampMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/champ")
public class ChampController {

    private final ChampService champService;
    private final FermeService fermeService;
    private final ChampMapper champMapper;

    public ChampController(ChampService champService, FermeService fermeService,ChampMapper champMapper) {
        this.champService = champService;
        this.fermeService = fermeService;
        this.champMapper = champMapper;
    }

    @PostMapping("/save/{id}")
    public ResponseEntity<?> saveChamp(@RequestBody @Valid ChampVM champVM, @PathVariable Integer id) {
        try {
        Ferme ferme = fermeService.getFermeId(id);
        Champ champ = champMapper.toEntity(champVM);
        Float nouvelleSommeSuperficies = champService.calculerSommeSuperficiesChamps(ferme) + champ.getSuperficie();
        Float moitier = ferme.getSuperficie() * 0.5f;
        if (champ.getSuperficie() >= moitier){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La superficie de la champ dépasse la moitier de la ferme.");
        }
        if (nouvelleSommeSuperficies >= ferme.getSuperficie()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La somme des superficies des champs dépasse la superficie totale de la ferme.");
        }
        Champ champ1 = champService.save(champ, ferme);
        ChampDTO champDTO = champMapper.toDTO(champ1);
        return ResponseEntity.ok(champDTO);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ferme avec ID " + id + " non trouvée : " + e.getMessage());
    }
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            Champ champ = champService.getChampId(id);
            champService.delete(champ);
            return ResponseEntity.ok("Champ supprimée avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur lors de la suppression : " + e.getMessage());
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Integer id ,@RequestBody ChampVM champVM){
        try {
            Champ champ =champMapper.toEntity(champVM);
            Champ updatedChamp = champService.update(champ, id);
            return ResponseEntity.ok("la champ est bien modifier  de l'id"+ updatedChamp.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
