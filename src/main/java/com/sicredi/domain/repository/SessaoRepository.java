package com.sicredi.domain.repository;

import com.sicredi.domain.model.Sessao;
import org.springframework.stereotype.Repository;

public interface SessaoRepository {

	Sessao save (Sessao sessao);
}
