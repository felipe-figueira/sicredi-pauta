package com.sicredi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sicredi.domain.model.enums.StatusPauta;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
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
public class SessaoDto {

	@Positive
	@Min(1)
	@JsonProperty("duracao")
	private Integer duracao;

	@JsonProperty("idPauta")
	private String idPauta;

	private StatusPauta status;

}
