package com.SistemaRecaudacionCongreso.models;

import java.sql.Date;

public class ConferenciaModel {
	
	private long idConferencia;
	private String titulo;
	private Date fecha;
	private double costo;
	
	public ConferenciaModel() {
		// TODO Auto-generated constructor stub
	}

	public ConferenciaModel(long idConferencia, String titulo, Date fecha, double costo) {
		super();
		this.idConferencia = idConferencia;
		this.titulo = titulo;
		this.fecha = fecha;
		this.costo = costo;
	}

	public long getIdConferencia() {
		return idConferencia;
	}

	public void setIdConferencia(long idConferencia) {
		this.idConferencia = idConferencia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Conferencia [idConferencia=" + idConferencia + ", titulo=" + titulo + ", fecha=" + fecha + ", costo="
				+ costo + "]";
	}
	
	


}
