/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.dao.AsociadoDAO;
import com.demexis.igestion.domain.Asociado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class AsociadoServiceImpl implements AsociadoService {

    @Autowired
    AsociadoDAO asociadoDAO;

    @Override
    public List<Asociado> getAsociados() {
        return asociadoDAO.getAsociados();
    }

}
