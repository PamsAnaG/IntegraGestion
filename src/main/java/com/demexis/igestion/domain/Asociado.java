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
public class Asociado {
    
    private int idAsociado;
    private String nombre;
    private String numeroMovil;
    private String correElectronico;

    /**
     * @return the idAsociado
     */
    public int getIdAsociado() {
        return idAsociado;
    }

    /**
     * @param idAsociado the idAsociado to set
     */
    public void setIdAsociado(int idAsociado) {
        this.idAsociado = idAsociado;
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
     * @return the numeroMovil
     */
    public String getNumeroMovil() {
        return numeroMovil;
    }

    /**
     * @param numeroMovil the numeroMovil to set
     */
    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    /**
     * @return the correElectronico
     */
    public String getCorreElectronico() {
        return correElectronico;
    }

    /**
     * @param correElectronico the correElectronico to set
     */
    public void setCorreElectronico(String correElectronico) {
        this.correElectronico = correElectronico;
    }

    
}
