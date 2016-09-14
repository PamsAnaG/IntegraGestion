/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Tarea;

/**
 *
 * @author pamela.gutierrez
 */
public interface ProyectoDAO {

    public Tarea guardaTarea(Tarea tarea, int idProyecto);

    public Proyecto guardaProyecto(Proyecto proyecto);
    
    public void guardaArchivoProyecto(Proyecto proyecto);

}
