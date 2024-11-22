package com.elouissi.sitronix.web.rest.VM.mapper;


import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.service.DTO.RecolteDTO;
import com.elouissi.sitronix.web.rest.VM.RecolteVM;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RecolteMapper {

    RecolteVM toVM(Recolte recolte);


    @Mapping(target = "detailRecoltes", ignore = true)
    @Mapping(target = "ventes", ignore = true)
    Recolte toEntity(RecolteVM recolteVM);

    RecolteDTO toDTO(Recolte recolte);


    @Mapping(target = "detailRecoltes", ignore = true)
    @Mapping(target = "ventes", ignore = true)
    Recolte toEntity(RecolteDTO recolteDTO);
}
