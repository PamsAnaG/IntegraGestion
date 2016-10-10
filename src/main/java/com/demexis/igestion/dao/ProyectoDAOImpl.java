/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.controllers.CargaProyectoController;
import com.demexis.igestion.domain.ClaseProyecto;
import com.demexis.igestion.domain.Cliente;
import com.demexis.igestion.domain.ModalidadProyecto;
import com.demexis.igestion.domain.Proyecto;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Tarea;
import com.demexis.igestion.domain.TipoFacturacion;
import com.demexis.igestion.domain.TipoProyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
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
    public boolean actualizaInfoTarea(int idTarea, String descripcion, Date fechaInicio, Date fechaFin, int duracion) {
        String queryActualiza = getQueries().getProperty("actualizaInfoTareaDinamico");
        boolean actualizado = true;

        String coma;
        boolean frst = true;
        int i = 0;
        int length = 1;

        if (descripcion != null) {
            length++;
        }
        if (fechaInicio != null) {
            length++;
        }
        if (fechaFin != null) {
            length++;
        }
        if (duracion != 0) {
            length++;
        }
        Object[] params = new Object[length];

        if (descripcion != null) {
            queryActualiza += " NOMBRE = ?";
            params[i++] = descripcion;
            frst = frst ? false : frst;
        }
        if (fechaInicio != null) {
            coma = frst ? "" : ",";
            frst = frst ? false : frst;
            queryActualiza += coma + " FECHA_INICIO = ?";
            params[i++] = fechaInicio;
        }
        if (fechaFin != null) {
            coma = frst ? "" : ",";
            frst = frst ? false : frst;
            queryActualiza += coma + " FECHA_FIN = ?";
            params[i++] = fechaFin;
        }
        if (duracion != 0) {
            coma = frst ? "" : ",";
            queryActualiza += coma + " DURACION = ?";
            params[i++] = duracion;
        }
        queryActualiza += " WHERE ID_TAREA = ?";
        params[i++] = idTarea;

        logger.info("Parametros actualización: " + params.length);
        try {
            getJdbcTemplate().update(queryActualiza, params);
        } catch (Exception e) {
            logger.error(e.getMessage());
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean actualizaRecursosTarea(int idTarea, int idRecurso, int accion) {
        boolean actualizaRecTarea = true;

        try {
            if (accion == 1) {
                getJdbcTemplate().update(
                        getQueries().getProperty("guardaResponsableTarea"),
                        new Object[]{idTarea, idRecurso, "A"});
            } else {
                getJdbcTemplate().update(
                        getQueries().getProperty("actualizaEstatusRecursoTarea"),
                        new Object[]{"E", idTarea, idRecurso});
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            actualizaRecTarea = false;
        }
        return actualizaRecTarea;
    }

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
                statement.setInt(10, proyectoF.getUsuarioAlta());

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
        String query = getQueries().getProperty("obtieneDatosProyecto");

        List<Proyecto> proyectos = getJdbcTemplate().query(query, MAPPER_PROYECTO, new Object[]{idProyecto});
        Proyecto proyecto = null;

        if (!proyectos.isEmpty()) {
            proyecto = proyectos.get(0);
        }

        return proyecto;
    }

    private static RowMapper<Proyecto> MAPPER_PROYECTO = new RowMapper<Proyecto>() {
        Proyecto obj = new Proyecto();

        public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj.setIdProyecto(rs.getInt("ID_PROYECTO"));
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setFechaInicio(rs.getTimestamp("FECHA_INICIO"));
            obj.setFechaFin(rs.getTimestamp("FECHA_FIN"));
            obj.setEstatus(rs.getString("ESTATUS"));
            obj.setUsuarioAlta(rs.getInt("USUARIO_ALTA"));
            TipoProyecto tipo = new TipoProyecto();
            tipo.setIdTipoProyecto(rs.getInt("ID_TIPO_PROYECTO"));
            tipo.setNombre(rs.getString("TIPO_NOMBRE"));
            tipo.setDescripcion(rs.getString("TIPO_DESCRIPCION"));
            obj.setTipo(tipo);
            TipoFacturacion facturacion = new TipoFacturacion();
            facturacion.setIdTipoFacturacion(rs.getInt("ID_TP_FACTURACION"));
            facturacion.setNombre(rs.getString("NOMBRE_FACTURACION"));
            facturacion.setDescripcion(rs.getString("DESCRIPCION_FACTURACION"));
            obj.setTipoFacturacion(facturacion);
            ClaseProyecto clase = new ClaseProyecto();
            clase.setIdClaseProyecto(rs.getInt("ID_CLASE_PROYECTO"));
            clase.setNombre(rs.getString("NOMBRE_CLASE"));
            clase.setDescripcion(rs.getString("DESCRIPCION_CLASE"));
            obj.setClase(clase);
            ModalidadProyecto modalidad = new ModalidadProyecto();
            modalidad.setIdModalidadProyecto(rs.getInt("ID_MODALIDAD"));
            modalidad.setDescripcion(rs.getString("DESCRIPCION_MODALIDAD"));
            modalidad.setNombre(rs.getString("NOMBRE_MODALIDAD"));
            obj.setModalidad(modalidad);
            Cliente cliente = new Cliente();
            cliente.setNombre(rs.getString("NOMBRE_CLIENTE"));
            cliente.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
            cliente.setNumeroMovil(rs.getString("NUMERO_MOVIL"));
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

        getJdbcTemplate().update(
                getQueries().getProperty("guardaResponsableTarea"),
                new Object[]{tarea.getIdTarea(), recurso.getIdRecurso(), "A"});
    }

}
