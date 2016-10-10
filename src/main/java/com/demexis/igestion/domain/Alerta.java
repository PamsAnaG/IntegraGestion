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
public class Alerta {
    
    private int idAlerta;    
    private int idTipoAlerta;
    private String nombreTipoAlerta;
    private int idFaseTareaAlerta;
    private String nombreFaseTareaAlerta;    
    private int procentajeAvance;
    private String estatus;

    /**
     * @return the idAlerta
     */
    public int getIdAlerta() {
        return idAlerta;
    }

    /**
     * @param idAlerta the idAlerta to set
     */
    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    /**
     * @return the idTipoAlerta
     */
    public int getIdTipoAlerta() {
        return idTipoAlerta;
    }

    /**
     * @param idTipoAlerta the idTipoAlerta to set
     */
    public void setIdTipoAlerta(int idTipoAlerta) {
        this.idTipoAlerta = idTipoAlerta;
    }

    /**
     * @return the idFaseTareaAlerta
     */
    public int getIdFaseTareaAlerta() {
        return idFaseTareaAlerta;
    }

    /**
     * @param idFaseTareaAlerta the idFaseTareaAlerta to set
     */
    public void setIdFaseTareaAlerta(int idFaseTareaAlerta) {
        this.idFaseTareaAlerta = idFaseTareaAlerta;
    }

    /**
     * @return the procentajeAvance
     */
    public int getProcentajeAvance() {
        return procentajeAvance;
    }

    /**
     * @param procentajeAvance the procentajeAvance to set
     */
    public void setProcentajeAvance(int procentajeAvance) {
        this.procentajeAvance = procentajeAvance;
    }        

    /**
     * @return the nombreTipoAlerta
     */
    public String getNombreTipoAlerta() {
        return nombreTipoAlerta;
    }

    /**
     * @param nombreTipoAlerta the nombreTipoAlerta to set
     */
    public void setNombreTipoAlerta(String nombreTipoAlerta) {
        this.nombreTipoAlerta = nombreTipoAlerta;
    }

    /**
     * @return the nombreFaseTareaAlerta
     */
    public String getNombreFaseTareaAlerta() {
        return nombreFaseTareaAlerta;
    }

    /**
     * @param nombreFaseTareaAlerta the nombreFaseTareaAlerta to set
     */
    public void setNombreFaseTareaAlerta(String nombreFaseTareaAlerta) {
        this.nombreFaseTareaAlerta = nombreFaseTareaAlerta;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
