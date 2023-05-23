/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivmdiaz.projects.boletines.tool.modelo;

import java.io.File;

/**
 *
 * @author idiaz@cx.local
 */
public class Boletin {

    private File archivo;
    private String niup;
    private String nombre;
    private Directorio directorio;

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getNiup() {
        return niup;
    }

    public void setNiup(String niup) {
        this.niup = niup;
    }

    public Directorio getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Directorio directorio) {
        this.directorio = directorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
