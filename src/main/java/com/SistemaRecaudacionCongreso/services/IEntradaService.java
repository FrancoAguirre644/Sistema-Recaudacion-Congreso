package com.SistemaRecaudacionCongreso.services;

import java.util.List;

import com.SistemaRecaudacionCongreso.entities.Entrada;
import com.SistemaRecaudacionCongreso.models.EntradaModel;

public interface IEntradaService {
	
	public List<Entrada> getAll();
	
	public void remove(long idEntrada);

	public EntradaModel findByIdEntrada(long idEntrada);

}
