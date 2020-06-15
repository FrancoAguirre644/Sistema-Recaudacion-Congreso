package com.SistemaRecaudacionCongreso.controllers;

import java.lang.ProcessBuilder.Redirect;

import com.SistemaRecaudacionCongreso.entities.Espectador;
import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.repositories.IEspectadorRepository;
import com.SistemaRecaudacionCongreso.services.IEspectadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/espectadores")
public class EspectadorController {

    @Autowired
    @Qualifier("espectadorService")
    private IEspectadorService espectadorService;

    @Autowired
    @Qualifier("espectadorRepository")
    private IEspectadorRepository espectadorRepository;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelpers.ESPECTADOR_INDEX);
        mAV.addObject("espectadores", espectadorService.getAll());

        return mAV;
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable ("id") long idPersona){
        espectadorService.remove(idPersona);

        return new RedirectView(ViewRouteHelpers.ESPECTADOR_ROOT);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Espectador get(@PathVariable ("id") long idPersona){
        //return espectadorService.findByIdPersona(idPersona);
        return espectadorRepository.findById(idPersona).get();
    }

    
}