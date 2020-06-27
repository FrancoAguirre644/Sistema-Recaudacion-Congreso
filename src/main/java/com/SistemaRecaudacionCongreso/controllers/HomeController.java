package com.SistemaRecaudacionCongreso.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	@Qualifier("conferenciaService")
	private IConferenciaService conferenciaService;
	
	@GetMapping("")
	public String home() {
				
		return ViewRouteHelpers.HOME_INDEX;
	}
	

	

}
