package com.github.gilsonsilvati.ifood.cadastro.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.github.gilsonsilvati.ifood.cadastro.Prato;

@Mapper(componentModel = "cdi")
public interface PratoMapper {

    PratoDTO toDTO(Prato prato);

    Prato toPrato(AdicionarPratoDTO dto);

    void toPrato(AtualizarPratoDTO dto, @MappingTarget Prato prato);

}