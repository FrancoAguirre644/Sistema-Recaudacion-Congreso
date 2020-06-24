package com.SistemaRecaudacionCongreso.converters;

import org.springframework.stereotype.Component;

import com.SistemaRecaudacionCongreso.entities.Orador;
import com.SistemaRecaudacionCongreso.models.OradorModel;

@Component("oradorConverter")
public class OradorConverter {
	
	public Orador modelToEntity(OradorModel oradorModel) {
		return new Orador(oradorModel.getIdPersona(),oradorModel.getMovil(),oradorModel.getEmail(),oradorModel.getNombre(),oradorModel.getApellido(),oradorModel.getAreaInvestigacion());
	}
	
	public OradorModel entityToModel(Orador orador) {
		return new OradorModel(orador.getIdPersona(),orador.getMovil(),orador.getEmail(),orador.getNombre(),orador.getApellido(),orador.getAreaInvestigacion());
	}

}
