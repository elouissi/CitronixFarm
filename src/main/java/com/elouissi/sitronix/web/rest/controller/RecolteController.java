package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.enums.Saison;
import com.elouissi.sitronix.service.DTO.CombinationDTO;
import com.elouissi.sitronix.service.DTO.RecolteDTO;
import com.elouissi.sitronix.service.RecolteInterface;
import com.elouissi.sitronix.web.rest.VM.PageRecolteVM;
import com.elouissi.sitronix.web.rest.VM.RecolteVM;
import com.elouissi.sitronix.web.rest.VM.mapper.CombinationMapper;
import com.elouissi.sitronix.web.rest.VM.mapper.RecolteMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/recolte/")
public class RecolteController {
    @Qualifier("service")
    private final RecolteInterface recolteService;
    private final RecolteMapper recolteMapper;
    private final CombinationMapper combinationMapper;


    public RecolteController(RecolteInterface recolteService, RecolteMapper recolteMapper,CombinationMapper combinationMapper) {
        this.recolteService = recolteService;
        this.recolteMapper = recolteMapper;
        this.combinationMapper = combinationMapper;
    }

//    @PostMapping("/save")
//    public ResponseEntity<?> createRecolte(@Valid @RequestBody RecolteDTO recolteDTO) {
//        try {
//            Recolte recolte = recolteMapper.toEntity(recolteDTO);
//            Recolte recolte1 = recolteService.save(recolte);
//            RecolteVM recolteVM = recolteMapper.toVM(recolte1);
//            return ResponseEntity.ok(recolteVM);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "error", "Invalid argument",
//                    "message", e.getMessage()
//            ));
//        }
//    }
@PostMapping("recolte")
public ResponseEntity<?> recolte(@Valid @RequestBody CombinationDTO combinationDTO) {
    try {
        Recolte recolte = combinationMapper.toEntity(combinationDTO);
        Recolte savedRecolte = recolteService.save(combinationDTO.getChamp(), recolte);
        RecolteVM pageRecolteVM = recolteMapper .toVM(savedRecolte);
        return ResponseEntity.ok(pageRecolteVM);
    } catch (NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Une erreur s'est produite lors de la création de la récolte : " + e.getMessage());
    }
}

    @GetMapping("getBySaison/{saison}")
    public ResponseEntity<?> getBySaison(@PathVariable Saison saison){
        List<Recolte> recolteList = recolteService.findBySaison(saison);
        return ResponseEntity.ok(recolteList.stream().map(recolteMapper::toVM).toList());
    }
    @PutMapping("/recolte/{id}")
    public ResponseEntity<Recolte> updateRecolte(@PathVariable Integer id, @RequestBody Recolte recolteDetails) {
        Recolte updatedRecolte = recolteService.update(id, recolteDetails);
        return ResponseEntity.ok(updatedRecolte);
    }

}
