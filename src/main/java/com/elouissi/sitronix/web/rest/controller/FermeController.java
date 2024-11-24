package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.service.DTO.FermeDTO;
import com.elouissi.sitronix.service.implimentation.FermeService;
import com.elouissi.sitronix.web.errors.ChampsPresentException;

import com.elouissi.sitronix.web.rest.VM.FermeVM;
import com.elouissi.sitronix.web.rest.VM.PageFermeVM;
import com.elouissi.sitronix.web.rest.VM.mapper.FermeMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ferme")
public class FermeController {
    @Autowired
    private FermeService fermeService;
    @Autowired
    private FermeMapper fermeMapper;

  @PostMapping("/save")
  public ResponseEntity<?>save(@RequestBody @Valid FermeDTO fermeDTO){
      try {
          Ferme ferme = fermeMapper.ToEntity(fermeDTO);
          Ferme ferme1 = fermeService.save(ferme);
          FermeVM fermeVM = fermeMapper.toVM(ferme1);
          return ResponseEntity.ok(fermeVM);
      } catch (ChampsPresentException e) {
          return ResponseEntity.badRequest().body(e.getMessage());
      }
  }
    @GetMapping("/search")
    public ResponseEntity<Page<PageFermeVM>> searchFermes(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) Double minSuperficie,
            @RequestParam(required = false) Double maxSuperficie,
            @RequestParam(required = false) String localisation,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Ferme> resultPage = fermeService.searchFermes(nom, minSuperficie, maxSuperficie, localisation, pageable);

        List<PageFermeVM> fermeVMList = resultPage.getContent()
                .stream()
                .map(fermeMapper::toPageFermeVM)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new PageImpl<>(fermeVMList, pageable, resultPage.getTotalElements()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFerme(@PathVariable Integer id, @RequestBody FermeDTO fermeDTO) {
        try {
            Ferme ferme = fermeMapper.ToEntity(fermeDTO);
            Ferme updatedFerme = fermeService.update(ferme, id);
            return ResponseEntity.ok("la ferme est bien modifier  de l'id"+updatedFerme.getId());
        } catch (RuntimeException e) {
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

    @GetMapping("/fermes")
    public Page<PageFermeVM> getFermes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Ferme> fermePage =  fermeService.getAllFermes(pageable);
        List<PageFermeVM> fermeVMList = fermePage.getContent()
                .stream()
                .map(fermeMapper::toPageFermeVM)
                .toList();
        return new PageImpl<>(fermeVMList,pageable, fermePage.getTotalElements() );
    }
}
