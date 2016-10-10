/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.servicios;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 *
 * @author pamela.gutierrez
 */
@Service
public class ServicioMailImpl implements ServicioMail {

    private Logger logger = Logger.getLogger(ServicioMailImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMail(final String userMail, String subject, final String mensaje, String mailUsuariosForCC, final String mailUsuariosForTo) {

        try {

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(mailUsuariosForTo);
            if (!mailUsuariosForCC.equals("")) {
                helper.setCc(mailUsuariosForCC);
            }

            helper.setText(mensaje, true);
            helper.setSubject(subject);

            /*FileSystemResource res = new FileSystemResource(new File("c:/Sample.jpg"));
             helper.addInline("identifier1234", res);*/
            mailSender.send(message);
        } catch (Exception excp) {
            excp.printStackTrace();
        }

        logger.info(" envio de mail exitoso !!");
    }

}
