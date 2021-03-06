package com.SistemaRecaudacionCongreso.models;

import java.sql.Date;

import com.SistemaRecaudacionCongreso.entities.Orador;

public class ConferenciaModel {
	
	private long idConferencia;
	private String titulo;
	private String descripcion;
	private Date fecha;
	private double costo;
	private Orador orador;
	
	public ConferenciaModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ConferenciaModel(long idConferencia, String titulo, String descripcion, Date fecha, double costo, Orador orador) {
		super();
		this.idConferencia = idConferencia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.costo = costo;
		this.orador = orador;
	}

	public long getIdConferencia() {
		return idConferencia;
	}

	public void setIdConferencia(long idConferencia) {
		this.idConferencia = idConferencia;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	

	public Orador getOrador() {
		return orador;
	}

	public void setOrador(Orador orador) {
		this.orador = orador;
	}

	@Override
	public String toString() {
		return "ConferenciaModel [idConferencia=" + idConferencia + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", fecha=" + fecha + ", costo=" + costo + "]";
	}



}
