/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pamela.gutierrez
 */
public class ClienteDAOImpl extends IgestionJdbcDaoSupport implements ClienteDAO {

    private static RowMapper<Cliente> MAPPER_CLIENTE = new RowMapper<Cliente>() {
        Cliente obj;

        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Cliente();

            obj.setIdCliente(rs.getInt("ID_CLIENTE"));
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setNumeroMovil(rs.getString("NUMERO_MOVIL"));
            obj.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));

            return obj;
        }
    };

    @Override
    public List<Cliente> getClientes() {
        String query = getQueries().getProperty("getClientes");

        List<Cliente> clientes = getJdbcTemplate().query(query, MAPPER_CLIENTE, new Object[]{});

        if (!clientes.isEmpty()) {
            return clientes;
        }

        return null;
    }

}
