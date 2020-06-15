package com.SistemaRecaudacionCongreso.controllers;

import com.SistemaRecaudacionCongreso.services.IEspectadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/espectadores")
public class EspectadorController {

    @Autowired
    @Qualifier("espectadorService")
    private IEspectadorService espectadorService;

    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView("/espectador/index");
        mAV.addObject("espectadores", espectadorService.getAll());

        return mAV;
    }

    
}