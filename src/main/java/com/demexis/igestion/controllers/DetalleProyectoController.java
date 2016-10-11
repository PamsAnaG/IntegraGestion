/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.domain.Alerta;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.RecursoRsmn;
import com.demexis.igestion.servicios.AlertaService;
import com.demexis.igestion.servicios.ProyectoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    AlertaService alertaService;

    @RequestMapping(value = "/detalleProyecto", method = RequestMethod.POST)
    public ModelAndView inicio(@ModelAttribute("Usuario") Proyecto proyecto, HttpServletRequest request) {

        Proyecto proyectoDetalle = proyectoService.obtieneProyecto(proyecto.getIdProyecto());

        List<RecursoRsmn> lstRecursos = new ArrayList<RecursoRsmn>();
        RecursoRsmn recurso1 = new RecursoRsmn();
        recurso1.setIdRecurso(1);
        recurso1.setNombre("Leobardo Jimenez");
        recurso1.setAbreviacion("LJS");
        recurso1.setTipoRecurso("Desarrolaldor HTML");
        RecursoRsmn recurso2 = new RecursoRsmn();
        recurso2.setIdRecurso(2);
        recurso2.setNombre("Gabriel Bretado");
        recurso2.setAbreviacion("GBP");
        recurso2.setTipoRecurso("Desarrolaldor Java");
        lstRecursos.add(recurso1);
        lstRecursos.add(recurso2);

        Gson gson = new Gson();

        ModelAndView model = new ModelAndView();
        model.addObject("proyecto", proyectoDetalle);
        model.addObject("recursos", lstRecursos);
        model.addObject("proyectoJson", gson.toJson(proyectoDetalle));
        model.setViewName("detalleProyecto");

        return model;

    }

    @PostMapping(value = "/guardaCambiosDP", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String guardaCambiosDP(@RequestBody String jsonCambios) {
        logger.info("Guardando cambios: [" + jsonCambios + "]");

        String respuesta = "0";
        try {
            GsonBuilder builder = new GsonBuilder();
            Map mapCambios = (LinkedTreeMap) builder.create().fromJson(jsonCambios, Object.class);
            int correctos = proyectoService.guardaCambiosTarea(mapCambios);
            respuesta = (correctos != mapCambios.size()) ? "0" : "1";
        } catch (Exception e) {
            logger.error("Error en la lectura del JSON de cambios tarea: " + e.getMessage());
            e.printStackTrace();
        }

        return respuesta;
    }

    @PostMapping(value = "/guardaAlerta", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String guardaAlerta(@RequestParam int idTarea, @RequestParam int tipoAlerta, @RequestParam int faseAlerta, @RequestParam int porcentajeAvance) {
        logger.debug("Guardando alerta..." + idTarea + "|" + tipoAlerta + "|" + faseAlerta + "|" + porcentajeAvance);
        Alerta alerta = new Alerta();
        alerta.setIdFaseTareaAlerta(faseAlerta);
        alerta.setIdTipoAlerta(tipoAlerta);

        alerta = alertaService.guardaAlertaproyecto(alerta, idTarea);

        return "Correcto-" + idTarea + "-" + faseAlerta;
    }

}
