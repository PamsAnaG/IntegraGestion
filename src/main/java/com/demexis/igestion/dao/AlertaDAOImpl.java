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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
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

    private static RowMapper<Alerta> MAPPER_ALERTA_PROYECTO = new RowMapper<Alerta>() {
        Alerta obj;

        public Alerta mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Alerta();
            obj.setIdAlerta(rs.getInt("ID_ALERTA"));
            obj.setIdFaseTareaAlerta(rs.getInt("ID_FASE_TAREA_ALERTA"));
            obj.setIdTipoAlerta(rs.getInt("ID_TIPO_ALERTA"));
            obj.setProcentajeAvance(rs.getInt("PORCENTAJE_AVANCE"));
            obj.setNombreTipoAlerta(rs.getString("NOMBRE_TIPO"));

            return obj;
        }
    };

    private static RowMapper<Tarea> MAPPER_TAREA_PROYECTO = new RowMapper<Tarea>() {
        Tarea obj;

        public Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Tarea();
            obj.setDuracion(rs.getInt("DURACION"));
            obj.setFechaFin(rs.getTimestamp("FECHA_FIN"));
            obj.setFechaInicio(rs.getTimestamp("FECHA_INICIO"));
            obj.setIdTarea(rs.getInt("ID_TAREA"));
            obj.setIdTareaPadre(rs.getInt("ID_TAREA_PADRE"));
            obj.setNombre(rs.getString("NOMBRE_TAREA"));
            obj.setPorcentajeCompletado(rs.getInt("PORCENTAJE_COMPLETADO"));
            obj.setIdProyecto(rs.getInt("ID_PROYECTO"));
            Alerta alerta = new Alerta();
            alerta.setIdAlerta(rs.getInt("ID_ALERTA"));
            alerta.setIdFaseTareaAlerta(rs.getInt("ID_FASE_TAREA_ALERTA"));
            alerta.setIdTipoAlerta(rs.getInt("ID_TIPO_ALERTA"));
            alerta.setNombreFaseTareaAlerta(rs.getString("NOMBRE_FASE"));
            alerta.setNombreTipoAlerta(rs.getString("NOMBRE_TIPO"));
            alerta.setEstatus(rs.getString("ESTATUS_ALERTA"));
            obj.getAlertas().add(alerta);
            return obj;
        }
    };

    @Override
    public List<Alerta> obtieneAlertasProyecto(int idTarea) {
        String query = getQueries().getProperty("obtieneAlertasProyecto");

        List<Alerta> tareas = getJdbcTemplate().query(query, MAPPER_ALERTA_PROYECTO, new Object[]{idTarea});

        if (!tareas.isEmpty()) {
            return tareas;
        } else {
            tareas = new ArrayList();
        }

        return tareas;
    }

    @Override
    public List<Tarea> obtieneAlertasActivas() {
        String query = getQueries().getProperty("obtieneAlertasActivas");

        List<Tarea> tareas = getJdbcTemplate().query(query, MAPPER_TAREA_PROYECTO, new Object[]{});

        if (!tareas.isEmpty()) {
            return tareas;
        } else {
            tareas = new ArrayList();
        }

        return tareas;
    }

    @Override
    public void actualizaEstadoAlerta(String estado, int idAlerta) {
        String query = getQueries().getProperty("actualizaEstadoAlerta");
        int registros = getJdbcTemplate().update(query, new Object[]{estado, idAlerta});
    }

}
