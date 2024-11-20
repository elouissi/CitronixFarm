package com.elouissi.sitronix.web.rest.VM.mapper;

import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.service.DTO.FermeDTO;
import com.elouissi.sitronix.web.rest.VM.FermeVM;
import com.elouissi.sitronix.web.rest.VM.PageFermeVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FermeMapper {
    Ferme ToEntity(FermeVM fermeVM);
    FermeDTO toDTO(Ferme ferme);

    PageFermeVM toPageFermeVM(Ferme ferme);

}
