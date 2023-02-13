package com.sicredi.domain.service.impl;

import com.sicredi.domain.dto.PautaDto;
import com.sicredi.domain.mapper.PautaMapper;
import com.sicredi.domain.repository.PautaRepository;
import com.sicredi.domain.service.PautaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaServiceImpl implements PautaService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PautaServiceImpl.class);
  private final PautaRepository pautaRepository;
  private final PautaMapper pautaMapper;

  @Autowired
  public PautaServiceImpl(PautaRepository pautaRepository, PautaMapper pautaMapper) {
    this.pautaRepository = pautaRepository;
    this.pautaMapper = pautaMapper;
  }

  @Override
  public PautaDto criarPauta(PautaDto pautaDto) {
    LOGGER.info("Criando nova pauta");
    return pautaMapper.mapPautaToDto(pautaRepository.save(pautaMapper.mapDtoToPauta(pautaDto)));
  }
}
