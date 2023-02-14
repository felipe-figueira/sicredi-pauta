package com.sicredi.domain.service.impl;

import com.sicredi.domain.dto.PautaDto;
import com.sicredi.domain.mapper.PautaMapper;
import com.sicredi.domain.model.Pauta;
import com.sicredi.domain.model.enums.StatusPauta;
import com.sicredi.domain.repository.PautaRepository;
import com.sicredi.domain.service.PautaService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PautaServiceImpl implements PautaService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PautaServiceImpl.class);
  private final PautaRepository pautaRepository;
  private final PautaMapper pautaMapper;
  private final MongoTemplate mongoTemplate;

  @Override
  public PautaDto criarPauta(PautaDto pautaDto) {
    LOGGER.info("Criando nova pauta");
    return pautaMapper.mapPautaToDto(pautaRepository.save(pautaMapper.mapDtoToPauta(pautaDto)));
  }

  @Override
  @Scheduled(fixedDelay = 1000)
  public void atualizarStatusPauta() {
    Query query = new Query();
    query.addCriteria(Criteria.where("horarioLimiteVoto").lt(LocalDateTime.now()))
      .addCriteria(Criteria.where("status").is(StatusPauta.VOTACAO_ABERTA));
    Update update = new Update();
    update.set("status", StatusPauta.PAUTA_ENCERRADA);
    mongoTemplate.updateMulti(query, update, Pauta.class);
  }
}
