package com.sicredi.domain.repository;

import com.sicredi.domain.model.Pauta;
import java.util.Optional;
import org.springframework.stereotype.Repository;

public interface PautaRepository{

	Pauta save (Pauta pauta);

	Optional<Pauta> findById(String id);

}
