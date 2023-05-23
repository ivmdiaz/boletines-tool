/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivmdiaz.projects.boletines.tool.negocio;

import com.ivmdiaz.projects.boletines.tool.modelo.ConfiguracionCorreo;
import com.ivmdiaz.projects.boletines.tool.modelo.PlantillaCorreo;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author idiaz@cx.local
 */
public class EnvioCorreo {

    //https://myaccount.google.com/lesssecureapps
    public static void main(String[] args) {
    }

    public void sendEmail(final String username, final String password) throws MessagingException {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("mauriciodiaz1006@gmail.com, idiaz@conexia.com")
        );
        message.setSubject("Testing Gmail TLS");
        message.setText("Dear Mail Crawler,"
                + "\n\n Please do not spam my email!");

        Transport.send(message);

        System.out.println("Done");

    }

    public void sendEmail(final ConfiguracionCorreo configuracion, final PlantillaCorreo plantilla) throws MessagingException {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", configuracion.getHost());
        prop.put("mail.smtp.port", configuracion.getPuerto());
        prop.put("mail.smtp.auth", configuracion.getAuth());
        prop.put("mail.smtp.starttls.enable", configuracion.getTls());

        final Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        configuracion.getUsuario(),
                        configuracion.getClave()
                );
            }
        });

        final Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(configuracion.getUsuario()));

        if (CollectionUtils.isNotEmpty(plantilla.getPara())) {
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(String.join(",", plantilla.getPara()))
            );
        }

        if (CollectionUtils.isNotEmpty(plantilla.getCopia())) {
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(String.join(",", plantilla.getCopia()))
            );
        }

        if (CollectionUtils.isNotEmpty(plantilla.getCopiaOculta())) {
            message.setRecipients(Message.RecipientType.BCC,
                    InternetAddress.parse(String.join(",", plantilla.getCopiaOculta()))
            );
        }

        message.setSubject(plantilla.getAsunto());
        message.setText(plantilla.getContenido());


        if (plantilla.getAdjunto() != null && plantilla.getAdjunto().exists()) {
            final MimeBodyPart messageBodyPart = new MimeBodyPart();
            final Multipart multipart = new MimeMultipart();
            final DataSource source = new FileDataSource(plantilla.getAdjunto());
            
            messageBodyPart.setText(plantilla.getContenido());
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(plantilla.getAdjunto().getName());
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
        }

        Transport.send(message);

        System.out.println("Enviado");

    }

}
