package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.service.DTO.FermeDTO;
import com.elouissi.sitronix.service.implimentation.FermeListSerivce;
import com.elouissi.sitronix.service.implimentation.FermeService;
import com.elouissi.sitronix.web.errors.ChampsPresentException;

import com.elouissi.sitronix.web.rest.VM.mapper.FermeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ferme")
public class FermeController {
    @Autowired
    @Qualifier("service2")
    private FermeListSerivce fermeService;
    @Autowired
    private FermeMapper fermeMapper;

  @PostMapping("/save")
  public ResponseEntity<?>save(@RequestBody  Ferme ferme){
      try {
          Ferme ferme1 = fermeService.save(ferme);
          FermeDTO fermeDTO = fermeMapper.toDTO(ferme1);
          return ResponseEntity.ok(fermeDTO);
      } catch (ChampsPresentException e) {
          return ResponseEntity.badRequest().body(e.getMessage());
      }
  }
}
