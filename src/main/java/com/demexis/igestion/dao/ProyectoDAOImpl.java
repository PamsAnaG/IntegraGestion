/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.controllers.CargaProyectoController;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author pamela.gutierrez
 */
public class ProyectoDAOImpl extends IgestionJdbcDaoSupport implements ProyectoDAO {

    private Logger logger = Logger.getLogger(CargaProyectoController.class);

    @Override
    public Tarea guardaTarea(Tarea tarea, int idProyecto){

        KeyHolder keyHolder = new GeneratedKeyHolder();

        final Tarea tareaF = tarea;
        final int idP = idProyecto;

        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(getQueries().getProperty("guardaTareaProyecto"), Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, tareaF.getIdTareaPadre());
                statement.setString(2, tareaF.getNombre());
                statement.setTimestamp(3, new Timestamp(tareaF.getFechaInicio().getTime()));
                statement.setTimestamp(4, new Timestamp(tareaF.getFechaFin().getTime()));
                statement.setDouble(5, tareaF.getDuracion());
                statement.setInt(6, tareaF.getProcentajeCompletado());
                statement.setInt(7, idP);
                return statement;
            }
        }, keyHolder);

        tarea.setIdTarea(keyHolder.getKey().intValue());

        return tarea;

    }

    @Override
    public Proyecto guardaProyecto(Proyecto proyecto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        final Proyecto proyectoF = proyecto;

        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(getQueries().getProperty("guardaProyecto"), Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, proyectoF.getNombre());
                statement.setTimestamp(2, new Timestamp(proyectoF.getFechaInicio().getTime()));
                statement.setTimestamp(3, new Timestamp(proyectoF.getFechaInicio().getTime()));
                statement.setInt(4, proyectoF.getCliente().getIdCliente());
                statement.setInt(5, proyectoF.getTipo().getIdTipoProyecto());
                statement.setInt(6, proyectoF.getClase().getIdClaseProyecto());
                statement.setInt(7, proyectoF.getTipoFacturacion().getIdTipoFacturacion());
                statement.setInt(8, proyectoF.getModalidad().getIdModalidadProyecto());
                statement.setString(9, "A");

                return statement;
            }
        }, keyHolder);

        proyectoF.setIdProyecto(keyHolder.getKey().intValue());

        return proyectoF;
    }

}
