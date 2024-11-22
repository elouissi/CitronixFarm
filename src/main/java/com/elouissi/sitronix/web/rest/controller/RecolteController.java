package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.domain.enums.Saison;
import com.elouissi.sitronix.service.DTO.RecolteDTO;
import com.elouissi.sitronix.service.RecolteInterface;
import com.elouissi.sitronix.web.rest.VM.RecolteVM;
import com.elouissi.sitronix.web.rest.VM.mapper.RecolteMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/recolte/")
public class RecolteController {
    private final RecolteInterface recolteService;
    private final RecolteMapper recolteMapper;

    public RecolteController(RecolteInterface recolteService, RecolteMapper recolteMapper) {
        this.recolteService = recolteService;
        this.recolteMapper = recolteMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<?> createRecolte(@Valid @RequestBody RecolteDTO recolteDTO) {
        try {
            Recolte recolte = recolteMapper.toEntity(recolteDTO);
            Recolte recolte1 = recolteService.save(recolte);
            RecolteVM recolteVM = recolteMapper.toVM(recolte1);
            return ResponseEntity.ok(recolteVM);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "Invalid argument",
                    "message", e.getMessage()
            ));
        }
    }
    @GetMapping("getBySaison/{saison}")
    public ResponseEntity<?> getBySaison(@PathVariable Saison saison){
        List<Recolte> recolteList = recolteService.findBySaison(saison);
        return ResponseEntity.ok(recolteList.stream().map(recolteMapper::toVM).toList());
    }

}
