package com.SistemaRecaudacionCongreso.services;

import java.util.List;

import com.SistemaRecaudacionCongreso.entities.*;
import com.SistemaRecaudacionCongreso.models.EspectadorModel;

/**
 * IEspectadorService
 */


public interface IEspectadorService {

    public List<Espectador> getAll();

    public void remove(long idPersona);

    public abstract Espectador findByIdPersona(long idPersona);
    
    public EspectadorModel insertOrUpdate(EspectadorModel espectadorModel);


}