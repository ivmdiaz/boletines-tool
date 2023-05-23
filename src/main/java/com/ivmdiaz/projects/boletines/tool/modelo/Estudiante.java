/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivmdiaz.projects.boletines.tool.modelo;

/**
 *
 * @author idiaz@cx.local
 */
public class Estudiante {
   private String niup;
   private String nombre;

   public Estudiante(String niup, String nombre) {
      this.niup = niup;
      this.nombre = nombre;
   }

   public String getNiup() {
      return this.niup;
   }

   public void setNiup(String niup) {
      this.niup = niup;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String toString() {
      return this.niup + " - " + this.nombre;
   }
}