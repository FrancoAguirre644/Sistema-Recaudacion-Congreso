package com.SistemaRecaudacionCongreso.services;

import java.util.ArrayList;
import java.util.List;

import com.SistemaRecaudacionCongreso.entities.Entrada;
import com.SistemaRecaudacionCongreso.models.EntradaModel;
import com.SistemaRecaudacionCongreso.models.RankingConferenciaModel;

public interface IEntradaService {
	
	public List<Entrada> getAll();
	
	public void remove(long idEntrada);

	public EntradaModel findByIdEntrada(long idEntrada);

	public EntradaModel insertOrUpdate(EntradaModel entradaModel);
	
	public ArrayList<RankingConferenciaModel> getCantidadEspectadoresNivelEstudio();  

}
