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
        Ferme ferme = fermeService.getFermeId(id);
        Champ champ = champMapper.toEntity(champVM);
        Champ champ1 = champService.save(champ, ferme);
        ChampDTO champDTO = champMapper.toDTO(champ1);
        return ResponseEntity.ok(champDTO);
    }

}
