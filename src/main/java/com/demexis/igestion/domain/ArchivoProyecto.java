/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.domain;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author pamela.gutierrez
 */
public class ArchivoProyecto {

    CommonsMultipartFile fichero;

    public CommonsMultipartFile getFichero() {
        return fichero;
    }

    public void setFichero(CommonsMultipartFile fichero) {
        this.fichero = fichero;
    }
}
