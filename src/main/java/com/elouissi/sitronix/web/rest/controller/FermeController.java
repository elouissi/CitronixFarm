package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.service.DTO.FermeDTO;
import com.elouissi.sitronix.service.implimentation.FermeService;
import com.elouissi.sitronix.web.errors.ChampsPresentException;

import com.elouissi.sitronix.web.rest.VM.FermeVM;
import com.elouissi.sitronix.web.rest.VM.mapper.FermeMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ferme")
public class FermeController {
    @Autowired
    private FermeService fermeService;
    @Autowired
    private FermeMapper fermeMapper;

  @PostMapping("/save")
  public ResponseEntity<?>save(@RequestBody @Valid FermeVM fermeVM){
      try {
          Ferme ferme = fermeMapper.ToEntity(fermeVM);
          Ferme ferme1 = fermeService.save(ferme);
          FermeDTO fermeDTO = fermeMapper.toDTO(ferme1);
          return ResponseEntity.ok(fermeDTO);
      } catch (ChampsPresentException e) {
          return ResponseEntity.badRequest().body(e.getMessage());
      }
  }
  @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete( @PathVariable Integer id){
      try {
          Ferme ferme = fermeService.getFermeId(id);
          fermeService.delete(ferme);
          return ResponseEntity.ok("Ferme supprimée avec succès.");
      } catch (RuntimeException e) {
          return ResponseEntity.badRequest().body("Erreur lors de la suppression : " + e.getMessage());
      }

  }
}
