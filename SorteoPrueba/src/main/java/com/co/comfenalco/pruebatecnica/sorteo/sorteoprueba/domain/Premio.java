package com.co.comfenalco.pruebatecnica.sorteo.sorteoprueba.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author chris
 */
@Table(name = "premio")
@Entity
public class Premio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String  nombre;
    private Integer cantidad;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Premio{" + "codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad + '}';
    }
}
