/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class EncriptaPassword {

    public String encriptaPassword(String password) {

        MessageDigest md = null;
        try {
            //SHA-1
            md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] mb = md.digest();
            mb = md.digest();
            String passwordEnc = new String(Hex.encodeHex(mb));

            return passwordEnc;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {

        MessageDigest md = null;
        String password = "admin";
        try {
            //SHA-1
            md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] mb = md.digest();
            mb = md.digest();
            String passwordEnc = new String(Hex.encodeHex(mb));
            System.out.println(Hex.encodeHex(mb));
            System.out.println(passwordEnc);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
