/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Tarea;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface TareaProyectoDAO {
    
    public List<Tarea> obtieneTareasProyectoDashboard (int idProyecto);
    
}
