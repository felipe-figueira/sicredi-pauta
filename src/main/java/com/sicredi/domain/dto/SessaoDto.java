package com.sicredi.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SessaoDto {

	@JsonProperty("duracao")
	private Integer duracao;

	@JsonProperty("idPauta")
	private String idPauta;

}
