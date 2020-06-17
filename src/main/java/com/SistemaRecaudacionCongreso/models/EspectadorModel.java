package com.SistemaRecaudacionCongreso.models;

import javax.persistence.Column;


public class EspectadorModel extends PersonaModel {

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "tipoDocumento")
	private String tipoDocumento;

	@Column(name = "nroDocumento")
	private long nroDocumento;

	public EspectadorModel() {

	}

	public EspectadorModel(long idPersona, String movil, String email, String nombre, String apellido, String tipoDocumento,
			long nroDocumento) {
		super(idPersona, movil, email);
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public long getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

}