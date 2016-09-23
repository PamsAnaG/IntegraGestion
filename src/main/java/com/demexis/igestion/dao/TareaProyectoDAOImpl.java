/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Rol;
import com.demexis.igestion.domain.Tarea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Gabriel
 */
public class TareaProyectoDAOImpl extends IgestionJdbcDaoSupport implements TareaProyectoDAO {

    private final Logger logger = Logger.getLogger(TareaProyectoDAOImpl.class);

    @Override
    public List<Tarea> obtieneTareasProyectoDashboard(int idProyecto) {
        String query = getQueries().getProperty("obtieneTareasProyectoDashboard");

        List<Tarea> tareasProyecto = getJdbcTemplate().query(query, MAPPER_TAREA_PROYECTO_DSHBRD, new Object[]{idProyecto});

        if (!tareasProyecto.isEmpty()) {
            return tareasProyecto;
        }

        return null;
    }

    private static RowMapper<Tarea> MAPPER_TAREA_PROYECTO_DSHBRD = new RowMapper<Tarea>() {
        Tarea obj;

        public Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Tarea();
            obj.setFechaInicio(rs.getDate("FECHA_INICIO"));
            obj.setFechaFin(rs.getDate("FECHA_FIN"));
            obj.setDuracion(rs.getInt("DURACION"));
            obj.setPorcentajeCompletado(rs.getInt("PORCENTAJE_COMPLETADO"));
            return obj;
        }
    };

    @Override
    public List<Tarea> obtieneTareasHijas(int idTarea) {
        String query = getQueries().getProperty("obtieneTareasHijas");

        List<Tarea> tareasProyecto = getJdbcTemplate().query(query, MAPPER_TAREA_PROYECTO, new Object[]{idTarea});

        if (!tareasProyecto.isEmpty()) {
            return tareasProyecto;
        }

        return null;
    }

    @Override
    public List<Tarea> obtieneTareasProyecto(Proyecto proyecto) {
        String query = getQueries().getProperty("getTareasProyecto");

        List<Tarea> tareas = getJdbcTemplate().query(query, MAPPER_TAREA_PROYECTO, new Object[]{proyecto.getIdProyecto()});

        return tareas;
    }

    private static RowMapper<Tarea> MAPPER_TAREA_PROYECTO = new RowMapper<Tarea>() {
        Tarea obj;

        public Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Tarea();
            obj.setDuracion(rs.getInt("DURACION"));
            obj.setFechaFin(rs.getTimestamp("FECHA_FIN"));
            obj.setFechaInicio(rs.getTimestamp("FECHA_INICIO"));
            obj.setIdTarea(rs.getInt("ID_TAREA"));
            obj.setIdTareaPadre(rs.getInt("ID_TAREA_PADRE"));
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setPorcentajeCompletado(rs.getInt("PORCENTAJE_COMPLETADO"));
            return obj;
        }
    };

    @Override
    public Tarea obtieneTareaPadre(int idProyecto) {
        String query = getQueries().getProperty("getTareasProyecto");

        Tarea tarea = null;

        List<Tarea> tareas = getJdbcTemplate().query(query, MAPPER_TAREA_PROYECTO, new Object[]{idProyecto});

        if (!tareas.isEmpty()) {
            tarea = tareas.get(0);
        }

        return tarea;
    }

    @Override
    public List<Recurso> obtieneResponsableTareas(Tarea tarea) {
        String query = getQueries().getProperty("getResponsablesTarea");

        List<Recurso> recursos = getJdbcTemplate().query(query, MAPPER_RECURSO, new Object[]{tarea.getIdTarea()});

        return recursos;
    }

    private static RowMapper<Recurso> MAPPER_RECURSO = new RowMapper<Recurso>() {
        Recurso obj;

        public Recurso mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Recurso();

            obj.setIdRecurso(rs.getInt("ID_RECURSO"));
            obj.setTipoRecurso(rs.getString("TIPO_RECURSO"));
            obj.setCostoHora(rs.getInt("COSTO_HORA"));
            obj.setIdUsuario(rs.getInt("ID_USUARIO"));
            obj.setUsuario(rs.getString("USUARIO"));
            obj.setApMaterno(rs.getString("APMATERNO"));
            obj.setApPaterno(rs.getString("APPATERNO"));
            obj.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
            obj.setNombre(rs.getString("NOMBRE_RECURSO"));
            obj.setNumeroMovil(rs.getString("NUMERO_MOVIL"));
            Rol rol = new Rol();
            rol.setNombre(rs.getString("NOMBRE_ROL"));
            rol.setDescripcion(rs.getString("DESCRIPCION_ROL"));
            obj.setRol(rol);

            return obj;
        }
    };
}
