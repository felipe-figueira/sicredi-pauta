package com.sicredi.domain.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class VotoDto {

	@NotBlank
	private String voto;

	@NotBlank
	private String idPauta;

	@NotBlank
	private String idAssociado;

	@NotBlank
	@CPF(message="CPF inválido")
	private String cpf;

}
