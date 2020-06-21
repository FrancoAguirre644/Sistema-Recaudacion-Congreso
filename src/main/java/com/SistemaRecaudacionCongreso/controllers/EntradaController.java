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
import org.springframework.web.servlet.view.RedirectView;

import com.SistemaRecaudacionCongreso.converters.ConferenciaConverter;
import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.models.EntradaModel;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;
import com.SistemaRecaudacionCongreso.services.IEntradaService;
import com.SistemaRecaudacionCongreso.services.IEspectadorService;

@Controller
@RequestMapping("/entradas")
public class EntradaController {
	
	@Autowired
	@Qualifier("entradaService")
	private IEntradaService entradaService;

	@Autowired
	@Qualifier("espectadorService")
	private IEspectadorService espectadorService;

	@Autowired
	@Qualifier("conferenciaService")
	private IConferenciaService conferenciaService;

	@Autowired
	@Qualifier("conferenciaConverter")
	private ConferenciaConverter conferenciaConverter;

	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.ENTRADA_INDEX);
		mAV.addObject("entradas", entradaService.getAll());
		mAV.addObject("espectadores", espectadorService.getAll());
		mAV.addObject("conferencias", conferenciaService.getAll());
		mAV.addObject("entrada", new EntradaModel());

		return mAV;
	}
	
	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idEntrada) {
		entradaService.remove(idEntrada);
		return new RedirectView(ViewRouteHelpers.ENTRADA_ROOT);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public EntradaModel get(@PathVariable("id") long idEntrada){
		return entradaService.findByIdEntrada(idEntrada);
	}

	@PostMapping("/save")
	public RedirectView save(EntradaModel entradaModel){
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(entradaModel.getConferencia().getIdConferencia());
		System.out.println(entradaModel.getConferencia());
		System.out.println("-------------------------------------------------------------------------");

		entradaModel.setEspectador(espectadorService.findByIdPersona(entradaModel.getEspectador().getIdPersona()));
		entradaModel.setConferencia(conferenciaConverter.modelToEntity(conferenciaService.findByIdConferencia(entradaModel.getConferencia().getIdConferencia())));

		entradaService.insertOrUpdate(entradaModel);
		return new RedirectView(ViewRouteHelpers.ENTRADA_ROOT);
	}




}
