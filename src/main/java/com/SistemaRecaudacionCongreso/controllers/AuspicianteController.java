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

import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.models.AuspicianteModel;
import com.SistemaRecaudacionCongreso.services.IAuspicianteService;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;

/**
 * AuspicianteController
 */
@Controller
@RequestMapping("/auspiciantes")
public class AuspicianteController {

    @Autowired
    @Qualifier("auspicianteService")
    private IAuspicianteService auspicianteService;
    
    @Autowired
    @Qualifier("conferenciaService")
    private IConferenciaService conferenciaService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelpers.AUSPICIANTE_INDEX);
        mAV.addObject("auspiciantes", auspicianteService.getAll());
        mAV.addObject("auspiciante", new AuspicianteModel());
        mAV.addObject("conferencias", conferenciaService.getAll());

        return mAV;
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable ("id") long idPersona, RedirectAttributes redirectAttrs){
        auspicianteService.remove(idPersona);
        
    	redirectAttrs.addFlashAttribute("mensaje","Eliminado Correctamente");
		redirectAttrs.addFlashAttribute("clase", "success");
        
        return new RedirectView(ViewRouteHelpers.AUSPICIANTE_ROOT);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Auspiciante get(@PathVariable ("id") long idPersona){
        return auspicianteService.findByIdPersona(idPersona);
    }


    @PostMapping("/save")
    public RedirectView save(@ModelAttribute("auspiciante") AuspicianteModel auspicianteModel, RedirectAttributes redirectAttrs){
        boolean band = false;
        int i=0;
                
        while(i<auspicianteService.getAll().size() && !band) {
        	Auspiciante a =  auspicianteService.getAll().get(i);
        	        	
        	if(a.getCuit().equalsIgnoreCase(auspicianteModel.getCuit())) {
        		band = true;
        	}
        	
        	i++;
        }
        
        if(band) {
        	redirectAttrs.addFlashAttribute("mensaje","No se ha podido agregar debido a que ya existe ese auspiciante");
			redirectAttrs.addFlashAttribute("clase", "danger");
        }else {
            auspicianteService.insertOrUpdate(auspicianteModel);
        	redirectAttrs.addFlashAttribute("mensaje","Agregado Correctamente");
    		redirectAttrs.addFlashAttribute("clase", "success");
    		
        }

        return new RedirectView(ViewRouteHelpers.AUSPICIANTE_ROOT);
    }
    
}