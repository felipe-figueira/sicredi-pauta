package com.sicredi.domain.service.impl;

import com.sicredi.domain.dto.SessaoDto;
import com.sicredi.domain.exception.NotFoundException;
import com.sicredi.domain.exception.PautaException;
import com.sicredi.domain.model.enums.StatusPauta;
import com.sicredi.domain.repository.PautaRepository;
import com.sicredi.domain.response.SessaoResponse;
import com.sicredi.domain.service.SessaoService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessaoServiceImpl implements SessaoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessaoService.class);
	private final PautaRepository pautaRepository;

	@Override
	public SessaoResponse abrirSessao(SessaoDto sessaoDto){
		SessaoResponse sessaoResponse = SessaoResponse.builder().build();
		var pautaSessao = pautaRepository.findById(sessaoDto.getIdPauta());
		pautaSessao.ifPresentOrElse(pauta -> {
				if(pauta.getStatus() == StatusPauta.AGUARDANDO_VOTACAO){
					var horaInicio = LocalDateTime.now();
					pauta.setHorarioInicio(horaInicio);
					pauta.setHorarioLimiteVoto(LocalDateTime.now().plusMinutes(sessaoDto.getDuracao() == null ? 1 : sessaoDto.getDuracao()));
					pauta.setStatus(StatusPauta.VOTACAO_ABERTA);
					pautaRepository.save(pauta);
					sessaoResponse.setHorarioInicio(pauta.getHorarioInicio());
					sessaoResponse.setHorarioLimiteVoto(pauta.getHorarioLimiteVoto());
					sessaoResponse.setIdPauta(pauta.getId());
					sessaoResponse.setStatusPauta(pauta.getStatus());
				}else {
					LOGGER.error("Pauta encerrada ou em votação");
					throw new PautaException();
				}
			},
			() -> {
				LOGGER.error("Id {} não encontrado", sessaoDto.getIdPauta());
				throw new NotFoundException();
			});

		return sessaoResponse;
	}

}
