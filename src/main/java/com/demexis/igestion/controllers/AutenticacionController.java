/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.domain.ConstantesIntegra;
import com.demexis.igestion.domain.Usuario;
import com.demexis.igestion.servicios.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    UsuarioService usuarioService;

    @RequestMapping(value = "/inicio", method = { RequestMethod.GET, RequestMethod.GET })
    public ModelAndView inicio() {

        Usuario usuario = new Usuario();
        
        ModelAndView model = new ModelAndView();
        model.setViewName("inicio");
        model.addObject("Usuario", usuario);

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("Usuario") Usuario usuario, HttpServletRequest request) {

        logger.debug("Firmando usuario - [" + usuario.getUsuario() + "]");

        ModelAndView model = new ModelAndView();
        Usuario usuarioBD = usuarioService.informacionUsuario(usuario);
        if (usuarioBD != null) {
            // RECUPERAMOS LOS DATOS DEL USUARIO DESDE LA BASE DE DATOS
            usuarioBD = usuarioService.privilegiosUsuario(usuarioBD);
            if (!usuarioBD.getPrivilegio().isEmpty()) {
                // GUARDAMOS AL USUARIO FIRMADO EN LA SESION
                HttpSession session = request.getSession();
                session.setAttribute(ConstantesIntegra.USUARIO_SESSION_INTEGRA.toString(), usuarioBD);
                model.setViewName("redirect:dashboard");
                model.addObject("Usuario", usuario);
            }
        } else {
            model.setViewName("inicio");
            model.addObject("Usuario", usuario);
        }

        return model;

    }

    @RequestMapping(value = "/salir", method = RequestMethod.POST)
    public ModelAndView salir(HttpServletRequest request) {

        logger.debug("Cerrando sesión...");

        ModelAndView model = new ModelAndView();
        Usuario usuario = new Usuario();

        HttpSession session = request.getSession();
        session.setAttribute(ConstantesIntegra.USUARIO_SESSION_INTEGRA.toString(), null);

        model.setViewName("redirect:inicio");
        model.addObject("Usuario", usuario);

        return model;

    }

}
