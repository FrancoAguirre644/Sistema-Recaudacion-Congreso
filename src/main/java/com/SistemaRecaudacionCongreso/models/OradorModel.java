package com.SistemaRecaudacionCongreso.models;


public class OradorModel extends PersonaModel{
	
	private String nombre;

	private String apellido;
	
	private String areaInvestigacion;
	
	public OradorModel() {
		
	}

	public OradorModel(long idPersona, String movil, String email, String nombre, String apellido, String areaInvestigacion) {
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
		return "OradorModel [nombre=" + nombre + ", apellido=" + apellido + ", areaInvestigacion=" + areaInvestigacion
				+ ", idPersona=" + idPersona + ", movil=" + movil + ", email=" + email + "]";
	}

	

	
}
