package com.sicredi.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.sicredi.domain.dto.PautaDto;
import com.sicredi.domain.mapper.PautaMapper;
import com.sicredi.domain.model.Pauta;
import com.sicredi.domain.repository.PautaRepository;
import com.sicredi.domain.service.impl.PautaServiceImpl;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PautaServiceImplTest {

	@Mock
	private PautaRepository pautaRepository;

	@Mock
	private PautaMapper pautaMapper;

	@InjectMocks
	private PautaServiceImpl pautaService;

	@Test
	@DisplayName("Should save the pauta")
	void criarPautaShouldSaveThePauta() {
		PautaDto pautaDto = PautaDto.builder().build();
		Pauta pauta = Pauta.builder().build();
		when(pautaMapper.mapDtoToPauta(pautaDto)).thenReturn(pauta);
		when(pautaRepository.save(pauta)).thenReturn(pauta);
		when(pautaMapper.mapPautaToDto(pauta)).thenReturn(pautaDto);

		PautaDto result = pautaService.criarPauta(pautaDto);

		assertEquals(result, pautaDto);
	}

	@Test
	void test(){
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		LocalDateTime value = localDateTime.plusMinutes(5);
		System.out.println(value);

	}
}