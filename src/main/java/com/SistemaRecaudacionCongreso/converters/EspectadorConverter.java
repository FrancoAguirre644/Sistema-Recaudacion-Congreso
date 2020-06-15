package com.SistemaRecaudacionCongreso.converters;

import org.springframework.stereotype.Component;

import com.SistemaRecaudacionCongreso.entities.Espectador;
import com.SistemaRecaudacionCongreso.models.EspectadorModel;

@Component("espectadorConverter")

public class EspectadorConverter {

	public EspectadorModel entityToModel(Espectador espectador) {
		return new EspectadorModel(espectador.getIdPersona(),espectador.getMovil(), espectador.getEmail(), espectador.getNombre(),espectador.getApellido(),espectador.getTipoDocumento(),espectador.getNroDocumento());
	}
	
	public Espectador modelToEntity(EspectadorModel espectadorModel) {
		return new Espectador(espectadorModel.getIdPersona(),espectadorModel.getMovil(), espectadorModel.getEmail(), espectadorModel.getNombre(),espectadorModel.getApellido(),espectadorModel.getTipoDocumento(),espectadorModel.getNroDocumento());
	}

}
