package com.SistemaRecaudacionCongreso.services;

import java.util.List;

import com.SistemaRecaudacionCongreso.entities.*;

/**
 * IEspectadorService
 */


public interface IEspectadorService {

    public List<Espectador> getAll();

    public void remove(long idPersona);

}