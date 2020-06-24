package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.converters.OradorConverter;
import com.SistemaRecaudacionCongreso.entities.Orador;
import com.SistemaRecaudacionCongreso.models.OradorModel;
import com.SistemaRecaudacionCongreso.repositories.IOradorRepository;
import com.SistemaRecaudacionCongreso.services.IOradorService;

@Service("oradorService")
public class OradorService implements IOradorService{
	
	@Autowired
	@Qualifier("oradorRepository")
	private IOradorRepository oradorRepository;
	
	@Autowired
	@Qualifier("oradorConverter")
	private OradorConverter oradorConverter;

	@Override
	public List<Orador> getAll() {
		// TODO Auto-generated method stub
		return oradorRepository.findAll();
	}

	@Override
	public void remove(long idPersona) {
		// TODO Auto-generated method stub
		oradorRepository.deleteById(idPersona);
	}

	@Override
	public OradorModel findByIdPersona(long idPersona) {
		// TODO Auto-generated method stub
		return oradorConverter.entityToModel(oradorRepository.findByIdPersona(idPersona));
	}

	@Override
	public OradorModel save(OradorModel oradorModel) {
		// TODO Auto-generated method stub
		Orador orador = oradorRepository.save(oradorConverter.modelToEntity(oradorModel));
		return oradorConverter.entityToModel(orador);
	}
	
	

}
