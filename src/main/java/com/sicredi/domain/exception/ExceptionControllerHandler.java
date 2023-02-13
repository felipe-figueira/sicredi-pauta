package com.sicredi.domain.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {
/*
  private static final Logger LOG = LoggerFactory.getLogger(ExceptionControllerHandler.class);

  @ExceptionHandler(value = ParticipantsServerErrorException.class)
  public ResponseEntity<ErrorResponseBody> findParticipantsExceptions(ParticipantsServerErrorException participantsServerErrorException) {
    participantsServerErrorException.getErrorResponses().forEach(err -> LOG.error("Find participants error: {}", err));
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseBody(participantsServerErrorException.getErrorResponses(), new Meta()));
  }
*/
}
