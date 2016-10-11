/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Tarea;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface TareaProyectoDAO {
    
    public List<Tarea> obtieneTareasProyectoDashboard (int idProyecto);
    
    public List<Tarea> obtieneTareasProyecto(Proyecto proyecto);
    
    public List<Tarea> obtieneTareasHijas (int idTarea);
    
    public Tarea obtieneTareaPadre (int idProyecto);
    
    public List<Recurso> obtieneResponsableTareas (Tarea tarea);
    
    public List<Recurso> obtieneRecursos();
           
}
