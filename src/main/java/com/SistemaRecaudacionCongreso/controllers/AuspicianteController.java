package com.SistemaRecaudacionCongreso.controllers;

import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.models.AuspicianteModel;
import com.SistemaRecaudacionCongreso.services.IAuspicianteService;

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

/**
 * AuspicianteController
 */
@Controller
@RequestMapping("/auspiciantes")
public class AuspicianteController {

    @Autowired
    @Qualifier("auspicianteService")
    private IAuspicianteService auspicianteService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelpers.AUSPICIANTE_INDEX);
        mAV.addObject("auspiciantes", auspicianteService.getAll());
        mAV.addObject("auspiciante", new AuspicianteModel());

        return mAV;
    }

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable ("id") long idPersona){
        auspicianteService.remove(idPersona);
        
        return new RedirectView(ViewRouteHelpers.AUSPICIANTE_ROOT);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Auspiciante get(@PathVariable ("id") long idPersona){
        return auspicianteService.findByIdPersona(idPersona);
    }


    @PostMapping("/save")
    public RedirectView save(@ModelAttribute("auspiciante") AuspicianteModel auspicianteModel){
        auspicianteService.insertOrUpdate(auspicianteModel);

        return new RedirectView(ViewRouteHelpers.AUSPICIANTE_ROOT);
    }
    
}