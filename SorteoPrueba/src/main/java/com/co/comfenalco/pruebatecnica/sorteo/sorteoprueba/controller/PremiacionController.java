package com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.controller;

import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain.Persona;
import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain.Premio;
import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.service.PersonaService;
import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.service.PremioService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author chris
 */
@Controller
public class PremiacionController {

    private final PremioService premioService;
    private final PersonaService personaService;

    public PremiacionController(PremioService premioService, PersonaService personaService) {
        this.premioService = premioService;
        this.personaService = personaService;
    }

    @RequestMapping("/premiacion")
    public String premiacionPersona(Model modelo) {
        System.out.println("Entro al  metodo de premiacion");
        Persona personaGanadora = personaService.buscarPersonaGanadora();
        personaGanadora.setPremio(premioService.buscarPremioGanado());
        System.out.println("ganador" + personaGanadora.toString());
        if (personaGanadora.getPremio().getCodigo() != null) {
          modelo.addAttribute("personaGanadora", personaGanadora);  
        } else {
            modelo.addAttribute("personaGanadora", new Persona()); 
        }
        return "personaGanadora";
    }

    @RequestMapping("/")
    public String listarVideoJuegos(Model modelo) {
        List<Premio> listPremios = premioService.buscarPremios();
        modelo.addAttribute("premios", listPremios);
        return "index";
    }

    @RequestMapping(value = "/premiacion/guardarPremiacion", method = RequestMethod.GET)
    public String guardarPremiacion(@RequestParam(name = "idPersona") String idPersona, @RequestParam(name = "idPremio") String idPremio) {
        System.out.println("idPersona " + idPersona);
        System.out.println("idPremio " + idPremio);
        Persona personaWin = personaService.buscarPersonaPorId(Long.parseLong(idPersona));//Long
        Premio premioWin = premioService.buscarPremioPorCodigo(Integer.parseInt(idPremio));//Integer

        personaWin.setPremio(premioWin);
        premioWin.setCantidad(premioWin.getCantidad() - 1);

        System.out.println("Persona obj " + personaWin.toString());
        System.out.println("Premio obj " + premioWin.toString());

        premioService.guardarPremio(premioWin);
        personaService.guardarPersona(personaWin);
        
        return "redirect:/persona";
    }

}
