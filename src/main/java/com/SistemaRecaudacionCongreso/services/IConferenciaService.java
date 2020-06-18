package com.SistemaRecaudacionCongreso.services;

import java.util.List;
import com.SistemaRecaudacionCongreso.entities.Conferencia;


public interface IConferenciaService {
	
	public List<Conferencia> getAll();
	
	public void remove(long idConferencia);

}
