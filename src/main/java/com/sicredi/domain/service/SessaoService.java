package com.sicredi.domain.service;

import com.sicredi.domain.dto.SessaoDto;
import com.sicredi.domain.response.SessaoResponse;

public interface SessaoService {

	SessaoResponse abrirSessao(SessaoDto sessaoDto);

}
