/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.controllers.CargaProyectoController;
import com.demexis.igestion.domain.Cliente;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Tarea;
import com.demexis.igestion.domain.TipoProyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author pamela.gutierrez
 */
public class ProyectoDAOImpl extends IgestionJdbcDaoSupport implements ProyectoDAO {

    private Logger logger = Logger.getLogger(CargaProyectoController.class);

    @Override
    public Tarea guardaTarea(Tarea tarea, int idProyecto) {

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
                statement.setInt(6, tareaF.getPorcentajeCompletado());
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

        proyecto.setIdProyecto(keyHolder.getKey().intValue());

        return proyectoF;
    }

    @Override
    public void guardaArchivoProyecto(Proyecto proyecto) {

        getJdbcTemplate().update(
                getQueries().getProperty("guardaArchivoProyecto"),
                new Object[]{proyecto.getIdProyecto(), proyecto.getArchivoProyecto().getFichero().getBytes()});

    }

    @Override
    public Proyecto obtieneProyecto(int idProyecto) {
        String query = getQueries().getProperty("obtieneProyectosDashboard");

        Proyecto proyecto = (Proyecto) getJdbcTemplate().query(query, MAPPER_PROYECTO, new Object[]{idProyecto});

        if (proyecto != null) {
            return proyecto;
        }

        return null;
    }

    private static RowMapper<Proyecto> MAPPER_PROYECTO = new RowMapper<Proyecto>() {
        Proyecto obj = new Proyecto();

        public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente();
            obj.setIdProyecto(rs.getInt("ID_PROYECTO"));
            obj.setNombre(rs.getString("NOMBRE"));
            cliente.setNombre(rs.getString("CLIENTE"));
            obj.setCliente(cliente);
            return obj;
        }
    };

    @Override
    public List<Proyecto> obtieneProyectosDashboard() {
        String query = getQueries().getProperty("obtieneProyectosDashboard");

        List<Proyecto> proyectos = getJdbcTemplate().query(query, MAPPER_PROYECTO_DSHBRD, new Object[]{});

        if (!proyectos.isEmpty()) {
            return proyectos;
        }

        return null;
    }

    private static RowMapper<Proyecto> MAPPER_PROYECTO_DSHBRD = new RowMapper<Proyecto>() {
        Proyecto obj;

        public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Proyecto();
            Cliente cliente = new Cliente();
            obj.setIdProyecto(rs.getInt("ID_PROYECTO"));
            obj.setNombre(rs.getString("NOMBRE"));
            cliente.setNombre(rs.getString("CLIENTE"));
            obj.setCliente(cliente);
            return obj;
        }
    };

    @Override
    public void guardaResponsableTarera(Tarea tarea, Recurso recurso) {
        
        logger.debug("Guardando responsable " + tarea.getIdTarea() + "|" +  recurso.getIdRecurso());
        getJdbcTemplate().update(
                getQueries().getProperty("guardaResponsableTarea"),
                new Object[]{tarea.getIdTarea(), recurso.getIdRecurso(), "A"});
    }

}
