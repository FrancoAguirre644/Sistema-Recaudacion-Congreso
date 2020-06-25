package com.SistemaRecaudacionCongreso.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.springframework.web.servlet.view.RedirectView;

import com.SistemaRecaudacionCongreso.converters.OradorConverter;
import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;
import com.SistemaRecaudacionCongreso.services.IAuspicianteService;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;
import com.SistemaRecaudacionCongreso.services.IOradorService;

@Controller
@RequestMapping("/conferencias")
public class ConferenciaController {
	
	@Autowired
	@Qualifier("conferenciaService")
	private IConferenciaService conferenciaService;
	
	@Autowired
	@Qualifier("auspicianteService")
	private IAuspicianteService auspicianteService;
	
	@Autowired
	@Qualifier("oradorService")
	private IOradorService oradorService;
	
	@Autowired
	@Qualifier("oradorConverter")
	private OradorConverter oradorConverter;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.CONFERENCIA_INDEX);
		mAV.addObject("conferencias", conferenciaService.getAll());
		mAV.addObject("oradores", oradorService.getAll());
		
		return mAV;
	}
	
	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idConferencia) {
		conferenciaService.remove(idConferencia);
		return new RedirectView(ViewRouteHelpers.CONFERENCIA_ROOT);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ConferenciaModel get(@PathVariable("id") long idConferencia) {
		return conferenciaService.findByIdConferencia(idConferencia);
	}
	
	@PostMapping("/save")
	public RedirectView save(@ModelAttribute("conferencia") ConferenciaModel conferenciaModel) {
		conferenciaModel.setOrador(oradorConverter.modelToEntity(oradorService.findByIdPersona(conferenciaModel.getOrador().getIdPersona())));
		conferenciaService.insertOrUpdate(conferenciaModel);
		return new RedirectView(ViewRouteHelpers.CONFERENCIA_ROOT);
	}
	
	@GetMapping("/costoReal/{id}")
	@ResponseBody
	public ArrayList<Auspiciante> getCostoReal(@PathVariable("id") long idConferencia) {
		double costoAportado = 0;
		ArrayList<Auspiciante> auspiciantes = new ArrayList<Auspiciante>();
		
		for(Auspiciante a : auspicianteService.getAll()) {
			if(a.getConferencia().getIdConferencia() == idConferencia) {
				costoAportado += a.getMontoAportado();
				auspiciantes.add(a);
			}
		}
		
		for(Auspiciante auspiciante : auspiciantes ) {
			System.out.println(auspiciante);
		}
		
		//conferenciaService.findByIdConferencia(idConferencia).getCosto() - costoAportado
		
		return auspiciantes;
	}
	
	
	

}
