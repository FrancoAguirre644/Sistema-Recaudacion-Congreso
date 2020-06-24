package com.SistemaRecaudacionCongreso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.models.OradorModel;
import com.SistemaRecaudacionCongreso.services.IOradorService;

@Controller
@RequestMapping("/oradores")
public class OradorController {
	
	@Autowired
	@Qualifier("oradorService")
	private IOradorService oradorService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.ORADOR_INDEX);
		mAV.addObject("oradores", oradorService.getAll());
		
		return mAV;
	}
	
	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idPersona) {
		oradorService.remove(idPersona);
		return new RedirectView(ViewRouteHelpers.ORADOR_ROOT);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public OradorModel get(@PathVariable("id") long idPersona) {
		return oradorService.findByIdPersona(idPersona);
	}
	
	

}
