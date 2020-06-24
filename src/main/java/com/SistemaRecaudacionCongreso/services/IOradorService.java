package com.SistemaRecaudacionCongreso.services;

import java.util.List;

import com.SistemaRecaudacionCongreso.entities.Orador;
import com.SistemaRecaudacionCongreso.models.OradorModel;

public interface IOradorService {
	
	public List<Orador> getAll();
	
	public void remove(long idPersona);
	
	public OradorModel findByIdPersona(long idPersona);
	
	public OradorModel save(OradorModel oradorModel);

}
