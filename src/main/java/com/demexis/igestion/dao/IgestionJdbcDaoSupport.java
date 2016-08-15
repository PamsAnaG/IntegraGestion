package com.demexis.igestion.dao;


import java.util.Properties;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pamela.gutierrez
 */
public class IgestionJdbcDaoSupport extends JdbcDaoSupport {

    /**
     * Statements de la base de datos.
     */
    private Properties queries;

    /**
     * @return the queries
     */
    public Properties getQueries() {
        return queries;
    }

    /**
     * @param queries the queries to set
     */
    public void setQueries(Properties queries) {
        this.queries = queries;
    }

}
