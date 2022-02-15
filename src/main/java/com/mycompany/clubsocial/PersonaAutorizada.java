/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clubsocial;

/**
 *
 * @author TdeA
 */
public class PersonaAutorizada {
    private String nombre;
    private Socio socio;
    private Factura[] facturas;
    private int cedula;

 

    public PersonaAutorizada(String nombre, Socio socio, int cedula) {
        this.nombre = nombre;
        this.socio = socio;
        this.facturas = new Factura[20];
        this.cedula=cedula;
    }
       public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Factura[] getFacturas() {
        return facturas;
    }

    public void setFacturas(Factura[] facturas) {
        this.facturas = facturas;
    }
    
    
    
    
}
