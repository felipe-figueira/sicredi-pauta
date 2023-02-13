package com.sicredi.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicredi.domain.model.Voto;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class PautaDto {

  private String id;

  private String titulo;

  private Set<Voto> votos;

}
