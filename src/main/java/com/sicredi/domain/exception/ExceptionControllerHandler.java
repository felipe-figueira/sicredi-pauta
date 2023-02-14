package com.sicredi.domain.exception;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@AllArgsConstructor
public class ExceptionControllerHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionControllerHandler.class);

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> pautaNaoEncntrada() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
			.title("Pauta não encontrada")
			.detail("Id da pauta não existe ou está incorreto")
			.code("404")
			.build());
	}

	@ExceptionHandler(PautaException.class)
	public ResponseEntity<ErrorResponse> pautaExpirada() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ErrorResponse.builder()
			.title("Pauta não diponível")
			.detail("Pauta não diponível para voto")
			.code("403")
			.build());
	}

	@ExceptionHandler(VotoException.class)
	public ResponseEntity<ErrorResponse> votoAssociadoJaComputado() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ErrorResponse.builder()
			.title("Voto já computado")
			.detail("Associado já votou nessa pauta")
			.code("403")
			.build());
	}

}
