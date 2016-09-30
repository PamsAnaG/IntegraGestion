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
    private int idFaseTareaAlerta;
    private int procentajeAvance;    

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
    
}
