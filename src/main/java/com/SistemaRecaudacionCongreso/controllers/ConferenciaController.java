package com.SistemaRecaudacionCongreso.controllers;

import java.util.ArrayList;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.SistemaRecaudacionCongreso.converters.OradorConverter;
import com.SistemaRecaudacionCongreso.entities.Auspiciante;
import com.SistemaRecaudacionCongreso.entities.Conferencia;
import com.SistemaRecaudacionCongreso.entities.Entrada;
import com.SistemaRecaudacionCongreso.helpers.ViewRouteHelpers;
import com.SistemaRecaudacionCongreso.models.ConferenciaModel;
import com.SistemaRecaudacionCongreso.models.RankingConferenciaModel;
import com.SistemaRecaudacionCongreso.services.IAuspicianteService;
import com.SistemaRecaudacionCongreso.services.IConferenciaService;
import com.SistemaRecaudacionCongreso.services.IEntradaService;
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
	@Qualifier("entradaService")
	private IEntradaService entradaService;
	
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
		
		for(Conferencia c : conferenciaService.getAll()) {
			System.out.println(getGananciaEntrada(c.getIdConferencia()));
		}
		
		System.out.println(getGananciaTotalEntradas());
		
		

		return mAV;
	}
	
	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idConferencia, RedirectAttributes redirectAttrs) {
		conferenciaService.remove(idConferencia);
		
		redirectAttrs.addFlashAttribute("mensaje","Eliminado Correctamente");
		redirectAttrs.addFlashAttribute("clase", "success");
		
		return new RedirectView(ViewRouteHelpers.CONFERENCIA_ROOT);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ConferenciaModel get(@PathVariable("id") long idConferencia) {
		return conferenciaService.findByIdConferencia(idConferencia);
	}
	
	@PostMapping("/save")
	public RedirectView save(@ModelAttribute("conferencia") ConferenciaModel conferenciaModel, RedirectAttributes redirectAttrs) {	
        boolean band = false;
        int i=0;
                
        while(i<conferenciaService.getAll().size() && !band) {
        	Conferencia c =  conferenciaService.getAll().get(i);
        	        	
        	if(c.getTitulo().equalsIgnoreCase(conferenciaModel.getTitulo())) {
        		band = true;
        	}
        	
        	i++;
        }
        
        if(band) {
        	redirectAttrs.addFlashAttribute("mensaje","No se ha podido agregar debido a que ya existe esa conferencia");
			redirectAttrs.addFlashAttribute("clase", "danger");
        }else {
        	
    		conferenciaModel.setOrador(oradorConverter.modelToEntity(oradorService.findByIdPersona(conferenciaModel.getOrador().getIdPersona())));
    		conferenciaService.insertOrUpdate(conferenciaModel);
    		
        	redirectAttrs.addFlashAttribute("mensaje","Agregado Correctamente");
    		redirectAttrs.addFlashAttribute("clase", "success");
    		
        }
		

		return new RedirectView(ViewRouteHelpers.CONFERENCIA_ROOT);
	}
	
	@GetMapping("/listaAuspiciantes/{id}")
	@ResponseBody
	public ArrayList<Auspiciante> getAuspiciantes(@PathVariable("id") long idConferencia) {
		return conferenciaService.getAuspiciantesConferencia(idConferencia);
	}

	@GetMapping("/costoReal/{id}")
	@ResponseBody
	public Double getCostoReal(@PathVariable("id") long idConferencia){		
		return conferenciaService.findByIdConferencia(idConferencia).getCosto() - conferenciaService.getAporteAuspiciantes(idConferencia); 
	}
	
	@GetMapping("/rankingConferencia")
	@ResponseBody
	public ArrayList<RankingConferenciaModel> rankingConferencia(){
		return conferenciaService.getRanking();
	}
	
	@GetMapping("/reporte")
	public ModelAndView reporte() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.REPORTE);
		

		
		return mAV;
	}
	
	public double balance() {
		double balance = getCostoConferencias();
		
		for(Conferencia c : conferenciaService.getAll()) {
			balance -= conferenciaService.getAporteAuspiciantes(c.getIdConferencia()) - getGananciaTotalEntradas();
		}
		
		//SUMA DEL COSTO DE TODAS LAS CONFERENCIAS 
		//SUMA DE TODOS LOS APORTES DE TODAS LAS CONFERENCIAS
		//SUMA DE TODAS LAS ENTRADAS DE TODAS LAS CONFERENCIAS
		
		
		
		return balance;
	}
	
	public double getCostoConferencias() {
		double CostoConferencias = 0;
		
		for(Conferencia c : conferenciaService.getAll()) {
			CostoConferencias += c.getCosto();
		}
		
		return CostoConferencias;
	}
	
	public double getGananciaEntrada(long idConferencia) {
		double gananciaEntradas = 0;
		
		for(Entrada e : entradaService.getAll()) {
			
			if(e.getConferencia().getIdConferencia() == idConferencia) {
				gananciaEntradas += e.getPrecio();
			}
			
		}
		
		return gananciaEntradas;
	}
	
	public double getGananciaTotalEntradas() {
		double gananciaEntradas = 0;
		
		for(Conferencia c : conferenciaService.getAll()) {
			gananciaEntradas += getGananciaEntrada(c.getIdConferencia());
		}
		
		return gananciaEntradas;
	}
	
	public double getAportesTotales() {
		double aportesTotal = 0;
		
		for(Conferencia c : conferenciaService.getAll()) {
			aportesTotal += conferenciaService.getAporteAuspiciantes(c.getIdConferencia());
		}
		
		return aportesTotal;
	}


}
