package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.converters.AuspicianteConverter;
import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.models.AuspicianteModel;
import com.SistemaRecaudacionCongreso.repositories.IAuspicianteRepository;
import com.SistemaRecaudacionCongreso.services.IAuspicianteService;

@Service("auspicianteService")
public class AuspicianteService implements IAuspicianteService{
	
	@Autowired
	@Qualifier("auspicianteRepository")
	private IAuspicianteRepository auspicianteRepository;

	@Autowired
	@Qualifier("auspicianteConverter")
	private AuspicianteConverter auspicianteConverter;


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

	public AuspicianteModel insertOrUpdate(AuspicianteModel auspicianteModel){
		Auspiciante auspiciante = auspicianteRepository.save(auspicianteConverter.modelToEntity(auspicianteModel));
		return auspicianteConverter.entityToModel(auspiciante);
	}

}
