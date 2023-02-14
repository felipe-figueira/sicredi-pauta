package com.sicredi.application;

import com.sicredi.domain.dto.PautaDto;
import com.sicredi.domain.service.PautaService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1/pauta")
public class PautaController {

	private final PautaService pautaService;

	@PostMapping("/criar")
	public ResponseEntity<PautaDto> criarPauta(@RequestBody @Valid PautaDto pautaDto){
		return ResponseEntity.status(201).body(pautaService.criarPauta(pautaDto));
	}

	/*@GetMapping("/resultado/{idPauta}")
	public ResponseEntity<PautaDto> resultadoPauta(@PathVariable String idPauta){

	}*/

}
