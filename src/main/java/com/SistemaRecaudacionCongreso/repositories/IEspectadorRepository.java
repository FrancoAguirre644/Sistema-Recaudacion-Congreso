package com.SistemaRecaudacionCongreso.repositories;

import java.io.Serializable;

import com.SistemaRecaudacionCongreso.entities.Espectador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * IEspectadorRepository
 */

 @Repository("espectadorRepository")
public interface IEspectadorRepository extends JpaRepository<Espectador,Serializable>{

    public abstract Espectador findByIdPersona(long idPersona);
    
}