package com.github.gilsonsilvati.ifood.cadastro.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.github.gilsonsilvati.ifood.cadastro.Restaurante;

@Mapper(componentModel = "cdi")
public interface RestauranteMapper {
	
	@Mapping(target = "nome", source = "nomeFantasia")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "criacao", ignore = true)
	@Mapping(target = "atualizacao", ignore = true)
	@Mapping(target = "localizacao.id", ignore = true)
	public Restaurante toRestaurante(AdicionarRestauranteDTO dto);
	
	@Mapping(target = "nome", source = "nomeFantasia")
	public void toRestaurante(AtualizarRestauranteDTO dto, @MappingTarget Restaurante restaurante);
	
	@Mapping(target = "nomeFantasia", source = "nome")
	// Exemplo de formatação.
	@Mapping(target = "criacao", dateFormat = "dd/MM/yyyy HH:mm:ss")
	public RestauranteDTO toRestaurante(Restaurante restaurante);

}
