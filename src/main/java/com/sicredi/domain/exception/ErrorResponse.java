package com.sicredi.domain.exception;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class ErrorResponse implements Serializable {
  private static final long serialVersionUID = 7558200410892344530L;
  private String code;
  private String title;
  private String detail;
  private final Instant requestDateTime = Instant.now().truncatedTo(ChronoUnit.MILLIS);
}
