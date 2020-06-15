package com.SistemaRecaudacionCongreso.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.SistemaRecaudacionCongreso.repositories.IEspectadorRepository;

import java.util.List;

import com.SistemaRecaudacionCongreso.entities.*;

@Service("espectadorService")
public class EspectadorService {
    
    @Autowired
    @Qualifier("espectadorRepository")
    private IEspectadorRepository espectadorRepository;

    public List<Espectador> getAll(){
        return espectadorRepository.findAll();
    }

}