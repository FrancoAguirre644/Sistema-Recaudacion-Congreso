package com.SistemaRecaudacionCongreso.models;

import java.sql.Date;

import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.entities.Espectador;

public class EntradaModel {
	
	private long idEntrada;
	private Date fechaCompra;
	private double precio;
	private Espectador espectador;
	private Conferencia conferencia;
	
	public EntradaModel() {
		
	}

	public EntradaModel(long idEntrada, Date fechaCompra, double precio, Espectador espectador,
			Conferencia conferencia) {
		super();
		this.idEntrada = idEntrada;
		this.fechaCompra = fechaCompra;
		this.precio = precio;
		this.espectador = espectador;
		this.conferencia = conferencia;
	}

	public long getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Espectador getEspectador() {
		return espectador;
	}

	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}

	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}

	@Override
	public String toString() {
		return "EntradaModel [idEntrada=" + idEntrada + ", fechaCompra=" + fechaCompra + ", precio=" + precio
				+ ", espectador=" + espectador + ", conferencia=" + conferencia + "]";
	}


}
