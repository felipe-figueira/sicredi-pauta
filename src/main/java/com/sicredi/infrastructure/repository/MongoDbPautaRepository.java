package com.sicredi.infrastructure.repository;

import com.sicredi.domain.model.Pauta;
import com.sicredi.domain.repository.PautaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoDbPautaRepository implements PautaRepository {

  @Autowired
  private SpringDataMongoPautaRepository pautaRepository;

  @Override
  public Pauta save (Pauta pauta) {
   return pautaRepository.save(pauta);
  }

  @Override
  public Optional<Pauta> findById(String id) {
    return pautaRepository.findById(id);
  }
}
