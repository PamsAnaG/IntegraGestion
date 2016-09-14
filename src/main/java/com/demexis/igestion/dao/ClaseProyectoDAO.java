/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.ClaseProyecto;
import com.demexis.igestion.domain.ModalidadProyecto;
import com.demexis.igestion.domain.TipoFacturacion;
import java.util.List;

/**
 *
 * @author pamela.gutierrez
 */
public interface ClaseProyectoDAO {

    public List<ClaseProyecto> getClaseProyectos();

    public List<TipoFacturacion> getTipoFacturacion();

    public List<ModalidadProyecto> getModalidadProyectos();

}
