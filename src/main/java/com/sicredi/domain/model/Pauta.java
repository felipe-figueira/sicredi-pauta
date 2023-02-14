package com.sicredi.domain.model;

import com.sicredi.domain.model.enums.StatusPauta;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "pauta")
@EqualsAndHashCode
public class Pauta {

  @MongoId
  private String id;

  private StatusPauta status;

  private String titulo;

  private LocalDateTime horarioLimiteVoto;

  private LocalDateTime horarioInicio;

  Set<Voto> votos;

}
