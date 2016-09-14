/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Tarea;

/**
 *
 * @author pamela.gutierrez
 */
public interface ProyectoService {

    public Proyecto guardaProyecto(Proyecto proyecto);

    public Tarea guardaTarea(Tarea tarea, int idProyecto);

}
