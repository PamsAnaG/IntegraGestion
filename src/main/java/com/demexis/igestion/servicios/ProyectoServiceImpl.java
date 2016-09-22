/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import com.demexis.igestion.dao.ProyectoDAO;
import com.demexis.igestion.dao.TareaProyectoDAO;
import com.demexis.igestion.domain.Cliente;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Tarea;
import com.demexis.igestion.domain.TipoProyecto;
import com.demexis.igestion.domain.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;
import net.sf.mpxj.reader.ProjectReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class ProyectoServiceImpl implements ProyectoService {

    private Logger logger = Logger.getLogger(ProyectoServiceImpl.class);

    @Autowired
    ProyectoDAO proyectoDAO;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    TipoProyectoService tipoService;

    @Autowired
    TareaProyectoDAO tareaProyectoDAO;

    private final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;

    @Override
    public Proyecto guardaProyecto(Proyecto proyecto) {
        return proyectoDAO.guardaProyecto(proyecto);
    }

    @Override
    public Tarea guardaTarea(Tarea tarea, int idProyecto) {
        return proyectoDAO.guardaTarea(tarea, idProyecto);
    }

    @Override
    public Proyecto almacenaProyecto(Proyecto proyecto) {

        try {

            // VALIDAMOS EL CLIENTE ENVIADO            
            Cliente cliente = clienteService.getCliente(proyecto.getCliente().getIdCliente());
            proyecto.setCliente(cliente);
            TipoProyecto tipo = tipoService.getTipoProyecto(proyecto.getTipo().getIdTipoProyecto());
            proyecto.setTipo(tipo);
            proyecto = proyectoDAO.guardaProyecto(proyecto);
            proyecto.setArchivoProyecto(proyecto.getArchivoProyecto());
            logger.debug("Proyecto almacenado " + proyecto.getIdProyecto() + "|" + proyecto.getCliente().getNombre());

        } catch (Exception excp) {
            excp.printStackTrace();
            logger.error("Error al almacenar el proyecto: " + excp.getMessage());
        }

        try {
            proyectoDAO.guardaArchivoProyecto(proyecto);
        } catch (Exception excp) {
            logger.error("Error al guardar el archivo del proyecto [" + proyecto.getIdProyecto() + "] - " + excp.getMessage());
            excp.printStackTrace();
        }

        if (proyecto != null) {
            try {
                CommonsMultipartFile uploaded = proyecto.getArchivoProyecto().getFichero();
                logger.debug("Archivo " + proyecto.getArchivoProyecto().getFichero().getOriginalFilename());
                if (proyecto.getArchivoProyecto().getFichero().getOriginalFilename().contains(".mpp")) {
                    ProjectReader reader = new MPPReader();
                    ProjectFile project = reader.read(uploaded.getInputStream());
                    HashMap idTasks = new HashMap();

                    List<Recurso> usuariosRecursos = usuarioService.getUsuariosRecursos();
                    Iterator usuariosIt = null;

                    Tarea tarea = new Tarea();
                    for (Task task : project.getAllTasks()) {
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
                        tarea = proyectoDAO.guardaTarea(tarea, proyecto.getIdProyecto());
                        proyecto.getTareas().add(tarea);
                        idTasks.put(tarea.getIdUnicoTarea(), tarea.getIdTarea());

                        List<ResourceAssignment> resources = task.getResourceAssignments();
                        Iterator iResources = resources.iterator();
                        while (iResources.hasNext()) {
                            ResourceAssignment ra = (ResourceAssignment) iResources.next();
                            Resource resource = ra.getResource();
                            if (usuariosRecursos != null) {
                                usuariosIt = usuariosRecursos.iterator();
                                while (usuariosIt.hasNext()) {
                                    Recurso recurso = (Recurso) usuariosIt.next();
                                    if (resource.getName().toUpperCase().trim().contains(recurso.getNombre().toUpperCase().trim())) {
                                        proyectoDAO.guardaResponsableTarera(tarea, recurso);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    logger.error("Archivo de proyecto incorrecto...");
                }
            } catch (Exception excp) {
                excp.printStackTrace();
                logger.error(excp.getMessage());
            }
        }
        return proyecto;
    }

    private List<Tarea> ordenaTareas(List<Tarea> tareas) {
        try {
            /*
             HashMap<Integer, List<Tarea>> jerarquiaTareas = new HashMap<Integer, List<Tarea>>();
             while (tareasIt.hasNext()) {
             Tarea tarea = (Tarea) tareasIt.next();
             if (jerarquiaTareas.containsKey(tarea.getIdTareaPadre())) {
             List<Tarea> tareasT = jerarquiaTareas.get(tarea.getIdTareaPadre());
             tareasT.add(tarea);
             jerarquiaTareas.put(tarea.getIdTareaPadre(), tareasT);
             } else {
             jerarquiaTareas.put(tarea.getIdTareaPadre(), new ArrayList());
             }

             }

             Set keys = jerarquiaTareas.keySet();
             Iterator keysIt = keys.iterator();
             while (keysIt.hasNext()) {
             Integer key = (Integer) keysIt.next();
             List<Tarea> tareasM = (List) jerarquiaTareas.get(key);
             Iterator tareasMIt = tareasM.iterator();
             while (tareasMIt.hasNext()) {
             Tarea tarea = (Tarea) tareasMIt.next();
             logger.debug(key + "Hija | " + tarea.getNombre());
             }
             }*/
            Iterator tareasIt = tareas.iterator();
            List<Tarea> tareasOrdenadas = new ArrayList();
            int idTareaPrincipal = 0;
            Tarea tareaProyecto = null;
            Tarea tareaEnCurso = null;
            tareasIt = tareas.iterator();
            while (tareasIt.hasNext()) {
                Tarea tarea = (Tarea) tareasIt.next();
                if (tarea.getIdTareaPadre() == 0) {
                    tareaProyecto = tarea;
                    idTareaPrincipal = tarea.getIdTarea();
                } else {
                    if (tareaProyecto != null) {
                        // SI ES UNA TAREA DE GRUPO                        
                        if (idTareaPrincipal == tarea.getIdTareaPadre()) {
                            tareaEnCurso = (Tarea) tarea.clone();
                            logger.debug("Tarea " + "|" + tareaEnCurso.getNombre() + "| Hija de |" + tareaProyecto.getNombre());
                            Iterator tareasItInt = tareas.iterator();
                            while (tareasItInt.hasNext()) {
                                Tarea tareaInt = (Tarea) tareasItInt.next();
                                if (tareaInt.getIdTareaPadre() == tareaEnCurso.getIdTarea()) {
                                    logger.debug("Tarea " + "|" + tareaInt.getNombre() + "| Hija de |" + tareaEnCurso.getNombre());
                                    tareaEnCurso.getTareasHijas().add((Tarea) tareaInt.clone());
                                }
                            }
                            tareaProyecto.getTareasHijas().add(tareaEnCurso);
                        } else {

                            /*logger.debug("Comparando 2 " + tareaAnterior.getIdTarea() + "|" + tarea.getIdTareaPadre());
                             if (tareaAnterior.getIdTarea() == tarea.getIdTareaPadre()) {
                             logger.debug("Tarea " + "|" + tarea.getNombre() + "| Hija de |" + tareaAnterior.getNombre());
                             tareaAnterior.getTareasHijas().add(tarea);
                             }*/
                        }
                    }
                }
                tareasOrdenadas.add(tarea);
            }
            // REVISAMOS EL ORDEN CONSTRUIDO
            Iterator tareasOrdIt = tareaProyecto.getTareasHijas().iterator();
            logger.debug(tareaProyecto.getNombre());
            while (tareasOrdIt.hasNext()) {
                Tarea tarea = (Tarea) tareasOrdIt.next();
                logger.debug(tarea.getNombre());
                boolean tareasHijas = true;
                while(tareasHijas){
                    
                    
                }
            }
        } catch (Exception excp) {
            excp.printStackTrace();
        }
        return tareas;
    }

    @Override
    public Proyecto obtieneProyecto(int idProyecto) {

        Proyecto proyecto = proyectoDAO.obtieneProyecto(idProyecto);
        proyecto.setTareas(ordenaTareas(tareaProyectoDAO.obtieneTareasProyecto(proyecto)));
        return proyecto;
    }

    @Override
    public List<Proyecto> obtieneProyectosDashboard() {
        List<Tarea> tareas;
        List<Proyecto> lstProyectos = new ArrayList<Proyecto>();
        Date current = new Date();
        int alertado = 1;
        double proceso;
        double avance = 0;
        int sumAvance = 0;

        List<Proyecto> proyectos = proyectoDAO.obtieneProyectosDashboard();
        if (proyectos != null) {
            for (Proyecto proyecto : proyectos) {
                tareas = tareaProyectoDAO.obtieneTareasProyectoDashboard(proyecto.getIdProyecto());
                for (Tarea tarea : tareas) {
                    if (current.compareTo(tarea.getFechaFin()) > 0
                            && tarea.getPorcentajeCompletado() < 100
                            && alertado != 3) {
                        alertado = 3;
                    } else if (current.compareTo(tarea.getFechaFin()) <= 0
                            && current.compareTo(tarea.getFechaInicio()) > 0
                            && (alertado != 3 && alertado != 2)) {
                        proceso = 100 / tarea.getDuracion();
                        avance = ((current.getTime() - tarea.getFechaInicio().getTime()) / MILLSECS_PER_DAY) * proceso;
                        if (tarea.getPorcentajeCompletado() < avance) {
                            alertado = 2;
                        }
                    }
                    sumAvance = sumAvance + tarea.getPorcentajeCompletado();
                }
                proyecto.setAvance(sumAvance / tareas.size());
                proyecto.setEstatusAvance(alertado);
                lstProyectos.add(proyecto);
            }
        }
        proyectos = null;
        return lstProyectos;
    }

}
