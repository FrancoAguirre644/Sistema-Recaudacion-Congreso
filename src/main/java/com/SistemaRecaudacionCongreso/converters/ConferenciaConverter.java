package com.SistemaRecaudacionCongreso.converters;

import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;

public class ConferenciaConverter {
	
	public Conferencia modelToEntity(ConferenciaModel conferenciaModel) {
		return new Conferencia(conferenciaModel.getIdConferencia(),conferenciaModel.getTitulo(),conferenciaModel.getFecha(),conferenciaModel.getCosto());
	}
	
	public ConferenciaModel entityToModel(Conferencia conferencia) {
		return new ConferenciaModel(conferencia.getIdConferencia(),conferencia.getTitulo(),conferencia.getFecha(),conferencia.getCosto());
	}

}
