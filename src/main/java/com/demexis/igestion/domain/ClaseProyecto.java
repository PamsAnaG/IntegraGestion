/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.domain;

/**
 *
 * @author pamela.gutierrez
 */
public class ClaseProyecto {

    private int idClaseProyecto;
    private String nombre;
    private String descripcion;

    /**
     * @return the idClaseProyecto
     */
    public int getIdClaseProyecto() {
        return idClaseProyecto;
    }

    /**
     * @param idClaseProyecto the idClaseProyecto to set
     */
    public void setIdClaseProyecto(int idClaseProyecto) {
        this.idClaseProyecto = idClaseProyecto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
