package com.sicredi.application;

import com.sicredi.domain.dto.VotoDto;
import com.sicredi.domain.service.VotoService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1/voto")
public class VotoController {

	private final VotoService votoService;

	@PostMapping("votar")
	public ResponseEntity<?> votarAssociado(@RequestBody @Valid VotoDto votoDto){
		votoService.votoAssociado(votoDto);
		return ResponseEntity.ok().build();
	}
}
