package com.sicredi.domain.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sicredi.domain.dto.SessaoDto;
import com.sicredi.domain.model.Pauta;
import com.sicredi.domain.model.Voto;
import com.sicredi.domain.model.enums.StatusPauta;
import com.sicredi.domain.repository.PautaRepository;
import com.sicredi.domain.response.SessaoResponse;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
class SessaoServiceImplTest {

	@Mock
	private PautaRepository mockPautaRepository;

	private SessaoServiceImpl sessaoServiceImplUnderTest;

	@BeforeEach
	void setUp() {
		sessaoServiceImplUnderTest = new SessaoServiceImpl(mockPautaRepository);
	}

	@Test
	void testAbrirSessao() {
		final SessaoDto sessaoDto = new SessaoDto(0, "idPauta", StatusPauta.VOTACAO_ABERTA);
		final Optional<Pauta> pauta = Optional.of(
			new Pauta("id", StatusPauta.AGUARDANDO_VOTACAO, "titulo", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
				LocalDateTime.of(2020, 1, 1, 0, 0, 0), Set.of(new Voto("voto", "idAssociado", "cpf"))));
		when(mockPautaRepository.findById(any())).thenReturn(pauta);
		when(mockPautaRepository.save(any())).thenReturn(pauta.get());
		final SessaoResponse result = sessaoServiceImplUnderTest.abrirSessao(sessaoDto);
		verify(mockPautaRepository).findById(any());
		verify(mockPautaRepository).save(any());
		Assertions.assertEquals(StatusPauta.VOTACAO_ABERTA, result.getStatusPauta());
	}

}
