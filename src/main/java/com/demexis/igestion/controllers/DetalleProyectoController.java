/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gabriel
 */
@Controller
public class DetalleProyectoController {
    
    @RequestMapping(value = "/detalleProyecto", method = RequestMethod.POST)
    public ModelAndView inicio(HttpServletRequest request) {
        
        System.out.println("idProyecto: " + request.getHeader("idProyecto"));

        ModelAndView model = new ModelAndView();        
        model.setViewName("detalleProyecto");

        return model;

    }
    
}
