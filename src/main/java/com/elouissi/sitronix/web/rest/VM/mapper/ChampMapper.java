package com.elouissi.sitronix.web.rest.VM.mapper;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.service.DTO.ChampDTO;
import com.elouissi.sitronix.web.rest.VM.ChampVM;
import com.elouissi.sitronix.web.rest.VM.PageChampVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChampMapper {
    Champ toEntity(ChampDTO champDTO);

    ChampDTO toDTO(Champ champ);
    ChampVM toVM(Champ champ);
    PageChampVM toPageChampVm(Champ champ);
}
