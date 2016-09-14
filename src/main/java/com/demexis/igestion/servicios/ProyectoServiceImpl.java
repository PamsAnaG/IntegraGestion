/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.dao.ProyectoDAO;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    ProyectoDAO proyectoDAO;

    @Override
    public Proyecto guardaProyecto(Proyecto proyecto) {
        return proyectoDAO.guardaProyecto(proyecto);
    }

    @Override
    public Tarea guardaTarea(Tarea tarea, int idProyecto) {
        return proyectoDAO.guardaTarea(tarea, idProyecto);
    }

}
