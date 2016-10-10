/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.dao.AlertaDAO;
import com.demexis.igestion.domain.Alerta;
import com.demexis.igestion.domain.Tarea;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class AlertaServiceImpl implements AlertaService {

    @Autowired
    AlertaDAO alertaDAO;

    @Override
    public Alerta guardaAlertaproyecto(Alerta alerta, int idTarea) {
        return alertaDAO.guardaAlertaproyecto(alerta, idTarea);
    }

    @Override
    public List<Alerta> obtieneAlertasProyecto(int idTarea) {
        return alertaDAO.obtieneAlertasProyecto(idTarea);
    }

    @Override
    public List<Tarea> obtieneAlertasActivas() {
        return alertaDAO.obtieneAlertasActivas();
    }

    @Override
    public void actualizaEstadoAlerta(String estado, int idAlerta){
        alertaDAO.actualizaEstadoAlerta(estado, idAlerta);
    }

}
