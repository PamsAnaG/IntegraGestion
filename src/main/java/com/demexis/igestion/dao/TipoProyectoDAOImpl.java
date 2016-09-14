/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.dao;

import com.demexis.igestion.domain.Asociado;
import com.demexis.igestion.domain.TipoProyecto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author pamela.gutierrez
 */
public class TipoProyectoDAOImpl extends IgestionJdbcDaoSupport implements TipoProyectoDAO {
    
    private static RowMapper<TipoProyecto> MAPPER_TIPO_PROYECTO = new RowMapper<TipoProyecto>() {
        TipoProyecto obj;
        
        public TipoProyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
            obj = new TipoProyecto();
            
            obj.setNombre(rs.getString("NOMBRE"));
            obj.setDescripcion(rs.getString("DESCRIPCION"));
            obj.setIdTipoProyecto(rs.getInt("ID_TIPO_PROYECTO"));
            
            return obj;
        }
    };
    
    @Override
    public List<TipoProyecto> getTiposProyecto() {
        String query = getQueries().getProperty("getTipoProyecto");
        
        List<TipoProyecto> tipoProyecto = getJdbcTemplate().query(query, MAPPER_TIPO_PROYECTO, new Object[]{});
        
        if (!tipoProyecto.isEmpty()) {
            return tipoProyecto;
        }
        
        return null;
    }
    
}
