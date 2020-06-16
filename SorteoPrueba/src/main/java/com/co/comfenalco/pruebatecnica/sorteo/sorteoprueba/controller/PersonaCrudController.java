package com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.controller;

import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain.Persona;
import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.service.PersonaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author chris
 */
@Controller
public class PersonaCrudController {

    private final PersonaService personaService;

    public PersonaCrudController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @RequestMapping("/persona/crear")
    public String mostrarFromCRUD(Model modelo) {
        modelo.addAttribute("persona", new Persona());
        return "fromPersona";
    }

    @RequestMapping(value ="/persona/modificar", method = RequestMethod.GET)
    public String mostrarFromMod(@RequestParam(name = "m") String nroDocumento, Model modelo) {
        Persona personaMod = new Persona();
        personaMod = personaService.buscarPersonaPorNro(nroDocumento);
        modelo.addAttribute("personaMod", personaMod);
        System.out.println("Prueba del objeto al llegar al from de modificar: " + personaMod.toString());
        return "fromPersonaMod";
    }
    
    @PostMapping("/persona/guardarCreacion")
    public String guardarCreacionPersona(Persona persona) {
        personaService.guardarPersona(persona);
        return "redirect:/persona/";
    }

    @PostMapping("/persona/guardarModificacion")
    public String guardarActualizarPersonas(Persona personaMod) {
        personaService.actualizarPersona(personaMod);
        return "redirect:/persona/";
    }

    @RequestMapping(value = "/persona/guardarEliminar", method = RequestMethod.GET)
    public String guardarEliminarPersonas(@RequestParam(name = "nroDocumento") String nroDocumento) {
        Persona personaElim = personaService.buscarPersonaPorNro(nroDocumento);
        if (personaElim.getPremio().getCodigo()==null) {
            personaService.eliminarPersona(personaElim.getId());
        }
        
        return "redirect:/persona/";
    }

    @RequestMapping("/persona")
    public String listarVideoJuegos(Model modelo) {

        List<Persona> listPersona = personaService.buscarPersonas();
        modelo.addAttribute("personas", listPersona);
        return "listadoPersona";
    }

    @RequestMapping("/persona/buscar")
    public String buscarPersonasPorNro(@RequestParam("q") String nroDocumento, Model modelo) {
        List<Persona> listPersona = new ArrayList<>();
        listPersona = personaService.buscarPersonasPorNro(nroDocumento);
        modelo.addAttribute("personas", listPersona);
        return "listadoPersona";
    }
}
