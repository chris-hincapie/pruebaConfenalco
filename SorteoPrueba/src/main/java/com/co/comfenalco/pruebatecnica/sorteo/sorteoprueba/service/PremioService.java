package com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.service;

import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain.Premio;
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
public class PremioService {

    private final PremioRepository premioRepository;

    public PremioService(PremioRepository premioRepository) {
        this.premioRepository = premioRepository;
    }

    public List<Premio> buscarPremios() {
        return premioRepository.findAll();
    }

    public Premio buscarPremioGanado() {
        Premio premioGanado = new Premio();
        Random randomPremio = new Random();
        List<Premio> listaPremios = filtrarListaPremio(premioRepository.findAll());
        if (!listaPremios.isEmpty()) {
            int numAleatorio = randomPremio.nextInt(listaPremios.size());
            premioGanado = listaPremios.get(numAleatorio);
        }
        return premioGanado;
    }

    private List<Premio> filtrarListaPremio(List<Premio> listPremioFull) {
        List<Premio> listaPremios = new ArrayList<>();
        for (Premio Premio : listPremioFull) {
            if (Premio.getCantidad() > 0) {
                listaPremios.add(Premio);
            }
        }
        return listaPremios;
    }

    public Premio buscarPremioPorCodigo(Integer idPremio) {
        return premioRepository.buscarPorCodigo(idPremio);
    }

    public Premio guardarPremio(Premio premioMod) {
        return premioRepository.save(premioMod);
    }
}
