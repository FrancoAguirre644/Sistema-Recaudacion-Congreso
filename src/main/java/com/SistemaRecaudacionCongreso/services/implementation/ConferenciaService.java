package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.repositories.IConferenciaRepository;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;

@Service("conferenciaService")
public class ConferenciaService implements IConferenciaService{
	
	@Autowired
	@Qualifier("conferenciaRepository")
	private IConferenciaRepository conferenciaRepository;

	@Override
	public List<Conferencia> getAll() {
		// TODO Auto-generated method stub
		return conferenciaRepository.findAll();
	}
	
	
	

}
