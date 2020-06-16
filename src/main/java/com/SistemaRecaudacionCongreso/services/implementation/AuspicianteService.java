package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.repositories.IAuspicianteRepository;
import com.SistemaRecaudacionCongreso.services.IAuspicianteService;

@Service("auspicianteService")
public class AuspicianteService implements IAuspicianteService{
	
	@Autowired
	@Qualifier("auspicianteRepository")
	private IAuspicianteRepository auspicianteRepository;

	@Override
	public List<Auspiciante> getAll() {
		// TODO Auto-generated method stub
		return auspicianteRepository.findAll();
	}
	
	public void remove(long idPersona){
		auspicianteRepository.deleteById(idPersona);
	}

	public Auspiciante findByIdPersona(long idPersona){
		return auspicianteRepository.findByIdPersona(idPersona);
	}

}
