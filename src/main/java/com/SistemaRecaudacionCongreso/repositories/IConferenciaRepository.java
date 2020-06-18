package com.SistemaRecaudacionCongreso.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaRecaudacionCongreso.entities.Conferencia;

@Repository("conferenciaRepository")
public interface IConferenciaRepository extends JpaRepository<Conferencia, Serializable>{
	
	public Conferencia findByIdConferencia(long idConferencia);
}
