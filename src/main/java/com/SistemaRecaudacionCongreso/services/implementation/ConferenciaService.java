package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.converters.ConferenciaConverter;
import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.entities.Entrada;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;
import com.SistemaRecaudacionCongreso.models.RankingConferenciaModel;
import com.SistemaRecaudacionCongreso.repositories.IConferenciaRepository;
import com.SistemaRecaudacionCongreso.services.IAuspicianteService;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;
import com.SistemaRecaudacionCongreso.services.IEntradaService;

@Service("conferenciaService")
public class ConferenciaService implements IConferenciaService {

	@Autowired
	@Qualifier("conferenciaRepository")
	private IConferenciaRepository conferenciaRepository;

	@Autowired
	@Qualifier("conferenciaConverter")
	private ConferenciaConverter conferenciaConverter;

	@Autowired
	@Qualifier("conferenciaService")
	private IConferenciaService conferenciaService;

	@Autowired
	@Qualifier("auspicianteService")
	private IAuspicianteService auspicianteService;

	@Autowired
	@Qualifier("entradaService")
	private IEntradaService entradaService;

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

	public ArrayList<RankingConferenciaModel> getRanking() {
		ArrayList<RankingConferenciaModel> ranking = new ArrayList<RankingConferenciaModel>();

		for (Conferencia c : conferenciaService.getAll()) {

			if (cantidadVendida(c.getIdConferencia()) > 0) {

				ranking.add(new RankingConferenciaModel(c.getTitulo(), cantidadVendida(c.getIdConferencia())));

			}
		}

		return ranking;

	}

	public int cantidadVendida(long idConferencia) {
		int cantidad = 0;

		for (Entrada e : entradaService.getAll()) {
			if (e.getConferencia().getIdConferencia() == idConferencia) {
				cantidad++;
			}
		}

		return cantidad;
	}

}
