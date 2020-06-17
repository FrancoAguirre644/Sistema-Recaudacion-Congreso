package com.SistemaRecaudacionCongreso.converters;

import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.models.AuspicianteModel;

import org.springframework.stereotype.Component;

/**
 * AuspicianteConverter
 */

@Component("auspicianteConverter")
public class AuspicianteConverter {

    public AuspicianteModel entityToModel(Auspiciante auspiciante){
        return new AuspicianteModel(auspiciante.getIdPersona(),auspiciante.getMovil(),auspiciante.getEmail(),auspiciante.getRazonSocial(),auspiciante.getCuit(),auspiciante.getMontoAportado());
    }

    public Auspiciante modelToEntity(AuspicianteModel auspicianteModel){
        return new Auspiciante(auspicianteModel.getIdPersona(),auspicianteModel.getMovil(),auspicianteModel.getEmail(),auspicianteModel.getRazonSocial(),auspicianteModel.getCuit(),auspicianteModel.getMontoAportado());
    }
    
}