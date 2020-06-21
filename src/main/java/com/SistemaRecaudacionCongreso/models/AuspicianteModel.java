package com.SistemaRecaudacionCongreso.models;

import com.SistemaRecaudacionCongreso.entities.Conferencia;

public class AuspicianteModel extends PersonaModel{
	
	private String razonSocial;
	private String cuit;
	private double montoAportado;
	private Conferencia conferencia;
	
	public AuspicianteModel() {
		super();
	}

	public AuspicianteModel(long idPersona, String movil, String email, String razonSocial, String cuit,
			double montoAportado,Conferencia conferencia) {
		super(idPersona, movil, email);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.montoAportado = montoAportado;
		this.setConferencia(conferencia);
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public double getMontoAportado() {
		return montoAportado;
	}

	public void setMontoAportado(double montoAportado) {
		this.montoAportado = montoAportado;
	}

	@Override
	public String toString() {
		return "AuspicianteModel [razonSocial=" + razonSocial + ", cuit=" + cuit + ", montoAportado=" + montoAportado
				+ "]";
	}

	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}
	
	
	
	

}
