package com.sicredi.domain.service.impl;

import com.sicredi.domain.dto.SessaoDto;
import com.sicredi.domain.mapper.SessaoMapper;
import com.sicredi.domain.model.Sessao;
import com.sicredi.domain.model.enums.StatusPauta;
import com.sicredi.domain.repository.PautaRepository;
import com.sicredi.domain.repository.SessaoRepository;
import com.sicredi.domain.response.SessaoResponse;
import com.sicredi.domain.service.SessaoService;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessaoServiceImpl implements SessaoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessaoService.class);
	private final SessaoRepository sessaoRepository;
	private final SessaoMapper sessaoMapper;
	private final PautaRepository pautaRepository;

	@Autowired
	public SessaoServiceImpl(SessaoRepository sessaoRepository, SessaoMapper sessaoMapper,
		PautaRepository pautaRepository) {
		this.sessaoRepository = sessaoRepository;
		this.sessaoMapper = sessaoMapper;
		this.pautaRepository = pautaRepository;
	}

	@Override
	public SessaoResponse abrirSessao(SessaoDto sessaoDto){

		SessaoResponse sessaoResponse = SessaoResponse.builder().build();
		var pautaSessao = pautaRepository.findById(sessaoDto.getIdPauta());
		pautaSessao.ifPresentOrElse(pauta -> {
				if(pauta.getStatus() == StatusPauta.AGUARDANDO_VOTACAO){
					var sessao =  sessaoMapper.mapDtoToSessao(sessaoDto);
					var horaInicio = LocalDateTime.now();
					sessao.setHorarioInicio(horaInicio);
					sessao.setHorarioLimiteVoto(LocalDateTime.now().plusMinutes(sessaoDto.getDuracao() == null ? 1 : sessaoDto.getDuracao()));
					sessaoRepository.save(sessao);
					sessaoResponse.setHorarioInicio(sessao.getHorarioInicio());
					sessaoResponse.setHorarioLimiteVoto(sessao.getHorarioLimiteVoto());
					sessaoResponse.setIdPauta(pauta.getId());
					pauta.setStatus(StatusPauta.VOTACAO_ABERTA);
					sessaoResponse.setStatusPauta(pautaRepository.save(pauta).getStatus());
				}else {
					LOGGER.error("Pauta encerrada ou em votação");
					throw new RuntimeException();
				}
			},
			() -> {
				LOGGER.error("Id {} não encontrado", sessaoDto.getIdPauta());
				throw new RuntimeException();
			});
		return sessaoResponse;
	}

}
