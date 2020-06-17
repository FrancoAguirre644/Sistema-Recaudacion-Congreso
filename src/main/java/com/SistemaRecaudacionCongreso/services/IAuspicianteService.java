package com.SistemaRecaudacionCongreso.services;

import java.util.List;

import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.models.AuspicianteModel;

public interface IAuspicianteService {
	
	public List<Auspiciante> getAll();

	public void remove(long idPersona);

	public Auspiciante findByIdPersona(long idPersona);

	public AuspicianteModel insertOrUpdate(AuspicianteModel auspicianteModel);

}
