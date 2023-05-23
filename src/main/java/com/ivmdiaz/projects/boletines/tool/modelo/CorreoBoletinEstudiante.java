/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivmdiaz.projects.boletines.tool.modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author idiaz@cx.local
 */
public class CorreoBoletinEstudiante extends PlantillaCorreo {

    private final Boletin boletin;

    public CorreoBoletinEstudiante(final Boletin boletin) throws IOException {
        this.boletin = boletin;

        this.setAsunto(String.format("BOLETIN %s - %s",
                boletin.getNombre(),
                boletin.getNiup())
        );
        
        this.setContenido("Adjunto se encuentra el boletín de este periodo. Si este correo electrónico no corresponde puede eliminarlo de forma segura.");
        

        final List<String> para = new ArrayList<>();
        para.add(boletin.getDirectorio().getCorreoPersonal());
        para.add(boletin.getDirectorio().getCorreoAlternativo());
        this.setPara(para);
        this.setAdjunto(boletin.getArchivo());
    }

    @SuppressWarnings("empty-statement")
    private String construirContenidoCorreoBoletinEstudiante() throws FileNotFoundException, IOException {

        StringBuilder bldr = new StringBuilder();
        String str;

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/template-boletin.html")))) {
            while ((str = buffer.readLine()) != null) {
                bldr.append(str);
            }
        };

        final String titulo = String.format("BOLETIN %s - %s",
                boletin.getNombre(),
                boletin.getNiup()
        );

        return bldr.toString()
                .replaceAll("$cuerpo_titulo", titulo)
                .replaceAll("$contenido_usuario", "Profe Mardo.");

    }

}
