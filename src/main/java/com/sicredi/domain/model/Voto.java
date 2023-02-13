package com.sicredi.domain.model;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
public class Voto {

	@NotBlank
	private String voto;

	@NotBlank
	private String idCooperado;

	private String nome;

	@CPF
	private String cpf;

}
