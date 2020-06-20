package com.SistemaRecaudacionCongreso.converters;

import com.SistemaRecaudacionCongreso.entities.Entrada;
import com.SistemaRecaudacionCongreso.models.EntradaModel;

public class EntradaConverter {
	
	public Entrada modelToEntity(EntradaModel entradaModel) {
		return new Entrada(entradaModel.getIdEntrada(),entradaModel.getFechaCompra(),entradaModel.getPrecio(),entradaModel.getEspectador(),entradaModel.getConferencia());
	}
	
	public EntradaModel entityToModel(Entrada entrada) {
		return new EntradaModel(entrada.getIdEntrada(),entrada.getFechaCompra(),entrada.getPrecio(),entrada.getEspectador(),entrada.getConferencia());
	}



}
