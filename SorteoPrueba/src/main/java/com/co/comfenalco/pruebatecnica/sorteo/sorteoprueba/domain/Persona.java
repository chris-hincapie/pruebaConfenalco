package com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author chris
 */
@Table(name = "persona")
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nroDocumento;
    private String tipoDocumento;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    @ManyToOne
    private Premio premio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Premio getPremio() {
        if (premio != null) {
            return premio;
        } else {
            return new Premio();
        }
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nroDocumento=" + nroDocumento + ", tipoDocumento=" + tipoDocumento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", premio=" + premio + '}';
    }
}
