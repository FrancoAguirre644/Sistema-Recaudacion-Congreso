package com.SistemaRecaudacionCongreso.converters;

import org.springframework.stereotype.Component;

import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;

@Component("conferenciaConverter") 
public class ConferenciaConverter {
	
	public Conferencia modelToEntity(ConferenciaModel conferenciaModel) {
		return new Conferencia(conferenciaModel.getIdConferencia(),conferenciaModel.getTitulo(),conferenciaModel.getDescripcion(), conferenciaModel.getFecha(),conferenciaModel.getCosto(),conferenciaModel.getOrador());
	}
	
	public ConferenciaModel entityToModel(Conferencia conferencia) {
		return new ConferenciaModel(conferencia.getIdConferencia(),conferencia.getTitulo(),conferencia.getDescripcion(), conferencia.getFecha(),conferencia.getCosto(),conferencia.getOrador());
	}

}
