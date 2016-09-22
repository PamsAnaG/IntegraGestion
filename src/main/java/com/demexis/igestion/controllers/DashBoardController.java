/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demexis.igestion.controllers;

import com.demexis.igestion.domain.Cliente;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.ResumenDashboard;
import com.demexis.igestion.servicios.ProyectoService;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pamela.gutierrez
 */
@Controller
public class DashBoardController {
    
    private final Logger logger = Logger.getLogger(DashBoardController.class);
    
    @Autowired
    ProyectoService proyectoService;
    
    @RequestMapping(value = "/dashboard", method = { RequestMethod.POST, RequestMethod.GET } )
    public ModelAndView inicio() {
        
        ResumenDashboard resumen = new ResumenDashboard();
        List<Proyecto> proyectos = proyectoService.obtieneProyectosDashboard();        
        
        resumen.setRecursosOcupados(5);
        resumen.setRecursosDisponibles(3);
        resumen.setColaProyectos(2);
        resumen.setRegistrosRadar(19);
        resumen.setValidacionRadar(45);
        resumen.setTareaFinalizada(4);
        resumen.setInicioProyecto(1);
        resumen.setCierreProyecto(7);        

        ModelAndView model = new ModelAndView();
        model.addObject("Proyecto", new Proyecto());
        model.addObject("resumen", resumen);
        model.addObject("proyectos", proyectos);
        model.addObject("numProyectos", proyectos.size());
        model.setViewName("dashboard");

        return model;

    }
    
    
    
}
