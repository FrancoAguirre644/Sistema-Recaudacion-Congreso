package com.SistemaRecaudacionCongreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Auspiciante extends Persona{
	
	@Column(name="razonSocial")
	private String razonSocial;
	
	@Column(name="cuit")
	private String cuit;
	
	@Column(name="montoAportado")
	private double montoAportado;
	
    @ManyToOne
    @JoinColumn(name="id_conferencia", nullable=false)
    private Conferencia conferencia;
	
	public Auspiciante() {
		super();
	}

	public Auspiciante(long idPersona, String movil, String email, String razonSocial, String cuit,
			double montoAportado,Conferencia conferencia) {
		super(idPersona, movil, email);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.montoAportado = montoAportado;
		this.conferencia = conferencia;
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


	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}

	@Override
	public String toString() {
		return "Auspiciante [razonSocial=" + razonSocial + ", cuit=" + cuit + ", montoAportado=" + montoAportado
				+ ", idPersona=" + idPersona + ", movil=" + movil + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuit == null) ? 0 : cuit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auspiciante other = (Auspiciante) obj;
		if (cuit == null) {
			if (other.cuit != null)
				return false;
		} else if (!cuit.equals(other.cuit))
			return false;
		return true;
	}
	
	
	


}
