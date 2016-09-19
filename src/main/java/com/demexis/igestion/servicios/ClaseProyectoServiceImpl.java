/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.dao.ClaseProyectoDAO;
import com.demexis.igestion.domain.ClaseProyecto;
import com.demexis.igestion.domain.ModalidadProyecto;
import com.demexis.igestion.domain.TipoFacturacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class ClaseProyectoServiceImpl implements ClaseProyectoService {

    @Autowired
    ClaseProyectoDAO claseProyectoDAO;

    @Override
    public List<ClaseProyecto> getClaseProyectos() {
        return claseProyectoDAO.getClaseProyectos();
    }

    @Override
    public List<TipoFacturacion> getTipoFacturacion() {
        return claseProyectoDAO.getTipoFacturacion();
    }

    @Override
    public List<ModalidadProyecto> getModalidadProyectos() {
        return claseProyectoDAO.getModalidadProyectos();
    }

}
