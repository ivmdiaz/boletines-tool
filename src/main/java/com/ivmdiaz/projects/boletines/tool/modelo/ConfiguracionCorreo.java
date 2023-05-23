/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivmdiaz.projects.boletines.tool.modelo;

/**
 *
 * @author idiaz@cx.local
 */
public class ConfiguracionCorreo {
    
    private String usuario;
    private String clave;
    private String host;
    private String puerto;
    private String auth;
    private String tls;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getTls() {
        return tls;
    }

    public void setTls(String tls) {
        this.tls = tls;
    }

    @Override
    public String toString() {
        return "ConfiguracionCorreo{" + "usuario=" + usuario + ", clave=" + clave + ", host=" + host + ", puerto=" + puerto + ", auth=" + auth + ", tls=" + tls + '}';
    }
    
    
    
}
