package com.SistemaRecaudacionCongreso.services;

import java.util.ArrayList;
import java.util.List;

import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;
import com.SistemaRecaudacionCongreso.models.PorcentajeSolventado;
import com.SistemaRecaudacionCongreso.models.RankingConferenciaModel;


public interface IConferenciaService {
	
	public List<Conferencia> getAll();
	
	public void remove(long idConferencia);
	
	public ConferenciaModel findByIdConferencia(long idConferencia);
	
	public ConferenciaModel insertOrUpdate(ConferenciaModel conferenciaModel);
	
	public ArrayList<RankingConferenciaModel> getRanking();
	
	public int cantidadVendida(long idConferencia);
	
	public Double getAporteAuspiciantes(long idConferencia);
	
	public ArrayList<Auspiciante> getAuspiciantesConferencia(long idConferencia);

	public double getCostoConferencias();

	public double getAportesTotales();

	public double porcentajeSolventado(double costo,long idConferencia);
	
	public ArrayList<PorcentajeSolventado> costoSolventado();

}
