package com.SistemaRecaudacionCongreso.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.entities.Espectador;

@Repository("auspicianteRepository")
public interface IAuspicianteRepository extends JpaRepository<Auspiciante,Serializable>{
	

}
