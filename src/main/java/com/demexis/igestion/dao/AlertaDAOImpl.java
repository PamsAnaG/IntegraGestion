/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Alerta;
import com.demexis.igestion.domain.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author pamela.gutierrez
 */
public class AlertaDAOImpl extends IgestionJdbcDaoSupport implements AlertaDAO {

    @Override
    public Alerta guardaAlertaproyecto(Alerta alerta, int idTarea) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        final Alerta alertaF = alerta;
        final Integer idTrareaF = idTarea;

        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(getQueries().getProperty("guardaAlertaProyecto"), Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, idTrareaF);
                statement.setInt(2, alertaF.getIdTipoAlerta());
                statement.setInt(3, alertaF.getIdFaseTareaAlerta());
                statement.setInt(4, alertaF.getProcentajeAvance());
                return statement;
            }
        }, keyHolder);

        alerta.setIdAlerta(keyHolder.getKey().intValue());

        return alerta;
    }

}
