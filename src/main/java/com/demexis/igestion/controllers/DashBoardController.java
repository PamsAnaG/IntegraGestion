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
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public ModelAndView inicio() {
        
        ResumenDashboard resumen = new ResumenDashboard();
        //List<Proyecto> proyectos = proyectoService.obtieneProyectosDashboard();
        List<Proyecto> proyectos = new ArrayList<Proyecto>();
        
        resumen.setRecursosOcupados(5);
        resumen.setRecursosDisponibles(3);
        resumen.setColaProyectos(2);
        resumen.setRegistrosRadar(19);
        resumen.setValidacionRadar(45);
        resumen.setTareaFinalizada(4);
        resumen.setInicioProyecto(1);
        resumen.setCierreProyecto(7);
        Proyecto proyecto1 = new Proyecto();
        proyecto1.setIdProyecto(1);
        proyecto1.setNombre("Proyecto Prueba 1");
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("COVEG");
        proyecto1.setCliente(cliente1);
        proyecto1.setAvance(20.00);
        proyecto1.setEstatusAvance(1);
        Proyecto proyecto2 = new Proyecto();
        proyecto2.setIdProyecto(6579);
        proyecto2.setNombre("Creación de lotes venta por fundición");
        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Monte Pío Luz Saviñon");
        proyecto2.setCliente(cliente2);
        proyecto2.setAvance(41.12);
        proyecto2.setEstatusAvance(2);
        Proyecto proyecto3 = new Proyecto();
        proyecto3.setIdProyecto(6580);
        proyecto3.setNombre("Configuración y actualización de momentos presupuestales");
        Cliente cliente3 = new Cliente();
        cliente3.setNombre("COVEG");
        proyecto3.setCliente(cliente3);
        proyecto3.setAvance(63.23);
        proyecto3.setEstatusAvance(3);
        proyectos.add(proyecto3);
        proyectos.add(proyecto2);
        proyectos.add(proyecto1);
        proyectos.add(proyecto1);
        proyectos.add(proyecto1);
        proyectos.add(proyecto1);
        proyectos.add(proyecto1);
        proyectos.add(proyecto1);

        ModelAndView model = new ModelAndView();
        model.addObject("resumen", resumen);
        model.addObject("proyectos", proyectos);
        model.addObject("numProyectos", proyectos.size());
        model.setViewName("dashboard");

        return model;

    }
    
    
    
}
