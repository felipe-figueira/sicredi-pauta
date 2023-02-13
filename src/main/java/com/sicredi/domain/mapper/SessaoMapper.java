package com.sicredi.domain.mapper;

import com.sicredi.domain.dto.SessaoDto;
import com.sicredi.domain.model.Sessao;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SessaoMapper {

	Sessao mapDtoToSessao (SessaoDto sessaoDto);

	SessaoDto mapSessaoToDto (Sessao sessao);
}
