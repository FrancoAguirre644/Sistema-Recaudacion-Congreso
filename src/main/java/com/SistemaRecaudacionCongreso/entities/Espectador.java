package com.SistemaRecaudacionCongreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Espectador extends Persona {

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "tipoDocumento")
	private String tipoDocumento;

	@Column(name = "nroDocumento")
	private long nroDocumento;

	@Column(name = "nivelEstudio")
	private String nivelEstudio;

	public Espectador() {

	}

	public Espectador(long idPersona, String movil, String email, String nombre, String apellido, String tipoDocumento,
			long nroDocumento, String nivelEstudio) {
		super(idPersona, movil, email);
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nivelEstudio = nivelEstudio;
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

	public String getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento=" + tipoDocumento
				+ ", nroDocumento=" + nroDocumento + ", nivelEstudio=" + nivelEstudio + ", idPersona=" + idPersona
				+ ", movil=" + movil + ", email=" + email + "]";
	}
	

}
