package com.sicredi.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mongodb.client.result.UpdateResult;
import com.sicredi.domain.dto.PautaDto;
import com.sicredi.domain.mapper.PautaMapper;
import com.sicredi.domain.model.Pauta;
import com.sicredi.domain.model.Voto;
import com.sicredi.domain.model.enums.StatusPauta;
import com.sicredi.domain.repository.PautaRepository;
import java.time.LocalDateTime;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@ExtendWith(MockitoExtension.class)
class PautaServiceImplTest {

	@Mock
	private PautaRepository mockPautaRepository;
	@Mock
	private PautaMapper mockPautaMapper;
	@Mock
	private MongoTemplate mockMongoTemplate;

	private PautaServiceImpl pautaServiceImplUnderTest;

	@BeforeEach
	void setUp() {
		pautaServiceImplUnderTest = new PautaServiceImpl(mockPautaRepository, mockPautaMapper, mockMongoTemplate);
	}

	@Test
	void testCriarPauta() {
		final PautaDto pautaDto = new PautaDto("id", "titulo", StatusPauta.VOTACAO_ABERTA);
		final Pauta pauta = new Pauta("id", StatusPauta.VOTACAO_ABERTA, "titulo", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
			LocalDateTime.of(2020, 1, 1, 0, 0, 0), Set.of(new Voto("voto", "idAssociado", "cpf")));

		when(mockPautaMapper.mapDtoToPauta(any(PautaDto.class))).thenReturn(pauta);
		when(mockPautaRepository.save(pauta)).thenReturn(pauta);
		when(mockPautaMapper.mapPautaToDto(pauta)).thenReturn(pautaDto);

		final PautaDto result = pautaServiceImplUnderTest.criarPauta(pautaDto);

		Assertions.assertNotNull(result);
		Assertions.assertEquals("id", result.getId());
		Assertions.assertEquals(StatusPauta.VOTACAO_ABERTA, result.getStatus());
	}

	@Test
	void criarPautaShouldSaveThePauta() {
		PautaDto pautaDto = PautaDto.builder().build();
		Pauta pauta = Pauta.builder().build();
		when(mockPautaMapper.mapDtoToPauta(pautaDto)).thenReturn(pauta);
		when(mockPautaRepository.save(pauta)).thenReturn(pauta);
		when(mockPautaMapper.mapPautaToDto(pauta)).thenReturn(pautaDto);

		PautaDto result = pautaServiceImplUnderTest.criarPauta(pautaDto);

		assertEquals(result, pautaDto);
	}

}
