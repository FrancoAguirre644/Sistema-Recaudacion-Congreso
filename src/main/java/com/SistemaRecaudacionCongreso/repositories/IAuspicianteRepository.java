package com.SistemaRecaudacionCongreso.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaRecaudacionCongreso.entities.Auspiciante;

@Repository("auspicianteRepository")
public interface IAuspicianteRepository extends JpaRepository<Auspiciante,Serializable>{
    
    public Auspiciante findByIdPersona(long idPersona);

}
