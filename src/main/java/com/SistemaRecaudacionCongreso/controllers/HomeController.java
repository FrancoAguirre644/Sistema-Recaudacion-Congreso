package com.SistemaRecaudacionCongreso.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.services.IAuspicianteService;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;
import com.SistemaRecaudacionCongreso.services.IEntradaService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	@Qualifier("conferenciaService")
	private IConferenciaService conferenciaService;

	@Autowired
	@Qualifier("entradaService")
	private IEntradaService entradaService;
	
	@Autowired
	@Qualifier("auspicianteService")
	private IAuspicianteService auspicianteService;
	
	@GetMapping("")
	public ModelAndView home() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.HOME_INDEX);
		
		mAV.addObject("costoSolventado", conferenciaService.costoSolventado());
		
		return mAV;
	}

	@GetMapping("reporte")
	public ModelAndView reporte() {	
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.REPORTE_INDEX);

		mAV.addObject("gananciaEntradas", entradaService.getGananciaTotalEntradas());
		
		mAV.addObject("gananciaAportes", conferenciaService.getAportesTotales());
		
		mAV.addObject("costoConferencias", conferenciaService.getCostoConferencias());

		mAV.addObject("total", conferenciaService.getBalanceTotal());

		return mAV;
	}
	

	

}
