package com.SistemaRecaudacionCongreso.services.implementation;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.SistemaRecaudacionCongreso.converters.EspectadorConverter;
import com.SistemaRecaudacionCongreso.entities.Espectador;
import com.SistemaRecaudacionCongreso.models.EspectadorModel;
import com.SistemaRecaudacionCongreso.repositories.IEspectadorRepository;
import com.SistemaRecaudacionCongreso.services.IEspectadorService;

@Service("espectadorService")
public class EspectadorService implements IEspectadorService{
    
    @Autowired
    @Qualifier("espectadorRepository")
    private IEspectadorRepository espectadorRepository;
    
    @Autowired
    @Qualifier("espectadorConverter")
    private EspectadorConverter espectadorConverter;

    public List<Espectador> getAll(){
        return espectadorRepository.findAll();
    }

    public void remove(long idPersona){
         espectadorRepository.deleteById(idPersona);
    }

    public Espectador findByIdPersona(long idPersona){
        return espectadorRepository.findByIdPersona(idPersona);
    }
    
    @Override
	public EspectadorModel insertOrUpdate(EspectadorModel espectadorModel) {
		
		Espectador espectador= espectadorRepository.save(espectadorConverter.modelToEntity(espectadorModel));
		return espectadorConverter.entityToModel(espectador);
		
	}
    
    public Set<String> getNivelEstudio(){
    	return espectadorRepository.getNivelEstudio();
    }


}