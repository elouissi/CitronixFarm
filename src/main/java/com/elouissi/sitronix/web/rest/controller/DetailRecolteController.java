package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.DetailRecolte;
import com.elouissi.sitronix.service.DTO.DetailRecolteDTO;
import com.elouissi.sitronix.service.implimentation.DetailRecolteService;
import com.elouissi.sitronix.web.rest.VM.DetailRecolteVM;
import com.elouissi.sitronix.web.rest.VM.mapper.DeatilRecolteMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/detailRecolte")
public class DetailRecolteController {
    private final DetailRecolteService detailRecolteService;
    private final DeatilRecolteMapper deatilRecolteMapper;

    public DetailRecolteController(DetailRecolteService detailRecolteService, DeatilRecolteMapper deatilRecolteMapper) {
        this.detailRecolteService = detailRecolteService;
        this.deatilRecolteMapper = deatilRecolteMapper;
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveDetailRecolte(@RequestBody @Valid DetailRecolteDTO detailRecolteDTO){

        try {
            DetailRecolte savedDetailRecolte = detailRecolteService.save(
                    detailRecolteDTO.getArbre(),
                    detailRecolteDTO.getRecolte()
            );
//            DetailRecolteVM detailRecolte = deatilRecolteMapper.toVM(savedDetailRecolte);

            return ResponseEntity.ok(savedDetailRecolte);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la sauvegarde du détail de récolte.");
        }
    }

}
