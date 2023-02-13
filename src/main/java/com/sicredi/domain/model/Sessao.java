package com.sicredi.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "sessao")
public class Sessao {

	private String id;

	@Builder.Default
	private Integer duracao = 1;

	private String idPauta;

	private LocalDateTime horarioLimiteVoto;

	private LocalDateTime horarioInicio;

}
