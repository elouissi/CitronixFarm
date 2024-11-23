package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.Vente;
import com.elouissi.sitronix.service.DTO.VenteDTO;
import com.elouissi.sitronix.service.VenteInterface;
import com.elouissi.sitronix.web.rest.VM.VenteVM;
import com.elouissi.sitronix.web.rest.VM.mapper.VenteMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vente")
public class VenteController {
    @Qualifier("service")
    private final VenteInterface venteService;
    private final VenteMapper venteMapper;

    public VenteController(VenteInterface venteService, VenteMapper venteMapper) {
        this.venteService = venteService;
        this.venteMapper = venteMapper;
    }
    @PostMapping("/save/{id}")
    public ResponseEntity<?> save(@RequestBody @Valid VenteDTO venteDTO,  @PathVariable Integer id) {
        try {
            Vente vente = venteMapper.ToEntity(venteDTO);
            VenteVM venteVM = venteMapper.toVM(venteService.save(id, vente));
            return ResponseEntity.ok(venteVM);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Vente>> getAllVentes() {
        return ResponseEntity.ok(venteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVenteById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(venteService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateVente(@PathVariable Integer id, @RequestBody @Valid VenteDTO venteDTO) {
        try {
            Vente vente = venteMapper.ToEntity(venteDTO);
            return ResponseEntity.ok(venteService.update(id, vente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVente(@PathVariable Integer id) {
        try {
            venteService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Find by client
    @GetMapping("/client/{client}")
    public ResponseEntity<List<Vente>> getVentesByClient(@PathVariable String client) {
        return ResponseEntity.ok(venteService.findByClient(client));
    }
}
