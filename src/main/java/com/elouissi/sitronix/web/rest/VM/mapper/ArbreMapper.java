package com.elouissi.sitronix.web.rest.VM.mapper;

import com.elouissi.sitronix.domain.Arbre;
import com.elouissi.sitronix.service.DTO.ArbreDTO;
import com.elouissi.sitronix.web.rest.VM.ArbreVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ArbreMapper{
        Arbre toEntity(ArbreDTO arbreDTO);
        ArbreDTO toDTO(Arbre arbre);
        ArbreVM toVM(Arbre arbre);

//        PageArbreVM toPageArbreVm(Arbre champ);{
}
