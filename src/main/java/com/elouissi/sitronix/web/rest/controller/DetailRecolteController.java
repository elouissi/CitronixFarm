package com.elouissi.sitronix.web.rest.controller;

import com.elouissi.sitronix.service.implimentation.DetailRecolteService;
import com.elouissi.sitronix.web.rest.VM.mapper.DetailRecolteMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detailRecolte")
public class DetailRecolteController {
    private final DetailRecolteService detailRecolteService;
    private final DetailRecolteMapper detailRecolteMapper;

    public DetailRecolteController(DetailRecolteService detailRecolteService, DetailRecolteMapper detailRecolteMapper) {
        this.detailRecolteService = detailRecolteService;
        this.detailRecolteMapper = detailRecolteMapper;
    }
//    @PostMapping("/save")
//    public ResponseEntity<?> saveDetailRecolte(@RequestBody @Valid DetailRecolteDTO detailRecolteDTO){
//
//        try {
//            List<DetailRecolte> savedDetailRecolte = detailRecolteService.save(
//                    detailRecolteDTO.getChamp(),
//                    detailRecolteDTO.getRecolte()
//            );
//            DetailRecolteVM detailRecolte = deatilRecolteMapper.toVM(savedDetailRecolte);
//
//            return ResponseEntity.ok(savedDetailRecolte);
//        } catch (NoSuchElementException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }catch (IllegalArgumentException e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }catch(Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la sauvegarde du détail de récolte.");
//        }
//    }

}
