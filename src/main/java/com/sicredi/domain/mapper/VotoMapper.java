package com.sicredi.domain.mapper;

import com.sicredi.domain.dto.VotoDto;
import com.sicredi.domain.model.Voto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface VotoMapper {

	Voto mapDtoToVoto (VotoDto votoDto);

	VotoDto mapVotoToDto (Voto voto);
}
