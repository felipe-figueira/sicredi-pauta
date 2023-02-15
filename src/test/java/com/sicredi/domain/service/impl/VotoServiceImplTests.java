package com.sicredi.domain.service.impl;

import com.sicredi.domain.dto.VotoDto;
import com.sicredi.domain.mapper.VotoMapper;
import com.sicredi.domain.model.Pauta;
import com.sicredi.domain.model.Voto;
import com.sicredi.domain.model.enums.StatusPauta;
import com.sicredi.domain.repository.PautaRepository;
import com.sicredi.domain.validation.VotoValidation;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class VotoServiceImplTests {

	@Mock
	PautaRepository pautaRepository;

	@Mock
	VotoMapper votoMapper;

	@InjectMocks
	VotoServiceImpl votoServiceImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testVotoAssociado() {
		final Optional<Pauta> pauta = Optional.of(
			new Pauta("id", StatusPauta.VOTACAO_ABERTA, "titulo", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
				LocalDateTime.of(2020, 1, 1, 0, 0, 0), null));
		when(pautaRepository.save(any())).thenReturn(pauta.get());
		when(pautaRepository.findById(anyString())).thenReturn(pauta);
		when(votoMapper.mapDtoToVoto(any())).thenReturn(new Voto("voto", "idAssociado", "cpf"));

		votoServiceImpl.votoAssociado(new VotoDto("voto", "idPauta", "idAssociado", "cpf"));

		verify(pautaRepository).save(any());
		verify(pautaRepository).findById(anyString());
	}
}
