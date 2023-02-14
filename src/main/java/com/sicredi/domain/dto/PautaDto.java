package com.sicredi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sicredi.domain.model.enums.StatusPauta;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PautaDto {


  private String id;

  @NotBlank
  private String titulo;

  @Builder.Default
  @JsonProperty("status")
  private StatusPauta status = StatusPauta.AGUARDANDO_VOTACAO;

}
