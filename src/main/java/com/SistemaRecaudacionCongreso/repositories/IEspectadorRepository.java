package com.SistemaRecaudacionCongreso.repositories;

import java.io.Serializable;
import java.util.Set;

import com.SistemaRecaudacionCongreso.entities.Espectador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * IEspectadorRepository
 */

 @Repository("espectadorRepository")
public interface IEspectadorRepository extends JpaRepository<Espectador,Serializable>{

    public abstract Espectador findByIdPersona(long idPersona);
    
    @Query(nativeQuery=true,value = "SELECT e.nivel_estudio from Espectador e")
    public Set<String> getNivelEstudio();
    
}