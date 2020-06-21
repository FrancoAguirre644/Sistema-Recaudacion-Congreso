package com.SistemaRecaudacionCongreso.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	/*
	
	@OneToMany(mappedBy="conferencia")
    private Set<Auspiciante> auspiciantes; */
	
	public Conferencia() {
		// TODO Auto-generated constructor stub
	}




	public Conferencia(long idConferencia, String titulo, String descripcion, Date fecha, double costo) {
		super();
		this.idConferencia = idConferencia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.costo = costo;
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
	}/*
	

	public Set<Auspiciante> getAuspiciantes() {
		return auspiciantes;
	}


	public void setAuspiciantes(Set<Auspiciante> auspiciantes) {
		this.auspiciantes = auspiciantes;
	}
*/
	@Override
	public String toString() {
		return "Conferencia [idConferencia=" + idConferencia + ", titulo=" + titulo + ", fecha=" + fecha + ", costo="
				+ costo + "]";
	}
	
	

}
