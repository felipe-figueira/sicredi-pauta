package com.sicredi.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sicredi.domain.model.enums.StatusPauta;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "pauta")
public class Pauta {

  @Id
  private String id;

  @Builder.Default
  private StatusPauta status = StatusPauta.AGUARDANDO_VOTACAO;

  @NotBlank
  private String titulo;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  Set<Voto> votos;

}
