/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.TareaVO;

/**
 *
 * @author pamela.gutierrez
 */
public interface ProyectoDAO {

    public TareaVO guardaTarea(TareaVO tarea) throws Exception;

}