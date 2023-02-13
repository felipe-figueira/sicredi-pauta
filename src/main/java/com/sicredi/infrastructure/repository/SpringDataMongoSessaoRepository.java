package com.sicredi.infrastructure.repository;

import com.sicredi.domain.model.Sessao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoSessaoRepository extends MongoRepository<Sessao, String> {
}
