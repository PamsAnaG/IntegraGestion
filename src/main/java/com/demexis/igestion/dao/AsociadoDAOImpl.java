/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Asociado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pamela.gutierrez
 */
public class AsociadoDAOImpl extends IgestionJdbcDaoSupport implements AsociadoDAO {

    private static RowMapper<Asociado> MAPPER_ASOCIADO = new RowMapper<Asociado>() {
        Asociado obj;

        public Asociado mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Asociado();

            obj.setIdAsociado(rs.getInt("ID_ASOCIADO"));
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setNumeroMovil(rs.getString("NUMERO_MOVIL"));
            obj.setCorreElectronico(rs.getString("CORREO_ELECTRONICO"));

            return obj;
        }
    };

    @Override
    public List<Asociado> getAsociados() {
        String query = getQueries().getProperty("getAsociados");

        List<Asociado> asociados = getJdbcTemplate().query(query, MAPPER_ASOCIADO, new Object[]{});

        if (!asociados.isEmpty()) {
            return asociados;
        }

        return null;
    }

}
