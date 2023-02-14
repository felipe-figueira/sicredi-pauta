package com.sicredi.application;

import com.sicredi.domain.dto.SessaoDto;
import com.sicredi.domain.response.SessaoResponse;
import com.sicredi.domain.service.SessaoService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/sessao")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SessaoController {

	private final SessaoService sessaoService;

	@PostMapping("/abrir")
	public ResponseEntity<SessaoResponse> abrirSessao(@RequestBody @Valid SessaoDto sessaoDto){
		return ResponseEntity.ok().body(sessaoService.abrirSessao(sessaoDto));
	}

}
