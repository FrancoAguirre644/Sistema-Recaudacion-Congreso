package com.SistemaRecaudacionCongreso.models;

public class AuspicianteModel extends PersonaModel{
	
	private String razonSocial;
	private String cuit;
	private double montoAportado;
	
	public AuspicianteModel() {
		super();
	}

	public AuspicianteModel(long idPersona, String movil, String email, String razonSocial, String cuit,
			double montoAportado) {
		super(idPersona, movil, email);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.montoAportado = montoAportado;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public double getMontoAportado() {
		return montoAportado;
	}

	public void setMontoAportado(double montoAportado) {
		this.montoAportado = montoAportado;
	}

	@Override
	public String toString() {
		return "AuspicianteModel [razonSocial=" + razonSocial + ", cuit=" + cuit + ", montoAportado=" + montoAportado
				+ "]";
	}
	
	
	
	

}