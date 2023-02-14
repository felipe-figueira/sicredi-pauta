package com.sicredi.domain.validation;

import com.sicredi.domain.exception.VotoException;
import com.sicredi.domain.model.Pauta;
import org.springframework.stereotype.Component;

@Component
public class VotoValidation {

	public void verificarAssociadoVoto(Pauta pauta, String idAssociado){
		if(pauta.getVotos().stream().anyMatch(voto -> voto.getIdAssociado().equals(idAssociado))){
			throw new VotoException();
		}
	}
}
