package com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.repository;

import com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
    @Query("from Persona p where p.nroDocumento like %?1% order by p.nombres")
    public List<Persona> buscarNroDocumento(String nroDocumento);
    
    public Persona findByNroDocumento(String nroDocumento);
    
    @Query("from Persona p where p.id = ?1")
    public Persona buscarPorId(Long idPersona);

}
