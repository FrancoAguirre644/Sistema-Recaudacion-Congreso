package com.SistemaRecaudacionCongreso.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SistemaRecaudacionCongreso.models.RankingConferenciaModel;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	@Qualifier("conferenciaService")
	private IConferenciaService conferenciaService;
	
	@GetMapping("")
	public ModelAndView home() {
		ModelAndView mAV = new ModelAndView("/home/index");
		
		mAV.addObject("ranking", conferenciaService.getRanking());
		
		return mAV;
	}
	

	

}
