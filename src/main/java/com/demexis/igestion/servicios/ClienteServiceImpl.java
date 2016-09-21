/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.dao.ClienteDAO;
import com.demexis.igestion.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDAO clienteDAO;

    @Override
    public List<Cliente> getClientes() {
        return clienteDAO.getClientes();
    }

    @Override
    public Cliente getCliente(int idCliente) {
        return clienteDAO.getCliente(idCliente);
    }

}
