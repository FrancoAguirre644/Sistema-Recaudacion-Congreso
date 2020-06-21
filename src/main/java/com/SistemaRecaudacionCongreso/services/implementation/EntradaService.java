package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.converters.EntradaConverter;
import com.SistemaRecaudacionCongreso.entities.Entrada;
import com.SistemaRecaudacionCongreso.models.EntradaModel;
import com.SistemaRecaudacionCongreso.repositories.IEntradaRepository;
import com.SistemaRecaudacionCongreso.services.IEntradaService;

@Service("entradaService")
public class EntradaService implements IEntradaService{
	
	@Autowired
	@Qualifier("entradaRepository")
	private IEntradaRepository entradaRepository;

	@Autowired
	@Qualifier("entradaConverter")
	private EntradaConverter entradaConverter;

	@Override
	public List<Entrada> getAll() {
		// TODO Auto-generated method stub
		return entradaRepository.findAll();
	}

	@Override
	public void remove(long idEntrada) {
		// TODO Auto-generated method stub
		entradaRepository.deleteById(idEntrada);
	}

	@Override
	public EntradaModel findByIdEntrada(long idEntrada) {
		// TODO Auto-generated method stub
		return entradaConverter.entityToModel(entradaRepository.findByIdEntrada(idEntrada));
	}

	@Override
	public EntradaModel insertOrUpdate(EntradaModel entradaModel) {
		// TODO Auto-generated method stub
		Entrada entrada = entradaRepository.save(entradaConverter.modelToEntity(entradaModel));

		return entradaConverter.entityToModel(entrada);
	}

	
	

}