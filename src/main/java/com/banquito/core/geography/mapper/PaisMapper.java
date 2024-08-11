package com.banquito.core.geography.mapper;

import org.mapstruct.Mapper;

import com.banquito.core.geography.controller.dto.PaisDTO;
import com.banquito.core.geography.model.Pais;

@Mapper(componentModel = "spring")
public interface PaisMapper {

    PaisDTO paisToPaisDTO(Pais pais);

    Pais paisDTOtoPais(PaisDTO dto);
}
