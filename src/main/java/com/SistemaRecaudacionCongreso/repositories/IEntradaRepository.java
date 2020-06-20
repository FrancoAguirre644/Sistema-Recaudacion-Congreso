package com.SistemaRecaudacionCongreso.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaRecaudacionCongreso.entities.Entrada;

@Repository("entradaRepository")
public interface IEntradaRepository extends JpaRepository<Entrada,Serializable >{

}
