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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    AlertaService alertaService;

    @Autowired
    TareaProyectoDAO tareaProyectoDAO;

    private final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
    private final SimpleDateFormat fechaYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

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
            proyecto.setUsuarioAlta(proyecto.getUsuarioAlta());
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

    private Tarea ordenaTareas(Proyecto proyecto) {

        Tarea tareaProyecto = null;
        try {
            tareaProyecto = tareaProyectoDAO.obtieneTareaPadre(proyecto.getIdProyecto());

            if (tareaProyecto != null) {
                ordenaTareasHijas(tareaProyecto);
            }
        } catch (Exception excp) {
            excp.printStackTrace();
        }
        return tareaProyecto;
    }

    private void imprimeTareas(Tarea tarea) {
        try {
            List<Tarea> tareasHijas = tarea.getTareasHijas();
            for (Tarea tareaHija : tareasHijas) {
                List<Tarea> tareasHijasInt = tareaHija.getTareasHijas();
                if (tareasHijasInt != null && !tareasHijasInt.isEmpty()) {
                    imprimeTareas(tareaHija);
                }
            }
        } catch (Exception excp) {
            logger.error("Error imprimiendo tareas: " + excp.getMessage());
        }
    }

    private void ordenaTareasHijas(Tarea tarea) {
        try {
            List<Tarea> tareasHijas = tareaProyectoDAO.obtieneTareasHijas(tarea.getIdTarea());
            for (Tarea tareaHija : tareasHijas) {
                // OBTENEMOS LOS RESPONSABLES DE LA TAREA
                tareaHija.setResponsables(tareaProyectoDAO.obtieneResponsableTareas(tareaHija));
                tareaHija.setAlertas(alertaService.obtieneAlertasProyecto(tareaHija.getIdTarea()));
                List<Tarea> tareasHijasInt = tareaProyectoDAO.obtieneTareasHijas(tareaHija.getIdTarea());
                if (tareasHijasInt != null && !tareasHijasInt.isEmpty()) {
                    ordenaTareasHijas(tareaHija);
                    tarea.getTareasHijas().add(tareaHija);
                } else {
                    tarea.getTareasHijas().add(tareaHija);
                }
            }
        } catch (Exception excp) {
            logger.error("Error ordenando tareas: " + excp.getMessage());
        }
    }

    @Override
    public Proyecto obtieneProyecto(int idProyecto) {

        Proyecto proyecto = proyectoDAO.obtieneProyecto(idProyecto);
        proyecto.setTareaPrincipal(ordenaTareas(proyecto));
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
                if (tareas != null) {
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
        }
        proyectos = null;
        return lstProyectos;
    }

    @Override
    public Proyecto obtieneProyectoBD(int idProyecto) {
        return proyectoDAO.obtieneProyecto(idProyecto);
    }

    @Override
    public int guardaCambiosTarea(Map cambios) {
        int actualizadas = 0;
        int idTarea = 0;
        int duracion = 0;
        boolean actualiza = false;
        String descripcion;
        Date fechaInicio;
        Date fechaFin;

        Map cambiosDP;
        Map recursos;

        try {
            Iterator i = cambios.keySet().iterator();
            while (i.hasNext()) {
                String key = (String) i.next();
                logger.info("Procesando información de Tarea: " + cambios.get(key));

                cambiosDP = (Map) cambios.get(key);
                if (cambiosDP.get("idTarea") != null) {
                    idTarea = (Double.valueOf(String.valueOf(cambiosDP.get("idTarea")))).intValue();

                    if (((String) cambiosDP.get("accion")).equals("m")) {
                        logger.info("Actualización de información de Tarea... [" + idTarea + "]");

                        descripcion = ((String) cambiosDP.get("descripcion")) != null ? (String) cambiosDP.get("descripcion") : null;
                        fechaInicio = ((String) cambiosDP.get("fechaInicio")) != null ? fechaYYYYMMDD.parse((String) cambiosDP.get("fechaInicio")) : null;
                        fechaFin = ((String) cambiosDP.get("fechaFin")) != null ? fechaYYYYMMDD.parse((String) cambiosDP.get("fechaFin")) : null;
                        if ((fechaInicio != null && fechaFin == null)) {
                            fechaFin = fechaInicio;
                        } else if ((fechaFin != null && fechaInicio == null)) {
                            fechaInicio = fechaFin;
                        }
                        if (fechaInicio != null && fechaFin != null) {
                            if (fechaInicio.equals(fechaFin)) {
                                duracion = 1;
                            } else {
                                duracion = (int) ((fechaFin.getTime() - fechaInicio.getTime()) / MILLSECS_PER_DAY);
                            }
                        }
                        if (descripcion != null || fechaInicio != null || fechaFin != null) {
                            actualiza = proyectoDAO.actualizaInfoTarea(idTarea, descripcion, fechaInicio, fechaFin, duracion);
                        }

                        recursos = (Map) cambiosDP.get("recursos");
                        if (recursos != null) {
                            logger.info("Procesando recursos...");
                            Iterator j = recursos.keySet().iterator();
                            while (j.hasNext()) {
                                String keyR = (String) j.next();
                                actualiza = proyectoDAO.actualizaRecursosTarea(idTarea, Integer.parseInt(keyR), (Double.valueOf(String.valueOf(recursos.get(keyR)))).intValue());
                            }
                        }

                        if (actualiza) {
                            actualizadas++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actualizadas;
    }

    @Override
    public List<Recurso> obtieneRecursos() {
        return tareaProyectoDAO.obtieneRecursos();
    }

}
