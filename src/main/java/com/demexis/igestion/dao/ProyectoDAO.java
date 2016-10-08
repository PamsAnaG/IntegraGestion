/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Tarea;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pamela.gutierrez
 */
public interface ProyectoDAO {

    public Tarea guardaTarea(Tarea tarea, int idProyecto);

    public Proyecto guardaProyecto(Proyecto proyecto);

    public void guardaArchivoProyecto(Proyecto proyecto);

    public void guardaResponsableTarera(Tarea tarea, Recurso recurso);

    public Proyecto obtieneProyecto(int idProyecto);

    public List<Proyecto> obtieneProyectosDashboard();
    
    public boolean actualizaInfoTarea(int idTarea, String descripcion, Date fechaInicio, Date fechaFin, int duracion);
    
    public boolean actualizaRecursosTarea(int idTarea, int idRecurso, int accion);

}
