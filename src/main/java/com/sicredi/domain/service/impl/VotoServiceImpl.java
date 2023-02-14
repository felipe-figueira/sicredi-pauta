package com.sicredi.domain.service.impl;

import com.sicredi.domain.dto.VotoDto;
import com.sicredi.domain.exception.NotFoundException;
import com.sicredi.domain.exception.PautaException;
import com.sicredi.domain.exception.VotoException;
import com.sicredi.domain.mapper.VotoMapper;
import com.sicredi.domain.model.Pauta;
import com.sicredi.domain.model.enums.StatusPauta;
import com.sicredi.domain.repository.PautaRepository;
import com.sicredi.domain.service.VotoService;
import com.sicredi.domain.validation.VotoValidation;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotoServiceImpl implements VotoService {

	private final PautaRepository pautaRepository;
	private final VotoMapper votoMapper;
	private final VotoValidation votoValidation;

	@Override
	public void votoAssociado(VotoDto votoDto) {
		var pauta = pautaRepository.findById(votoDto.getIdPauta());
		pauta.ifPresentOrElse(pautaVoto -> {
			if(pautaVoto.getHorarioLimiteVoto().isAfter(LocalDateTime.now()) && pautaVoto.getStatus() == StatusPauta.VOTACAO_ABERTA){
				if(pautaVoto.getVotos() != null){
					votoValidation.verificarAssociadoVoto(pautaVoto, votoDto.getIdAssociado());
					pautaVoto.getVotos().add(votoMapper.mapDtoToVoto(votoDto));
				}else{
					pautaVoto.setVotos(Set.of(votoMapper.mapDtoToVoto(votoDto)));
				}
				pautaRepository.save(pautaVoto);
			}else{
				throw new PautaException();
			}
		}, () -> {
			throw new NotFoundException();
		});
	}

}
