/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.dao.TipoProyectoDAO;
import com.demexis.igestion.domain.TipoProyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class TipoProyectoServiceImpl implements TipoProyectoService {

    @Autowired
    TipoProyectoDAO tipoProyectoDAO;

    @Override
    public List<TipoProyecto> getTiposProyecto() {
        return tipoProyectoDAO.getTiposProyecto();
    }

    @Override
    public TipoProyecto getTipoProyecto(int idTipoProyecto) {
        return tipoProyectoDAO.getTipoProyecto(idTipoProyecto);
    }

}
