/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.TipoProyecto;
import com.demexis.igestion.servicios.ProyectoService;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

        Gson gson = new Gson();

        ModelAndView model = new ModelAndView();
        model.addObject("proyecto", proyectoDetalle);
        model.addObject("proyectoJson", gson.toJson(proyectoDetalle));
        model.setViewName("detalleProyecto");

        return model;

    }

    @PostMapping(value = "/guardaAlerta", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String guardaAlerta(@RequestParam int idTarea, @RequestParam int tipoAlerta, @RequestParam int faseAlerta) {
        logger.debug("Guardando alerta..." + idTarea + "|" + tipoAlerta + "|" + faseAlerta);

        return "Correcto";
    }

}
