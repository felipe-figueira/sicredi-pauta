package com.sicredi.application;

import com.sicredi.domain.dto.PautaDto;
import com.sicredi.domain.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pauta")
public class PautaController {

	private final PautaService pautaService;

	@Autowired
	public PautaController(PautaService pautaService) {this.pautaService = pautaService;}

	@PostMapping("/criar")
	public ResponseEntity<PautaDto> criarPauta(@RequestBody PautaDto pautaDto){
		return ResponseEntity.ok().body(pautaService.criarPauta(pautaDto));
	}

}
