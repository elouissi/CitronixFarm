package com.elouissi.sitronix.web.rest.VM.mapper;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.service.DTO.ChampDTO;
import com.elouissi.sitronix.web.rest.VM.ChampVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChampMapper {
    Champ toEntity(ChampVM champVM);
    ChampDTO toDTO(Champ champ);
}
