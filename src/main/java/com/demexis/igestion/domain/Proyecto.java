/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pamela.gutierrez
 */
public class Proyecto implements Serializable {

    private int idProyecto;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private TipoProyecto tipo;
    private ClaseProyecto clase;
    private TipoFacturacion tipoFacturacion;
    private ModalidadProyecto modalidad;
    private String estatus;
    private Cliente cliente = new Cliente();
    private ArchivoProyecto archivoProyecto;
    private List<Tarea> tareas = new ArrayList();
    private double avance;
    private int estatusAvance;

    /**
     * @return the idProyecto
     */
    public int getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
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
     * @return the tipo
     */
    public TipoProyecto getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoProyecto tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the clase
     */
    public ClaseProyecto getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(ClaseProyecto clase) {
        this.clase = clase;
    }

    /**
     * @return the tipoFacturacion
     */
    public TipoFacturacion getTipoFacturacion() {
        return tipoFacturacion;
    }

    /**
     * @param tipoFacturacion the tipoFacturacion to set
     */
    public void setTipoFacturacion(TipoFacturacion tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
    }

    /**
     * @return the modalidad
     */
    public ModalidadProyecto getModalidad() {
        return modalidad;
    }

    /**
     * @param modalidad the modalidad to set
     */
    public void setModalidad(ModalidadProyecto modalidad) {
        this.modalidad = modalidad;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the archivoProyecto
     */
    public ArchivoProyecto getArchivoProyecto() {
        return archivoProyecto;
    }

    /**
     * @param archivoProyecto the archivoProyecto to set
     */
    public void setArchivoProyecto(ArchivoProyecto archivoProyecto) {
        this.archivoProyecto = archivoProyecto;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the tareas
     */
    public List<Tarea> getTareas() {
        return tareas;
    }

    /**
     * @param tareas the tareas to set
     */
    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    /**
     * @return the avance
     */
    public double getAvance() {
        return avance;
    }

    /**
     * @param avance the tareas to set
     */
    public void setAvance(double avance) {
        this.avance = avance;
    }

    /**
     * @return the estatusAvance
     */
    public int getEstatusAvance() {
        return estatusAvance;
    }

    /**
     * @param estatusAvance the tareas to set
     */
    public void setEstatusAvance(int estatusAvance) {
        this.estatusAvance = estatusAvance;
    }

}
