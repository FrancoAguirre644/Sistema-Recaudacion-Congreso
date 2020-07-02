package com.SistemaRecaudacionCongreso.models;

public class AportesModel {

    private String nombre;
    private double aporte;

    public AportesModel() {
        super();
    }

    public AportesModel(String nombre,double aporte) {
        super();
        this.nombre = nombre;
        this.aporte = aporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "AportesModel [nombre=" + nombre + ", aporte="
        + aporte + "]";
    }

    
}