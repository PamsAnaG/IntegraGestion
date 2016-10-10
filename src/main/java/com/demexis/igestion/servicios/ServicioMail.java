/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

/**
 *
 * @author pamela.gutierrez
 */
public interface ServicioMail {

    public void sendMail(String userMail, String subject, String mensaje, String mailUsuariosForCC, String mailUsuariosForTo);
}
