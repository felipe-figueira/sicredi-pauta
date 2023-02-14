package com.sicredi.domain.response;

import com.sicredi.domain.model.Voto;
import java.util.Set;
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
public class PautaResponse {

	private String titulo;

	private Set<Voto> votos;

}
