package com.sicredi.domain.mapper;

import com.sicredi.domain.dto.PautaDto;
import com.sicredi.domain.model.Pauta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PautaMapper {

  Pauta mapDtoToPauta (PautaDto pautaDto);

  PautaDto mapPautaToDto (Pauta pauta);

}
