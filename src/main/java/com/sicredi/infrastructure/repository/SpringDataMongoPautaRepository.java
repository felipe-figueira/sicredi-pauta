package com.sicredi.infrastructure.repository;

import com.sicredi.domain.model.Pauta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoPautaRepository extends MongoRepository<Pauta, String> {


}
