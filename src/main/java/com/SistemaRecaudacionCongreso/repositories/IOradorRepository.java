package com.SistemaRecaudacionCongreso.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaRecaudacionCongreso.entities.Orador;

@Repository("oradorRepository")
public interface IOradorRepository extends JpaRepository<Orador, Serializable>{
	
	

}
