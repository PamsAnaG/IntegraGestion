/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Alerta;

/**
 *
 * @author pamela.gutierrez
 */
public interface AlertaDAO {

    public Alerta guardaAlertaproyecto(Alerta alerta, int idTarea);

}
