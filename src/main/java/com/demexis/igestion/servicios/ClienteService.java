/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demexis.igestion.servicios;

import com.demexis.igestion.domain.Cliente;
import java.util.List;

/**
 *
 * @author pamela.gutierrez
 */
public interface ClienteService {
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(int idCliente);
    
}
