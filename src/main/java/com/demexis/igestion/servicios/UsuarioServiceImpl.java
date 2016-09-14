/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.dao.UsuarioDAO;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDao;

    @Override
    public Usuario informacionUsuario(Usuario usuario) {
        return usuarioDao.obtenUsuario(usuario);
    }

    @Override
    public Usuario privilegiosUsuario(Usuario usuario) {
        return usuarioDao.getPrivilegiosUsuario(usuario);
    }

    @Override
    public List<Recurso> getUsuariosRecursos() {
        return usuarioDao.getUsuariosRecursos();
    }

}
