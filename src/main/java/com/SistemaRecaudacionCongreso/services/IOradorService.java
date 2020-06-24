package com.SistemaRecaudacionCongreso.services;

import java.util.List;

import com.SistemaRecaudacionCongreso.entities.Orador;

public interface IOradorService {
	
	public List<Orador> getAll();
	
	public void remove(long idPersona);

}
