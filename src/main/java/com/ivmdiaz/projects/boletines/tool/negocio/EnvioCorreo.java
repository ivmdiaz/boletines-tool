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
            
            final MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            final DataSource source = new FileDataSource(plantilla.getAdjunto());
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName(plantilla.getAdjunto().getName());
            
            final BodyPart messageBodyPart = new MimeBodyPart(); 
            messageBodyPart.setText(plantilla.getContenido());

                        
            final Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);
        }

        Transport.send(message);

        System.out.println("Enviado");

    }

}
