/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.cron;

import com.demexis.igestion.dao.TareaProyectoDAO;
import com.demexis.igestion.domain.ConstantesIntegra;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Tarea;
import com.demexis.igestion.domain.Usuario;
import com.demexis.igestion.servicios.AlertaService;
import com.demexis.igestion.servicios.ProyectoService;
import com.demexis.igestion.servicios.ServicioMail;
import com.demexis.igestion.servicios.UsuarioService;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author pamela.gutierrez
 */
public class EnviaAlertasCron {

    private Logger logger = Logger.getLogger(EnviaAlertasCron.class);

    @Autowired
    AlertaService alertaService;

    @Autowired
    ServicioMail servicioMail;

    @Autowired
    TareaProyectoDAO tareaDao;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ProyectoService proyectoService;

    @Value("${alerta.correo.contenido}")
    private String alertaCorreoContenido;

    @Value("${mail.user}")
    private String usuarioEnvioMail;

    @Value("${alerta.correo.subject}")
    private String alertaCorreoSubject;

    public void ejecutaTarea() {

        try {

            logger.debug("Enviando alertas...");

            List<Tarea> tareasAlertas = alertaService.obtieneAlertasActivas();

            for (Tarea tarea : tareasAlertas) {
                List<Recurso> recursos = tareaDao.obtieneResponsableTareas(tarea);                
                tarea.setResponsables(recursos);                
                // SI LA ALERTA ESTA ACTIVA
                if (tarea.getAlertas().get(0).getEstatus().equals("A")) {                    
                    // VERIFICAMOS SI DEBE ENVIARSE LA NOTIFICACION
                    boolean enviaNotificacion = false;
                    if (tarea.getAlertas().get(0).getIdFaseTareaAlerta() == 1) { // INICIO TAREA
                        if (tarea.getFechaInicio().before(new Date())) {
                            enviaNotificacion = true;
                        }
                    } else if (tarea.getAlertas().get(0).getIdFaseTareaAlerta() == 2) { // FIN TAREA
                        if (tarea.getFechaFin().after(new Date())) {
                            enviaNotificacion = true;
                        }
                    } else if (tarea.getAlertas().get(0).getIdFaseTareaAlerta() == 3) { // ATRASO
                        if (tarea.getFechaFin().after(new Date()) && tarea.getPorcentajeCompletado() != 100) {
                            enviaNotificacion = true;
                        }
                    } else if (tarea.getAlertas().get(0).getIdFaseTareaAlerta() == 4) { // PORCENTAJE AVANCE
                        if (tarea.getPorcentajeCompletado() == tarea.getAlertas().get(0).getProcentajeAvance()) {
                            enviaNotificacion = true;
                        }
                    } else if (tarea.getAlertas().get(0).getIdFaseTareaAlerta() == 5) { // LIBERACION DE RECURSO
                        if (tarea.getPorcentajeCompletado() == 100) {
                            enviaNotificacion = true;
                        }
                    } else if (tarea.getAlertas().get(0).getIdFaseTareaAlerta() == 6) { // INICIO DE TAREA ANTICIPADO
                        if (!tarea.getFechaInicio().before(new Date()) && tarea.getPorcentajeCompletado() != 0) {
                            enviaNotificacion = true;
                        }
                    } else if (tarea.getAlertas().get(0).getIdFaseTareaAlerta() == 7) { // FIN DE TAREA ANTICIPADO
                        if (!tarea.getFechaFin().after(new Date()) && tarea.getPorcentajeCompletado() == 100) {
                            enviaNotificacion = true;
                        }
                    }
                    if (enviaNotificacion) {
                        // SI ES UNA NOTIFICACION POR MEDIO DE CORREO ELECTRONICO
                        if (tarea.getAlertas().get(0).getNombreTipoAlerta().endsWith(ConstantesIntegra.C.toString())) {

                            logger.debug("Enviando correo...");
                            Proyecto proyecto = proyectoService.obtieneProyectoBD(tarea.getIdProyecto());
                            Usuario usuarioAdm = usuarioService.informacionUsuario(proyecto.getUsuarioAlta());
                            String destinatarios = "";
                            String responsables = "";
                            for (Recurso recurso : tarea.getResponsables()) {
                                destinatarios += recurso.getCorreoElectronico() + ",";
                                responsables += recurso.getNombre() + " " + recurso.getApPaterno() + " " + recurso.getApMaterno() + ",";
                            }
                            responsables = responsables.substring(0, responsables.lastIndexOf(","));
                            String contenidoCorreo = alertaCorreoContenido;
                            contenidoCorreo = contenidoCorreo.replace("NOMBRE_PROYECTO", proyecto.getNombre());
                            contenidoCorreo = contenidoCorreo.replace("NOMBRE_CLIENTE", proyecto.getCliente().getNombre());
                            contenidoCorreo = contenidoCorreo.replace("NOMBRE_TAREA", tarea.getNombre());
                            contenidoCorreo = contenidoCorreo.replace("NOMBRE_FASE", tarea.getAlertas().get(0).getNombreFaseTareaAlerta());
                            contenidoCorreo = contenidoCorreo.replace("NOMBRES_RESPONSABLES", responsables);

                            servicioMail.sendMail(usuarioEnvioMail, alertaCorreoSubject, contenidoCorreo, destinatarios, usuarioAdm.getCorreoElectronico());

                            alertaService.actualizaEstadoAlerta(ConstantesIntegra.PR.toString(), tarea.getAlertas().get(0).getIdAlerta());
                        }
                    }
                }
            }
        } catch (Exception excp) {
            excp.printStackTrace();
            logger.error("No fue posible notificar alertas " + excp.getMessage());
        }

    }

}
