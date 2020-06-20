package com.SistemaRecaudacionCongreso.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Entrada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEntrada;
	
	@Column(name="fechaCompra") 
	private Date fechaCompra;
	
	@Column(name="precio") 
	private double precio;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Espectador espectador;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Conferencia conferencia;
	
	public Entrada() {
		
	}

	public Entrada(long idEntrada, Date fechaCompra, double precio, Espectador espectador,
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
