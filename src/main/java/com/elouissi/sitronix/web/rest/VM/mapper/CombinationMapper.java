package com.elouissi.sitronix.web.rest.VM.mapper;

import com.elouissi.sitronix.domain.DetailRecolte;
import com.elouissi.sitronix.domain.Recolte;
import com.elouissi.sitronix.service.DTO.CombinationDTO;
import com.elouissi.sitronix.web.rest.VM.DetailRecolteVM;
import com.elouissi.sitronix.web.rest.VM.PageRecolteVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CombinationMapper {
    @Mapping(target = "detailRecolteVMList", source = "detailRecoltes")

    PageRecolteVM toVM(Recolte recolte);


    Recolte toEntity(CombinationDTO combinationDTO);
    List<DetailRecolteVM> toDetailRecolteVMList(List<DetailRecolte> detailRecoltes);

    DetailRecolteVM toDetailRecolteVM(DetailRecolte detailRecolte);
}
