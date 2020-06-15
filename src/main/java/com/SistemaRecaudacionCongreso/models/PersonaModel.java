package com.SistemaRecaudacionCongreso.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PersonaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long idPersona;

	@Column(name = "movil")
	protected String movil;

	@Column(name = "email")
	protected String email;

	public PersonaModel() {

	}

	public PersonaModel(long idPersona, String movil, String email) {
		super();

		this.idPersona = idPersona;
		this.movil = movil;
		this.email = email;
	}

	public long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
