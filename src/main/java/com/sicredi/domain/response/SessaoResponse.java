package com.sicredi.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicredi.domain.model.enums.StatusPauta;
import java.time.LocalDateTime;
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
public class SessaoResponse {

	private StatusPauta statusPauta;

	private String idPauta;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime horarioLimiteVoto;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime horarioInicio;

}
