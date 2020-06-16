package com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.service;

import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain.Persona;
import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain.Premio;
import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.repository.PersonaRepository;
import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.repository.PremioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class PersonaService {

    private final PremioRepository premioRepository;
    private final PersonaRepository personaRepository;

    public PersonaService(PremioRepository premioRepository, PersonaRepository personaRepository) {
        this.premioRepository = premioRepository;
        this.personaRepository = personaRepository;
    }

    public Persona guardarPersona(Persona personaSave) {
        return personaRepository.save(personaSave);
    }

    public Persona actualizarPersona(Persona personaUpdate) {
        return personaRepository.save(personaUpdate);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    public List<Persona> buscarPersonas() {
        return personaRepository.findAll();
    }
    
    public Persona buscarPersonaPorNro(String nroDocumento){
        return personaRepository.findByNroDocumento(nroDocumento);
    }

    public List<Persona> buscarPersonasPorNro(String nroDocumento){
        return personaRepository.buscarNroDocumento(nroDocumento);
    }

    public Persona asignarPremioAPersona(String nroDocumentoGana) {
        int numAletorio=0;
        Premio premio = premioRepository.buscarPorCodigo(numAletorio);
        Persona personaPremiada = personaRepository.findByNroDocumento(nroDocumentoGana);
        if (premio != null) {
        } else {
            // retornar null pointer exception
        }
        return personaRepository.save(personaPremiada);
    }

    public Persona buscarPersonaGanadora(){
        Persona personaGanadora = new Persona();
        Random randomPersona = new Random();
        List<Persona> listaParticipantes=filtrarListaParticipantes(personaRepository.findAll());
        if (!listaParticipantes.isEmpty()) {
            int numAleatorio = randomPersona.nextInt(listaParticipantes.size());
            personaGanadora = listaParticipantes.get(numAleatorio);
        }
        
        return personaGanadora;
    }
    
    private List<Persona> filtrarListaParticipantes(List<Persona> listFull){
        List<Persona> listaFiltrada = new ArrayList<>();
        for (Persona persona : listFull) {
            if (persona.getPremio().getCodigo()==null) {
                listaFiltrada.add(persona);
            } else{
                System.out.println("tiene Premio "+persona.getPremio().toString());
            }
        }
        return listaFiltrada;
    }
    
    public Persona buscarPersonaPorId (Long idPersona){
        return personaRepository.buscarPorId(idPersona);
    }
}
