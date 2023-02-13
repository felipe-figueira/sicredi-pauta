package com.sicredi.domain.exception;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@Getter
public class ParticipantsServerErrorException extends RuntimeException implements Serializable {
  private static final long serialVersionUID = -3355067513400310907L;
  private final List<ErrorResponse> errorResponses;

  public ParticipantsServerErrorException () {
    this.errorResponses = List.of(new ErrorResponse("OPIN-PARTICIPANTS-1000", "Servidor não pode ser alcançado", "Não foi possível recuperar os dados da(s) Sociedade(s) Seguradora(s). Aguarde alguns instantes e tente novamente."));
  }
}
