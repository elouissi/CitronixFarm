package com.elouissi.sitronix.web.rest.VM.mapper;

import com.elouissi.sitronix.domain.Vente;
import com.elouissi.sitronix.service.DTO.VenteDTO;
import com.elouissi.sitronix.web.rest.VM.VenteVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface VenteMapper {
    Vente ToEntity(VenteDTO fermeDTO);
    VenteDTO toDTO(Vente ferme);
    VenteVM toVM(Vente ferme);

//    PageVenteVM toPageVenteVM(Vente ferme);
}
