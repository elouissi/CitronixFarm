package com.elouissi.sitronix.web.rest.VM.mapper;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.service.DTO.FermeDTO;
import com.elouissi.sitronix.web.rest.VM.FermeVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface FermeMapper {
    Ferme ToEntity(FermeVM fermeVM);
    FermeDTO toDTO(Ferme ferme);
    // FermeVM toVM(Ferme ferme);
}
