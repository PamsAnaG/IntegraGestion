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
public class Recurso extends Usuario{
    
    private int idRecurso;
    private String tipoRecurso;
    private int costoHora;

    /**
     * @return the tipoRecurso
     */
    public String getTipoRecurso() {
        return tipoRecurso;
    }

    /**
     * @param tipoRecurso the tipoRecurso to set
     */
    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    /**
     * @return the costoHora
     */
    public int getCostoHora() {
        return costoHora;
    }

    /**
     * @param costoHora the costoHora to set
     */
    public void setCostoHora(int costoHora) {
        this.costoHora = costoHora;
    }

    /**
     * @return the idRecurso
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * @param idRecurso the idRecurso to set
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }
    
}
