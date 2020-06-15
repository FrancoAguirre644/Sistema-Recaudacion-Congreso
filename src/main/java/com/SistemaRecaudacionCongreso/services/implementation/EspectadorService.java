package com.SistemaRecaudacionCongreso.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.SistemaRecaudacionCongreso.repositories.IEspectadorRepository;
import com.SistemaRecaudacionCongreso.services.IEspectadorService;

import java.util.List;

import com.SistemaRecaudacionCongreso.entities.*;

@Service("espectadorService")
public class EspectadorService implements IEspectadorService{
    
    @Autowired
    @Qualifier("espectadorRepository")
    private IEspectadorRepository espectadorRepository;

    public List<Espectador> getAll(){
        return espectadorRepository.findAll();
    }

    public void remove(long idPersona){
         espectadorRepository.deleteById(idPersona);
    }

    public Espectador findByIdPersona(long idPersona){
        return espectadorRepository.findByIdPersona(idPersona);
    }


}