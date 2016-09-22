/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pamela.gutierrez
 */
public class Tarea implements Cloneable {

    private int idTarea;
    private int idTareaPadre;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private double duracion;
    private int porcentajeCompletado;
    private int idUnicoTarea;
    private List<Recurso> responsables = new ArrayList();
    private List<Tarea> tareasHijas = new ArrayList();
    private int tareaGrupo;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new CloneNotSupportedException();
        }
        return obj;
    }

    /**
     * @return the idTarea
     */
    public int getIdTarea() {
        return idTarea;
    }

    /**
     * @param idTarea the idTarea to set
     */
    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    /**
     * @return the idTareaPadre
     */
    public int getIdTareaPadre() {
        return idTareaPadre;
    }

    /**
     * @param idTareaPadre the idTareaPadre to set
     */
    public void setIdTareaPadre(int idTareaPadre) {
        this.idTareaPadre = idTareaPadre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the duracion
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the porcentajeCompletado
     */
    public int getPorcentajeCompletado() {
        return porcentajeCompletado;
    }

    /**
     * @param porcentajeCompletado the porcentajeCompletado to set
     */
    public void setPorcentajeCompletado(int porcentajeCompletado) {
        this.porcentajeCompletado = porcentajeCompletado;
    }

    /**
     * @return the idUnicoTarea
     */
    public int getIdUnicoTarea() {
        return idUnicoTarea;
    }

    /**
     * @param idUnicoTarea the idUnicoTarea to set
     */
    public void setIdUnicoTarea(int idUnicoTarea) {
        this.idUnicoTarea = idUnicoTarea;
    }

    /**
     * @return the responsables
     */
    public List<Recurso> getResponsables() {
        return responsables;
    }

    /**
     * @param responsables the responsables to set
     */
    public void setResponsables(List<Recurso> responsables) {
        this.responsables = responsables;
    }
    /**
     * @return the tareasHijas
     */
    public List<Tarea> getTareasHijas() {
        return tareasHijas;
    }

    /**
     * @param tareasHijas the tareasHijas to set
     */
    public void setTareasHijas(List<Tarea> tareasHijas) {
        this.tareasHijas = tareasHijas;
    }

    /**
     * @return the tareaGrupo
     */
    public int getTareaGrupo() {
        return tareaGrupo;
    }

    /**
     * @param tareaGrupo the tareaGrupo to set
     */
    public void setTareaGrupo(int tareaGrupo) {
        this.tareaGrupo = tareaGrupo;
    }

}
