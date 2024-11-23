package com.elouissi.sitronix.web.rest.VM.mapper;

import com.elouissi.sitronix.domain.DetailRecolte;
import com.elouissi.sitronix.service.DTO.RecolteDTO;
import com.elouissi.sitronix.web.rest.VM.DetailRecolteVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface DetailRecolteMapper {
    DetailRecolteVM toVM(DetailRecolte detailRecolte);



    DetailRecolte toEntity(DetailRecolteVM recolteVM);

    RecolteDTO toDTO(DetailRecolte detailRecolte);



    DetailRecolte toEntity(RecolteDTO recolteDTO);
}
