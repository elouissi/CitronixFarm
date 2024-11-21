package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.Arbre;
import com.elouissi.sitronix.service.DTO.ArbreDTO;
import com.elouissi.sitronix.service.implimentation.ArbreService;
import com.elouissi.sitronix.service.implimentation.ChampService;
import com.elouissi.sitronix.web.rest.VM.ArbreVM;
import com.elouissi.sitronix.web.rest.VM.mapper.ArbreMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/arbre")
public class ArbreController {

    private final ArbreService arbreService;
    private final ArbreMapper arbreMapper;

    public ArbreController(ArbreService arbreService,ArbreMapper arbreMapper) {

        this.arbreService = arbreService;
        this.arbreMapper = arbreMapper;

    }

    @GetMapping("/save/{id}")
    public ResponseEntity<?> saveArbre(@PathVariable Integer id) {
        try {
            Arbre arbre1 = arbreService.saveArbre(id);
            ArbreVM arbreVM = arbreMapper.toVM(arbre1);
            return ResponseEntity.ok(arbreVM);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Champ avec ID " + id + " non trouvé : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            Arbre arbre = arbreService.getArbreId(id);
            arbreService.delete(arbre);
            return ResponseEntity.ok("Arbre supprimée avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur lors de la suppression : " + e.getMessage());
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Integer id ,@RequestBody ArbreDTO arbreDTO){
        try {
            Arbre arbre =arbreMapper.toEntity(arbreDTO);
            Arbre updatedArbre = arbreService.update(arbre, id);
            return ResponseEntity.ok("la arbre est bien modifier  de l'id"+ updatedArbre);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
