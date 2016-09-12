/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.controllers.CargaProyectoController;
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
    public Tarea guardaTarea(Tarea tarea) throws Exception {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        final Tarea tareaF = tarea;

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
                //statement.setInt(7, tareaF.get);
                return statement;
            }
        }, keyHolder);

        tarea.setIdTarea(keyHolder.getKey().intValue());

        return tarea;

    }

}
