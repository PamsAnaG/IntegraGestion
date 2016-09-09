/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.dao.ProyectoDAO;
import com.demexis.igestion.domain.ArchivoProyecto;
import com.demexis.igestion.domain.Asociado;
import com.demexis.igestion.domain.Cliente;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Tarea;
import com.demexis.igestion.domain.TipoProyecto;
import com.demexis.igestion.servicios.AsociadoService;
import com.demexis.igestion.servicios.ClienteService;
import com.demexis.igestion.servicios.TipoProyectoService;
import java.util.HashMap;
import java.util.List;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;
import net.sf.mpxj.reader.ProjectReader;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
    ProyectoDAO proyectoDao;

    @Autowired
    AsociadoService asociadoService;

    @Autowired
    TipoProyectoService tipoProyectoService;

    @RequestMapping(value = "/cargap", method = RequestMethod.POST)
    public ModelAndView cargaProyecto(@ModelAttribute("proyecto") Proyecto proyecto, ModelMap model) {//@ModelAttribute ArchivoProyecto fileFormBean) {

        logger.debug("Cargando proyecto...");


        /*try {

         CommonsMultipartFile uploaded = fileFormBean.getFichero();
         ProjectReader reader = new MPPReader();
         ProjectFile project = reader.read(uploaded.getInputStream());
         HashMap idTasks = new HashMap();

         Tarea tarea = new Tarea();
         for (Task task : project.getAllTasks()) {
         System.out.println("Task: " + task.getName() + " ID=" + task.getID() + " Unique ID=" + task.getUniqueID() + " Duration  " + task.getDuration().getDuration() + " Inicio " + task.getStart() + " Fin " + task.getFinish());
         tarea.setNombre(task.getName());
         tarea.setDuracion(task.getDuration().getDuration());
         tarea.setFechaFin(task.getFinish());
         tarea.setFechaInicio(task.getStart());
         tarea.setIdUnicoTarea(task.getUniqueID());
         Task parent = task.getParentTask();
         if (parent != null) {
         if (idTasks.containsKey(parent.getUniqueID())) {
         tarea.setIdTareaPadre((Integer) idTasks.get(parent.getUniqueID()));
         }
         }
         tarea = proyectoDao.guardaTarea(tarea);
         idTasks.put(tarea.getIdUnicoTarea(), tarea.getIdTarea());
         }
         } catch (Exception excp) {
         excp.printStackTrace();
         logger.error(excp.getMessage());
         }*/
        ModelAndView modelR = new ModelAndView();
        modelR.setViewName("dashboard");

        return modelR;

    }

    @RequestMapping(value = "/nuevop", method = RequestMethod.POST)
    public ModelAndView nuevoProyecto() {
        List<Cliente> clientes = clienteService.getClientes();
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre("Pamela");
        ModelAndView model = new ModelAndView("nuevoProyecto", "proyecto", proyecto);
        model.addObject("clientes", clientes);

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
