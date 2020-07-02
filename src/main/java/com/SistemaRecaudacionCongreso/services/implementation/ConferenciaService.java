package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.converters.ConferenciaConverter;
import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.entities.Entrada;
import com.SistemaRecaudacionCongreso.models.AportesModel;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;
import com.SistemaRecaudacionCongreso.models.PorcentajeSolventado;
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
	
	public Double getAporteAuspiciantes(long idConferencia) {
		double sumaAportes = 0;

		for(Auspiciante a : auspicianteService.getAll()) {
			if(a.getConferencia().getIdConferencia() == idConferencia) {
				sumaAportes +=a.getMontoAportado();
			}
		}
		
		return sumaAportes;
	}

	@Override
	public ArrayList<Auspiciante> getAuspiciantesConferencia(long idConferencia) {
		// TODO Auto-generated method stub
		ArrayList<Auspiciante> auspiciantes = new ArrayList<Auspiciante>();
		
		for(Auspiciante a : auspicianteService.getAll()) {
			if(a.getConferencia().getIdConferencia() == idConferencia) {
				auspiciantes.add(a);
			}
		}
		
		return auspiciantes;
	}

	public double getCostoConferencias() {
		double CostoConferencias = 0;
		
		for(Conferencia c : conferenciaService.getAll()) {
			CostoConferencias += c.getCosto();
		}
		
		return CostoConferencias;
	}


	public double getAportesTotales() {
		double aportesTotal = 0;
		
		for(Conferencia c : conferenciaService.getAll()) {
			aportesTotal += conferenciaService.getAporteAuspiciantes(c.getIdConferencia());
		}
		
		return aportesTotal;
	}

	public double getCostoSolventado(long idConferencia){
		return conferenciaService.findByIdConferencia(idConferencia).getCosto() - getAporteAuspiciantes(idConferencia) - entradaService.getGananciaEntrada(idConferencia);
	}
	
	public double porcentajeSolventado(double costo,long idConferencia){

		return  (conferenciaService.findByIdConferencia(idConferencia).getCosto() <= entradaService.getGananciaEntrada(idConferencia) + conferenciaService.getAporteAuspiciantes(idConferencia))?  100 :  ((entradaService.getGananciaEntrada(idConferencia) + conferenciaService.getAporteAuspiciantes(idConferencia)) * 100 ) / costo;
	}
	
	public ArrayList<PorcentajeSolventado> costoSolventado(){
		ArrayList<PorcentajeSolventado> lista = new ArrayList<PorcentajeSolventado>();


		for(Conferencia c : conferenciaService.getAll()){
			lista.add(new PorcentajeSolventado(c.getTitulo(), Math.round(porcentajeSolventado(c.getCosto(), (c.getIdConferencia()))* 10.0 ) /10.0 ) );
			
		}


		return lista;
	}


	public ArrayList<AportesModel> gananciaEntradas(){
		ArrayList<AportesModel> lstGananciaEntradas = new ArrayList<AportesModel>();

		for(Conferencia c : conferenciaService.getAll()){
			lstGananciaEntradas.add(new AportesModel(c.getTitulo(),entradaService.getGananciaEntrada(c.getIdConferencia())));
		}

		return lstGananciaEntradas;

	}

	public ArrayList<AportesModel> gananciaAportes(){
		ArrayList<AportesModel> lstGananciaAportes = new ArrayList<AportesModel>();

		for(Conferencia c : conferenciaService.getAll()){
			lstGananciaAportes.add(new AportesModel(c.getTitulo(),conferenciaService.getAporteAuspiciantes(c.getIdConferencia())));
		}

		return lstGananciaAportes;
	}

	@Override
	public double getBalanceTotal() {
		// TODO Auto-generated method stub
		return -(getCostoConferencias()) + getAportesTotales() + entradaService.getGananciaTotalEntradas();
	}
	

}
