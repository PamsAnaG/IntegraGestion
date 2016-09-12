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
public class ModalidadProyecto {
    
    private int idModalidadProyecto;
    private String nombre;
    private String descripcion;

    /**
     * @return the idModalidadProyecto
     */
    public int getIdModalidadProyecto() {
        return idModalidadProyecto;
    }

    /**
     * @param idModalidadProyecto the idModalidadProyecto to set
     */
    public void setIdModalidadProyecto(int idModalidadProyecto) {
        this.idModalidadProyecto = idModalidadProyecto;
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
