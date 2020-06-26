package com.SistemaRecaudacionCongreso.services;

import java.util.ArrayList;
import java.util.List;

import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;
import com.SistemaRecaudacionCongreso.models.RankingConferenciaModel;


public interface IConferenciaService {
	
	public List<Conferencia> getAll();
	
	public void remove(long idConferencia);
	
	public ConferenciaModel findByIdConferencia(long idConferencia);
	
	public ConferenciaModel insertOrUpdate(ConferenciaModel conferenciaModel);
	
	public ArrayList<RankingConferenciaModel> getRanking();
	
	public int cantidadVendida(long idConferencia);

}
