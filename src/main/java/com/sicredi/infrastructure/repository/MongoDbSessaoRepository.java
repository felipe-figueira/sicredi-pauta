package com.sicredi.infrastructure.repository;

import com.sicredi.domain.model.Sessao;
import com.sicredi.domain.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoDbSessaoRepository implements SessaoRepository {

	@Autowired
	private SpringDataMongoSessaoRepository sessaoRepository;

	@Override
	public Sessao save(Sessao sessao) {
		return sessaoRepository.save(sessao);
	}
}
