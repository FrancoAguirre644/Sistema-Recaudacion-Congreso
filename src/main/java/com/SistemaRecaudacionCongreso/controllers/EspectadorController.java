package com.SistemaRecaudacionCongreso.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.SistemaRecaudacionCongreso.entities.Espectador;
import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.models.EspectadorModel;
import com.SistemaRecaudacionCongreso.repositories.IEspectadorRepository;
import com.SistemaRecaudacionCongreso.services.IEspectadorService;
import com.SistemaRecaudacionCongreso.services.implementation.UserService;


@Controller
@RequestMapping("/espectadores")
public class EspectadorController {

    @Autowired
    @Qualifier("espectadorService")
    private IEspectadorService espectadorService;

    @Autowired
    @Qualifier("espectadorRepository")
    private IEspectadorRepository espectadorRepository;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelpers.ESPECTADOR_INDEX);
        mAV.addObject("espectadores", espectadorService.getAll());
        mAV.addObject("espectador", new EspectadorModel());
        mAV.addObject("imgUser",userService.getPhotoUser());

        
        return mAV;
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable ("id") long idPersona, RedirectAttributes redirectAttrs){
        espectadorService.remove(idPersona);
        
    	redirectAttrs.addFlashAttribute("mensaje","Eliminado Correctamente");
		redirectAttrs.addFlashAttribute("clase", "success");

        return new RedirectView(ViewRouteHelpers.ESPECTADOR_ROOT);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Espectador get(@PathVariable ("id") long idPersona){
        return espectadorRepository.findById(idPersona).get();
    }
    
    @PostMapping("/save")
	public RedirectView save(@ModelAttribute("espectador") EspectadorModel espectadorModel, RedirectAttributes redirectAttrs ) {
        boolean band = false;
        int i=0;
                
        while(i<espectadorService.getAll().size() && !band) {
        	Espectador e =  espectadorService.getAll().get(i);
        	        	
        	if(e.getNroDocumento() == espectadorModel.getNroDocumento()) {
        		band = true;
        	}
        	
        	i++;
        }
        
        if(band) {
        	redirectAttrs.addFlashAttribute("mensaje","No se ha podido agregar debido a que ya existe ese espectador");
			redirectAttrs.addFlashAttribute("clase", "danger");
        }else {
        	espectadorService.insertOrUpdate(espectadorModel);
        	redirectAttrs.addFlashAttribute("mensaje","Agregado Correctamente");
    		redirectAttrs.addFlashAttribute("clase", "success");
    		
        }
    	
    	
    	return new RedirectView(ViewRouteHelpers.ESPECTADOR_ROOT);
    }
    
    @PostMapping("/update")
	public RedirectView update(@ModelAttribute("espectador") EspectadorModel espectadorModel, RedirectAttributes redirectAttrs ) {
    	espectadorService.insertOrUpdate(espectadorModel);
    	return new RedirectView(ViewRouteHelpers.ESPECTADOR_ROOT);

    }


    
}