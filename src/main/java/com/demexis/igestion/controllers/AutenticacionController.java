/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.dao.UsuarioDAO;
import com.demexis.igestion.domain.UsuarioVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador de flujo de inicio de la aplicación
 *
 * @author Pame
 */
@Controller
public class AutenticacionController {

    private Logger logger = Logger.getLogger(AutenticacionController.class);

    @Autowired
    UsuarioDAO usuarioDao;

    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public ModelAndView inicio() {

        UsuarioVO usuario = new UsuarioVO();

        ModelAndView model = new ModelAndView();
        model.setViewName("inicio");
        model.addObject("Usuario", usuario);

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("Usuario") UsuarioVO usuario) {

        logger.debug("Firmando usuario - [" + usuario.getUsuario() + "]");

        ModelAndView model = new ModelAndView();
        UsuarioVO usuarioBD = usuarioDao.obtenUsuario(usuario);
        if (usuarioBD != null) {
            model.setViewName("dashboard");
            model.addObject("Usuario", usuario);
        } else {
            model.setViewName("inicio");
            model.addObject("Usuario", usuario);
        }

        return model;

    }

}
