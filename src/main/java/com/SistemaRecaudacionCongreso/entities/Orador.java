package com.SistemaRecaudacionCongreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Orador extends Persona{
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "areaInvestigacion")
	private String areaInvestigacion;
	
	public Orador() {
		
	}

	public Orador(long idPersona, String movil, String email, String nombre, String apellido, String areaInvestigacion) {
		super(idPersona, movil, email);
		this.nombre = nombre;
		this.apellido = apellido;
		this.areaInvestigacion = areaInvestigacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAreaInvestigacion() {
		return areaInvestigacion;
	}

	public void setAreaInvestigacion(String areaInvestigacion) {
		this.areaInvestigacion = areaInvestigacion;
	}

	@Override
	public String toString() {
		return "Orador [nombre=" + nombre + ", apellido=" + apellido + ", areaInvestigacion=" + areaInvestigacion
				+ ", idPersona=" + idPersona + ", movil=" + movil + ", email=" + email + "]";
	}

	
	

}
