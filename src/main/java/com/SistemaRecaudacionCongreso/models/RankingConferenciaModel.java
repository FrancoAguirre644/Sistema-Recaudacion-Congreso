package com.SistemaRecaudacionCongreso.models;

public class RankingConferenciaModel {
	
	private String nombreConferencia;
	private int cantidadVendida; 
	
	public RankingConferenciaModel() {
		
	}

	public RankingConferenciaModel(String nombreConferencia, int cantidadVendida) {
		super();
		this.nombreConferencia = nombreConferencia;
		this.cantidadVendida = cantidadVendida;
	}

	public String getNombreConferencia() {
		return nombreConferencia;
	}

	public void setNombreConferencia(String nombreConferencia) {
		this.nombreConferencia = nombreConferencia;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	@Override
	public String toString() {
		return "RankingConferenciaModel [nombreConferencia=" + nombreConferencia + ", cantidadVendida="
				+ cantidadVendida + "]";
	}
	

}
