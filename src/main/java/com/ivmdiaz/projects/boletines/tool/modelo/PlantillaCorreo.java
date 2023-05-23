/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivmdiaz.projects.boletines.tool.modelo;

import java.io.File;
import java.util.List;

/**
 *
 * @author idiaz@cx.local
 */
public class PlantillaCorreo {
    
    private String asunto;
    private List<String> para;
    private List<String> copia;
    private List<String> copiaOculta;
    private String contenido;
    private File adjunto;

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public List<String> getPara() {
        return para;
    }

    public void setPara(List<String> para) {
        this.para = para;
    }

    public List<String> getCopia() {
        return copia;
    }

    public void setCopia(List<String> copia) {
        this.copia = copia;
    }

    public List<String> getCopiaOculta() {
        return copiaOculta;
    }

    public void setCopiaOculta(List<String> copiaOculta) {
        this.copiaOculta = copiaOculta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public File getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(File adjunto) {
        this.adjunto = adjunto;
    }
    
    
}
