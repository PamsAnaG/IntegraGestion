/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.servicios.ProyectoService;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gabriel
 */
@Controller
public class DetalleProyectoController {
    
    private final Logger logger = Logger.getLogger(DetalleProyectoController.class);
    
    @Autowired
    ProyectoService proyectoService;
    
    @RequestMapping(value = "/detalleProyecto", method = RequestMethod.POST)
    public ModelAndView inicio(@ModelAttribute("Usuario") Proyecto proyecto, HttpServletRequest request) {
        
        Proyecto proyectoDetalle = proyectoService.obtieneProyecto(proyecto.getIdProyecto());

        ModelAndView model = new ModelAndView();
        model.addObject("proyecto", proyectoDetalle);
        model.setViewName("detalleProyecto");

        return model;

    }
    
}
