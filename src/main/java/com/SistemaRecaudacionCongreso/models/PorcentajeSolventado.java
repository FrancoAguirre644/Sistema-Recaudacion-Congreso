package com.SistemaRecaudacionCongreso.models;

public class PorcentajeSolventado {

    private String nombre;
    private double porcentaje;

    public PorcentajeSolventado() {
        super();
    }

    public PorcentajeSolventado(String nombre,double porcentaje) {
        super();
        this.nombre = nombre;
        this.porcentaje = porcentaje;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
	public String toString() {
		return "PorcentajeSolventado [nombre=" + this.nombre +  ", porcentaje=" + this.porcentaje + "]";
	}
    
}