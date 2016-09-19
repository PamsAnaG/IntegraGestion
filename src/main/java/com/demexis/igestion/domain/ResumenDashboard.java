/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.domain;

/**
 *
 * @author Gabriel
 */
public class ResumenDashboard {
    
    private int recursosOcupados;
    private int recursosDisponibles;
    private int colaProyectos;
    private int registrosRadar;
    private int validacionRadar;
    private int tareaFinalizada;
    private int inicioProyecto;
    private int cierreProyecto;

    public int getRecursosOcupados() {
        return recursosOcupados;
    }

    public void setRecursosOcupados(int recursosOcupados) {
        this.recursosOcupados = recursosOcupados;
    }

    public int getRecursosDisponibles() {
        return recursosDisponibles;
    }

    public void setRecursosDisponibles(int recursosDisponibles) {
        this.recursosDisponibles = recursosDisponibles;
    }

    public int getColaProyectos() {
        return colaProyectos;
    }

    public void setColaProyectos(int colaProyectos) {
        this.colaProyectos = colaProyectos;
    }

    public int getRegistrosRadar() {
        return registrosRadar;
    }

    public void setRegistrosRadar(int registrosRadar) {
        this.registrosRadar = registrosRadar;
    }

    public int getValidacionRadar() {
        return validacionRadar;
    }

    public void setValidacionRadar(int validacionRadar) {
        this.validacionRadar = validacionRadar;
    }

    public int getTareaFinalizada() {
        return tareaFinalizada;
    }

    public void setTareaFinalizada(int tareaFinalizada) {
        this.tareaFinalizada = tareaFinalizada;
    }

    public int getInicioProyecto() {
        return inicioProyecto;
    }

    public void setInicioProyecto(int inicioProyecto) {
        this.inicioProyecto = inicioProyecto;
    }

    public int getCierreProyecto() {
        return cierreProyecto;
    }

    public void setCierreProyecto(int cierreProyecto) {
        this.cierreProyecto = cierreProyecto;
    }
    
}
