package com.SistemaRecaudacionCongreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Auspiciante extends Persona{
	
	@Column(name="razonSocial")
	private String razonSocial;
	
	@Column(name="cuit")
	private String cuit;
	
	@Column(name="montoAportado")
	private double montoAportado;
	
	public Auspiciante() {
		super();
	}

	public Auspiciante(long idPersona, String movil, String email, String razonSocial, String cuit,
			double montoAportado) {
		super(idPersona, movil, email);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.montoAportado = montoAportado;
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
		return "Auspiciante [razonSocial=" + razonSocial + ", cuit=" + cuit + ", montoAportado=" + montoAportado
				+ ", idPersona=" + idPersona + ", movil=" + movil + ", email=" + email + "]";
	}
	
	


}
