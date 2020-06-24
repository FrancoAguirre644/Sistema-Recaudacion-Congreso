package com.SistemaRecaudacionCongreso.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Conferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idConferencia;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="costo")
	private double costo;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Orador orador;

	
	public Conferencia() {
		// TODO Auto-generated constructor stub
	}


	public Conferencia(long idConferencia, String titulo, String descripcion, Date fecha, double costo,Orador orador) {
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
		return "Conferencia [idConferencia=" + idConferencia + ", titulo=" + titulo + ", fecha=" + fecha + ", costo="
				+ costo + "]";
	}
	
	

}
