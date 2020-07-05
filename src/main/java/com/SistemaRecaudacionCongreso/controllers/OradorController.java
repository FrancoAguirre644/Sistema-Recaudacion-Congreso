package com.SistemaRecaudacionCongreso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.SistemaRecaudacionCongreso.entities.Orador;
import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.models.OradorModel;
import com.SistemaRecaudacionCongreso.services.IOradorService;
import com.SistemaRecaudacionCongreso.services.implementation.UserService;


@Controller
@RequestMapping("/oradores")
public class OradorController {
	
	@Autowired
	@Qualifier("oradorService")
	private IOradorService oradorService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.ORADOR_INDEX);
		mAV.addObject("oradores", oradorService.getAll());
		mAV.addObject("imgUser",userService.getPhotoUser());

		
		
		return mAV;
	}
	
	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idPersona, RedirectAttributes redirectAttrs) {
		oradorService.remove(idPersona);
		
       	redirectAttrs.addFlashAttribute("mensaje","Eliminado Correctamente");
    	redirectAttrs.addFlashAttribute("clase", "success");
		
		return new RedirectView(ViewRouteHelpers.ORADOR_ROOT);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public OradorModel get(@PathVariable("id") long idPersona) {
		return oradorService.findByIdPersona(idPersona);
	}
	
	@PostMapping("/save")
	public RedirectView save(OradorModel oradorModel, RedirectAttributes redirectAttrs) {
        boolean band = false;
        int i=0;
                
        while(i<oradorService.getAll().size() && !band) {
        	Orador o =  oradorService.getAll().get(i);
        	        	
        	if(o.getEmail().equalsIgnoreCase(oradorModel.getEmail())) {
        		band = true;
        	}
        	
        	i++;
        }
        
        if(band) {
        	redirectAttrs.addFlashAttribute("mensaje","No se ha podido agregar debido a que ya existe ese orador");
			redirectAttrs.addFlashAttribute("clase", "danger");
        }else {
    		oradorService.save(oradorModel);
        	redirectAttrs.addFlashAttribute("mensaje","Agregado Correctamente");
    		redirectAttrs.addFlashAttribute("clase", "success");
    		
        }
		
        
		return new RedirectView(ViewRouteHelpers.ORADOR_ROOT);
	}
	
	@PostMapping("/update")
	public RedirectView update(OradorModel oradorModel, RedirectAttributes redirectAttrs) {		
		boolean band = false;
        int i=0;
                
        while(i<oradorService.getAll().size() && !band) {
        	Orador o =  oradorService.getAll().get(i);
        	        	
        	if(o.getEmail().equalsIgnoreCase(oradorModel.getEmail()) && o.getIdPersona() != oradorModel.getIdPersona()) {
        		band = true;
        	}
        	
        	i++;
        }
        
        if(band) {
        	redirectAttrs.addFlashAttribute("mensaje","No se ha podido actualizar debido a que ya existe ese orador");
			redirectAttrs.addFlashAttribute("clase", "danger");
        }else {
    		oradorService.save(oradorModel);
        	redirectAttrs.addFlashAttribute("mensaje","Actualizar Correctamente");
    		redirectAttrs.addFlashAttribute("clase", "success");
    		
        }
		
		
		return new RedirectView(ViewRouteHelpers.ORADOR_ROOT);

	}

}
