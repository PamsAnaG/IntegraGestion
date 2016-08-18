/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.dao.ProyectoDAO;
import com.demexis.igestion.domain.ArchivoProyecto;
import com.demexis.igestion.domain.TareaVO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;
import net.sf.mpxj.reader.ProjectReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    ProyectoDAO proyectoDao;

    @RequestMapping(value = "/cargap", method = RequestMethod.POST)
    public ModelAndView cargaProyecto(@ModelAttribute ArchivoProyecto fileFormBean) {

        logger.debug("Cargando proyecto...");

        try {

            CommonsMultipartFile uploaded = fileFormBean.getFichero();
            ProjectReader reader = new MPPReader();
            ProjectFile project = reader.read(uploaded.getInputStream());
            HashMap idTasks = new HashMap();

            TareaVO tarea = new TareaVO();
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
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("dashboard");

        return model;

    }

    @RequestMapping(value = "/nuevop", method = RequestMethod.POST)
    public ModelAndView nuevoProyecto() {
        ModelAndView model = new ModelAndView();
        model.setViewName("nuevoProyecto");
        
        return model;
    }

}
