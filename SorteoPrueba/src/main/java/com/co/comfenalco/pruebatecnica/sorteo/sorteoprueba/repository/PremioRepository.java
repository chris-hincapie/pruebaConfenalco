package com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.repository;

import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain.Premio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface PremioRepository extends JpaRepository<Premio, Integer>{
    
    @Query("from Premio p where p.codigo = ?1")
    public Premio buscarPorCodigo(int codPremio);  
}
