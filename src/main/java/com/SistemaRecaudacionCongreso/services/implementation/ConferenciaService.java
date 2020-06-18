package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.converters.ConferenciaConverter;
import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;
import com.SistemaRecaudacionCongreso.repositories.IConferenciaRepository;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;

@Service("conferenciaService")
public class ConferenciaService implements IConferenciaService{
	
	@Autowired
	@Qualifier("conferenciaRepository")
	private IConferenciaRepository conferenciaRepository;
	
	@Autowired
	@Qualifier("conferenciaConverter")
	private ConferenciaConverter conferenciaConverter;

	@Override
	public List<Conferencia> getAll() {
		// TODO Auto-generated method stub
		return conferenciaRepository.findAll();
	}
	
	public void remove(long idConferencia) {
		conferenciaRepository.deleteById(idConferencia);
	}
	
	public ConferenciaModel findByIdConferencia(long idConferencia) {
		return conferenciaConverter.entityToModel(conferenciaRepository.findByIdConferencia(idConferencia));
	}

	@Override
	public ConferenciaModel insertOrUpdate(ConferenciaModel conferenciaModel) {
		// TODO Auto-generated method stub
		Conferencia conferencia = conferenciaRepository.save(conferenciaConverter.modelToEntity(conferenciaModel));
		return conferenciaConverter.entityToModel(conferencia);
	}

	

}
