/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.domain.Asociado;
import com.demexis.igestion.domain.ClaseProyecto;
import com.demexis.igestion.domain.Cliente;
import com.demexis.igestion.domain.ConstantesIntegra;
import com.demexis.igestion.domain.ModalidadProyecto;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.TipoFacturacion;
import com.demexis.igestion.domain.TipoProyecto;
import com.demexis.igestion.domain.Usuario;
import com.demexis.igestion.servicios.AsociadoService;
import com.demexis.igestion.servicios.ClaseProyectoService;
import com.demexis.igestion.servicios.ClienteService;
import com.demexis.igestion.servicios.ProyectoService;
import com.demexis.igestion.servicios.TipoProyectoService;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pamela.gutierrez
 */
@Controller
public class CargaProyectoController {

    private Logger logger = Logger.getLogger(CargaProyectoController.class);

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProyectoService proyectoService;

    @Autowired
    AsociadoService asociadoService;

    @Autowired
    TipoProyectoService tipoProyectoService;

    @Autowired
    ClaseProyectoService claseProyectoService;

    @RequestMapping(value = "/cargap", method = RequestMethod.POST)
    public ModelAndView cargaProyecto(@ModelAttribute("proyecto") Proyecto proyecto, ModelMap model, HttpServletRequest request) {

        logger.debug("Cargando proyecto..." + proyecto.getNombre());
        Usuario usuarioFirmado = (Usuario) request.getSession().getAttribute(ConstantesIntegra.USUARIO_SESSION_INTEGRA.toString());

        proyecto.setUsuarioAlta(usuarioFirmado.getIdUsuario());
        Proyecto proyectoAlmacenado = proyectoService.almacenaProyecto(proyecto);
        
        Proyecto proyectoDetalle = proyectoService.obtieneProyecto(proyectoAlmacenado.getIdProyecto());
        Gson gson = new Gson();

        ModelAndView modelR = new ModelAndView();
        modelR.addObject("proyecto", proyectoDetalle);
        modelR.addObject("proyectoJson", gson.toJson(proyectoDetalle));
        modelR.setViewName("detalleProyecto");

        return modelR;

    }

    @RequestMapping(value = "/nuevop", method = RequestMethod.POST)
    public ModelAndView nuevoProyecto() {
        List<Cliente> clientes = clienteService.getClientes();
        List<TipoProyecto> tiposProyecto = tipoProyectoService.getTiposProyecto();
        List<ClaseProyecto> clasesProyecto = claseProyectoService.getClaseProyectos();
        List<TipoFacturacion> tiposFacturacion = claseProyectoService.getTipoFacturacion();
        List<ModalidadProyecto> modalidadProyecto = claseProyectoService.getModalidadProyectos();
        Proyecto proyecto = new Proyecto();
        ModelAndView model = new ModelAndView("nuevoProyecto", "proyecto", proyecto);
        model.addObject("clientes", clientes);
        model.addObject("tiposP", tiposProyecto);
        model.addObject("clasesP", clasesProyecto);
        model.addObject("tiposF", tiposFacturacion);
        model.addObject("modalidadP", modalidadProyecto);

        return model;
    }

    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Cliente> obtenClientes() {
        return clienteService.getClientes();
    }

    @GetMapping(value = "/asociados", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Asociado> obtenAsociados() {
        return asociadoService.getAsociados();
    }

    @GetMapping(value = "/tipoProyecto", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TipoProyecto> obtenTiposProyecto() {
        return tipoProyectoService.getTiposProyecto();
    }
}
