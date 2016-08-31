/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.domain.Usuario;

/**
 *
 * @author pamela.gutierrez
 */
public interface UsuarioService {

    public Usuario informacionUsuario(Usuario usuario);

    public Usuario privilegiosUsuario(Usuario usuario);

}
