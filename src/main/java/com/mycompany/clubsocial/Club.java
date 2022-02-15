/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clubsocial;

import javax.swing.JOptionPane;

/**
 *
 * @author TdeA
 */
public class Club {

    private String nombre;
    private Socio[] sociosVip;
    private Socio[] sociosRegulares;

    public Club(String nombre) {
        this.nombre = nombre;
        this.sociosVip = new Socio[3];
        this.sociosRegulares = new Socio[10];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Socio[] getSociosVip() {
        return sociosVip;
    }

    public void setSociosVip(Socio[] sociosVip) {
        this.sociosVip = sociosVip;
    }

    public Socio[] getSociosRegulares() {
        return sociosRegulares;
    }

    public void setSociosRegulares(Socio[] sociosRegulares) {
        this.sociosRegulares = sociosRegulares;
    }

    public Socio buscarCedula(int cedula) {

        Socio encontrado = null;
        for (int i = 0; i < sociosVip.length; i++) {
            if (sociosVip[i] != null && sociosVip[i].getCedula() == cedula) {
                encontrado = sociosVip[i];
            }
        }
        if (encontrado == null) {
            for (int i = 0; i < sociosRegulares.length; i++) {
                if (sociosRegulares[i] != null && sociosRegulares[i].getCedula() == cedula) {
                    encontrado = sociosRegulares[i];
                }
            }
        }

        return encontrado;
    }

    public boolean sociosVipNulo() {
        for (int i = 0; i < sociosVip.length; i++) {
            if (sociosVip[i] == null) {
                return true;
            }
        }
        return false;
    }

    public boolean sociosRegularNulo() {
        for (int i = 0; i < sociosRegulares.length; i++) {
            if (sociosRegulares[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void inscribirSocio() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese su cedula"));
        if (buscarCedula(cedula) == null) {
            boolean registro = false;
            int tipo = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese: \n 1. para Vip \n 2. para regular"));
            if (tipo == 1 && sociosVipNulo()) {
                String nombre = JOptionPane.showInputDialog(null, "ingrese su nombre");
                Socio socio = new Socio(cedula, "Vip", 100000, nombre);
                for (int i = 0; i < sociosVip.length; i++) {
                    if (sociosVip[i] == null && !registro) {
                        sociosVip[i] = socio;
                        registro = true;
                    }
                }
            }
            if (tipo == 2 && sociosRegularNulo() && !registro) {
                String nombre = JOptionPane.showInputDialog(null, "ingrese su nombre");
                Socio socio = new Socio(cedula, "Regular", 50000, nombre);
                for (int i = 0; i < sociosRegulares.length; i++) {
                    if (sociosRegulares[i] == null && !registro) {
                        sociosRegulares[i] = socio;
                        registro = true;
                    }
                }
            }
            if (tipo == 1 && !sociosVipNulo() && sociosRegularNulo() && !registro) {
                int regular = Integer.parseInt(JOptionPane.showInputDialog(null, "lastimosamente no hay cupo VIP \n ingrese 1 para hacer el registro regular"));
                if (regular == 1) {
                    String nombre = JOptionPane.showInputDialog(null, "ingrese su nombre");
                    Socio socio = new Socio(cedula, "Regular", 50000, nombre);
                    for (int i = 0; i < sociosRegulares.length; i++) {
                        if (sociosRegulares[i] == null && !registro) {
                            sociosRegulares[i] = socio;
                            registro = true;
                        }
                    }
                }
            }
            if (tipo == 2 && !sociosRegularNulo() && sociosVipNulo() && !registro) {
                int regular = Integer.parseInt(JOptionPane.showInputDialog(null, "lastimosamente no hay cupo Regular \n ingrese 1 para hacer el registro Vip"));
                if (regular == 1) {
                    String nombre = JOptionPane.showInputDialog(null, "ingrese su nombre");
                    Socio socio = new Socio(cedula, "Vip", 100000, nombre);
                    for (int i = 0; i < sociosVip.length; i++) {
                        if (sociosVip[i] == null && !registro) {
                            sociosVip[i] = socio;
                            registro = true;
                        }
                    }
                }
            }
            if (!sociosRegularNulo() && !sociosVipNulo()) {
                JOptionPane.showMessageDialog(null, "no hay cupos disponibles");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ya existe alguien con esa cedula");
        }
    }

    public void inscribirPersonaAutorizada() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cedula de la persona a autorizar"));
        if (buscarCedula(cedula) == null) {
            Socio socio = buscarCedula(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cedula del socio")));
            if (socio == null) {
                JOptionPane.showMessageDialog(null, "no existe un socio con esa cedula");
            } else {
                socio.registrarPersonaAutorizada(cedula);
            }
        } else {
            JOptionPane.showMessageDialog(null, "esa cedula pertenece al socio " + buscarCedula(cedula).getNombre());
        }
    }

    public void registrarConsumo() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese su cedula"));
        Socio socio = buscarCedula(cedula);
        if (socio == null) {
            JOptionPane.showMessageDialog(null, "no hay ningun socio registrado con la cedula");
        } else {
            socio.registrarConsumo();
        }
    }

    public void pagarFactura() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese su cedula"));
        Socio socio = buscarCedula(cedula);
        if (socio == null) {
            JOptionPane.showMessageDialog(null, "no hay ningun socio registrado con la cedula");
        } else {
            socio.pagarFactura();
        }
    }
    
    public void aumentarFondos(){
        int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cedula de la persona para aumentar fondo"));
        Socio socio = buscarCedula(cedula);
        if (socio == null) {
            JOptionPane.showMessageDialog(null, "no hay ningun socio registrado con la cedula");  
        }
         else {
            socio.aumentarFondos();
        }
    }
    public boolean eliminarSocio(){
    int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cedula del socio a eliminar"));
    Socio socio = buscarCedula(cedula);
    boolean socioEliminado = false;
        if (socio == null) {
            JOptionPane.showMessageDialog(null, "no hay ningun socio registrado con la cedula");  
            socioEliminado = false;
        }
        else if (socio.getTipoDeSuscripcion().equals("Vip")) {
            JOptionPane.showMessageDialog(null, "Los socios VIP no pueden ser eliminados");
            socioEliminado = false;}
        else if (socio.contadorFacturasDisponibles() == true) {
            JOptionPane.showMessageDialog(null, "No se pueden eliminar socios con mas de una factura");
        socioEliminado = false;
        }else if (socio.contadorCuposDisponibles()== true) {
            JOptionPane.showMessageDialog(null, "No se pueden eliminar socios con mas de un autorizado");
        socioEliminado = false;} 
        else{
            
            
            
            JOptionPane.showMessageDialog(null, "El socio ha sido eliminado con exito");
        socioEliminado = true;
        }
        
            return socioEliminado ;
    
    }
    public void mostrarConsumos(){
     int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cedula del socio para mostar el consumo"));
            Socio socio = buscarCedula(cedula);
            if (socio == null) {
                JOptionPane.showMessageDialog(null, "no hay ningun socio registrado con la cedula");  
            }else {socio.buscarConsumo();}
    }   

    
    
}
