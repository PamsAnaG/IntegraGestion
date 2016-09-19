/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.ClaseProyecto;
import com.demexis.igestion.domain.ModalidadProyecto;
import com.demexis.igestion.domain.TipoFacturacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pamela.gutierrez
 */
public class ClaseProyectoDAOImpl extends IgestionJdbcDaoSupport implements ClaseProyectoDAO {

    private static RowMapper<ClaseProyecto> MAPPER_CLASE_PROYECTO = new RowMapper<ClaseProyecto>() {
        ClaseProyecto obj;

        public ClaseProyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new ClaseProyecto();

            obj.setDescripcion(rs.getString("DESCRIPCION"));
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setIdClaseProyecto(rs.getInt("ID_CLASE_PROYECTO"));

            return obj;
        }
    };

    private static RowMapper<TipoFacturacion> MAPPER_TIPO_FACTURACION = new RowMapper<TipoFacturacion>() {
        TipoFacturacion obj;

        public TipoFacturacion mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new TipoFacturacion();

            obj.setNombre(rs.getString("NOMBRE"));
            obj.setIdTipoFacturacion(rs.getInt("ID_TP_FACTURACION"));
            obj.setDescripcion(rs.getString("DESCRIPCION"));

            return obj;
        }
    };

    private static RowMapper<ModalidadProyecto> MAPPER_MODALIDAD = new RowMapper<ModalidadProyecto>() {
        ModalidadProyecto obj;

        public ModalidadProyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new ModalidadProyecto();

            obj.setDescripcion(rs.getString("DESCRIPCION"));
            obj.setIdModalidadProyecto(rs.getInt("ID_MODALIDAD"));
            obj.setNombre(rs.getString("NOMBRE"));

            return obj;
        }
    };

    @Override
    public List<ClaseProyecto> getClaseProyectos() {
        String query = getQueries().getProperty("getClaseProyecto");

        List<ClaseProyecto> clases = getJdbcTemplate().query(query, MAPPER_CLASE_PROYECTO, new Object[]{});

        if (!clases.isEmpty()) {
            return clases;
        }

        return null;
    }

    @Override
    public List<TipoFacturacion> getTipoFacturacion() {
        String query = getQueries().getProperty("getTipoFacturacion");

        List<TipoFacturacion> tiposFacturacion = getJdbcTemplate().query(query, MAPPER_TIPO_FACTURACION, new Object[]{});

        if (!tiposFacturacion.isEmpty()) {
            return tiposFacturacion;
        }

        return null;
    }

    @Override
    public List<ModalidadProyecto> getModalidadProyectos() {
        String query = getQueries().getProperty("getModalidad");

        List<ModalidadProyecto> modalidad = getJdbcTemplate().query(query, MAPPER_MODALIDAD, new Object[]{});

        if (!modalidad.isEmpty()) {
            return modalidad;
        }

        return null;
    }

}
