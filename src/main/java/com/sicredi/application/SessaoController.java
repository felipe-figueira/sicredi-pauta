package com.sicredi.application;

import com.sicredi.domain.dto.SessaoDto;
import com.sicredi.domain.response.SessaoResponse;
import com.sicredi.domain.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessao")
public class SessaoController {

	private final SessaoService sessaoService;

	@Autowired
	public SessaoController(SessaoService sessaoService) {this.sessaoService = sessaoService;}

	@PostMapping("/abrir")
	public ResponseEntity<SessaoResponse> abrirSessao(@RequestBody SessaoDto sessaoDto){
		return ResponseEntity.ok().body(sessaoService.abrirSessao(sessaoDto));
	}
}
