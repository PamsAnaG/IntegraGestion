/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Usuario;
import java.util.List;

/**
 *
 * @author pamela.gutierrez
 */
public interface UsuarioDAO {

    public Usuario obtenUsuario(Usuario usuario);
    
    public Usuario getPrivilegiosUsuario(Usuario usuario);
    
    public List<Usuario> getUsuariosRecursos();

}
