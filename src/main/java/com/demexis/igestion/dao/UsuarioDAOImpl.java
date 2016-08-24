/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.controllers.CargaProyectoController;
import com.demexis.igestion.domain.UsuarioVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pamela.gutierrez
 */
public class UsuarioDAOImpl extends IgestionJdbcDaoSupport implements UsuarioDAO {

    private Logger logger = Logger.getLogger(CargaProyectoController.class);       

    private static RowMapper<UsuarioVO> MAPPER_USUARIO = new RowMapper<UsuarioVO>() {
        UsuarioVO obj;

        public UsuarioVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new UsuarioVO();

            obj.setUsuario(rs.getString("USUARIO"));
            obj.setPassword(rs.getString("PASSWORD"));

            return obj;
        }
    };

    @Override
    public UsuarioVO obtenUsuario(UsuarioVO usuario) {
        String query = getQueries().getProperty("obtenInfoUsuario");

        List<UsuarioVO> usuarios = getJdbcTemplate().query(query, MAPPER_USUARIO, new Object[]{usuario.getUsuario()});

        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        } else {
            return null;
        }
    }

}
