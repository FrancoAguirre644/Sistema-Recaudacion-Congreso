package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.entities.Orador;
import com.SistemaRecaudacionCongreso.repositories.IOradorRepository;
import com.SistemaRecaudacionCongreso.services.IOradorService;

@Service("oradorService")
public class OradorService implements IOradorService{
	
	@Autowired
	@Qualifier("oradorRepository")
	private IOradorRepository oradorRepository;

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
	
	

}
