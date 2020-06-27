package com.SistemaRecaudacionCongreso.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SistemaRecaudacionCongreso.entities.Entrada;

@Repository("entradaRepository")
public interface IEntradaRepository extends JpaRepository<Entrada,Serializable >{

    public Entrada findByIdEntrada(long idEntrada);
    
    @Query(nativeQuery=true,value = "SELECT COUNT(id_entrada) from Entrada e inner join Espectador es on e.espectador_id_persona=es.id_Persona where es.nivel_estudio=(:nivelEstudio)")
    public int countByNivelEstudio(String nivelEstudio);

}
