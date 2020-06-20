package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.entities.Entrada;
import com.SistemaRecaudacionCongreso.repositories.IEntradaRepository;
import com.SistemaRecaudacionCongreso.services.IEntradaService;

@Service("entradaService")
public class EntradaService implements IEntradaService{
	
	@Autowired
	@Qualifier("entradaRepository")
	private IEntradaRepository entradaRepository;

	@Override
	public List<Entrada> getAll() {
		// TODO Auto-generated method stub
		return entradaRepository.findAll();
	}
	

}
