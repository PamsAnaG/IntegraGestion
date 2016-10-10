/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Privilegio;
import com.demexis.igestion.domain.Recurso;
import com.demexis.igestion.domain.Rol;
import com.demexis.igestion.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pamela.gutierrez
 */
public class UsuarioDAOImpl extends IgestionJdbcDaoSupport implements UsuarioDAO {

    private Logger logger = Logger.getLogger(UsuarioDAOImpl.class);

    private static RowMapper<Usuario> MAPPER_USUARIO = new RowMapper<Usuario>() {
        Usuario obj;

        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Usuario();

            obj.setIdUsuario(rs.getInt("ID_USUARIO"));
            obj.setUsuario(rs.getString("USUARIO"));
            obj.setPassword(rs.getString("PASSWORD"));
            obj.setApMaterno(rs.getString("APMATERNO"));
            obj.setApPaterno(rs.getString("APPATERNO"));
            obj.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setNumeroMovil(rs.getString("NUMERO_MOVIL"));
            Rol rol = new Rol();
            rol.setNombre(rs.getString("NOMBRE_ROL"));
            rol.setDescripcion(rs.getString("DESCRIPCION"));
            obj.setRol(rol);

            return obj;
        }
    };

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
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setNumeroMovil(rs.getString("NUMERO_MOVIL"));
            Rol rol = new Rol();
            rol.setNombre(rs.getString("NOMBRE_ROL"));
            rol.setDescripcion(rs.getString("DESCRIPCION"));
            obj.setRol(rol);

            return obj;
        }
    };

    private static RowMapper<Privilegio> MAPPER_PRIV_USUARIO = new RowMapper<Privilegio>() {
        Privilegio obj;

        public Privilegio mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new Privilegio();

            obj.setNombre(rs.getString("NOMBRE"));
            obj.setDescripcion(rs.getString("DESCRIPCION"));

            return obj;
        }
    };

    @Override
    public Usuario getPrivilegiosUsuario(Usuario usuario) {
        String query = getQueries().getProperty("obtenPrivUsuario");

        List<Privilegio> privilegios = getJdbcTemplate().query(query, MAPPER_PRIV_USUARIO, new Object[]{usuario.getIdUsuario()});

        if (!privilegios.isEmpty()) {
            usuario.setPrivilegio(privilegios);
        }

        return usuario;
    }

    @Override
    public Usuario obtenUsuario(Usuario usuario) {
        String query = getQueries().getProperty("obtenInfoUsuario");

        List<Usuario> usuarios = getJdbcTemplate().query(query, MAPPER_USUARIO, new Object[]{usuario.getUsuario()});

        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Recurso> getUsuariosRecursos() {
        String query = getQueries().getProperty("getUsuariosRecursos");

        List<Recurso> usuariosRecursos = getJdbcTemplate().query(query, MAPPER_RECURSO, new Object[]{Rol.RECURSO});

        if (!usuariosRecursos.isEmpty()) {
            return usuariosRecursos;
        }

        return null;
    }

    @Override
    public Usuario obtenUsuario(int idUsuario) {

        String query = getQueries().getProperty("obtenInfoUsuarioID");

        List<Usuario> usuarios = getJdbcTemplate().query(query, MAPPER_USUARIO, new Object[]{idUsuario});

        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        } else {
            return null;
        }
    }

}
