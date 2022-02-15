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
public class Socio {

    //Atributos
    private int cedula;
    private String tipoDeSuscripcion;
    private double fondos;
    private String nombre;
    private PersonaAutorizada[] personasAutorizadas;
    private Factura[] facturas;

    public Socio() {
        cedula = 123456;
        tipoDeSuscripcion = "Vip";
        fondos = 50000;
        nombre = "Andres";
        System.out.println("socio creado exitosamente");
    }

    public Socio(int cedula, String tipoDeSuscripcion, double fondos, String nombre) {
        this.cedula = cedula;
        this.tipoDeSuscripcion = tipoDeSuscripcion;
        this.fondos = fondos;
        this.nombre = nombre;
        this.personasAutorizadas = new PersonaAutorizada[3];
        this.facturas = new Factura[20];
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getTipoDeSuscripcion() {
        return tipoDeSuscripcion;
    }

    public void setTipoDeSuscripcion(String tipoDeSuscripcion) {
        this.tipoDeSuscripcion = tipoDeSuscripcion;
    }

    public double getFondos() {
        return fondos;
    }

    public void setFondos(double fondos) {
        this.fondos = fondos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PersonaAutorizada[] getPersonasAutorizadas() {
        return personasAutorizadas;
    }

    public void setPersonasAutorizadas(PersonaAutorizada[] personasAutorizadas) {
        this.personasAutorizadas = personasAutorizadas;
    }

    public Factura[] getFacturas() {
        return facturas;
    }

    public void setFacturas(Factura[] facturas) {
        this.facturas = facturas;
    }

    public void registrarPersonaAutorizada(int cedula) {
        boolean registro = false;
        if (buscarCedula(cedula) == null) {
            if (cuposDisponibles() && this.fondos >= 50000) {
                for (int i = 0; i < personasAutorizadas.length; i++) {
                    if (personasAutorizadas[i] == null && !registro) {
                        String nombre = JOptionPane.showInputDialog(null, "ingrese el nombre de la persona");
                        PersonaAutorizada persona = new PersonaAutorizada(nombre, this, cedula);
                        personasAutorizadas[i] = persona;
                        registro = true;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "el socio no puede registrar mas personas");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ya existe una persona con esa cedula afiliada por este socio");
        }
    }

    public boolean cuposDisponibles() {
        for (int i = 0; i < personasAutorizadas.length; i++) {
            if (personasAutorizadas[i] == null) {
                return true;
            }
        }
        return false;
    }
    public boolean contadorCuposDisponibles() {
         boolean variableQueVerificaLosCupos = false;
         int cont = 0;
         
        for (int i = 0; i < personasAutorizadas.length; i++) {
            if (personasAutorizadas[i] != null) {
                cont +=1;
            }if (cont >=2){
               variableQueVerificaLosCupos = true;
            }
        }
        return variableQueVerificaLosCupos;
    }

    public PersonaAutorizada buscarCedula(int cedula) {

        PersonaAutorizada encontrado = null;
        for (int i = 0; i < personasAutorizadas.length; i++) {
            if (personasAutorizadas[i] != null && personasAutorizadas[i].getCedula() == cedula) {
                encontrado = personasAutorizadas[i];
            }
        }

        return encontrado;
    }

    public void registrarConsumo() {
        if (this.fondos >= 50000) {
            if (facturasDisponibles()) {
                boolean registro = false;
                for (int i = 0; i < facturas.length; i++) {
                    if (facturas[i] == null && !registro) {
                        String concepto = JOptionPane.showInputDialog(null, "ingrese el concepto del consumo");
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el valor del consumo"));
                        Factura factura = new Factura(concepto, valor, this.nombre);
                        facturas[i] = factura;
                        registro = true;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "el socio no puede tener mas facturas sin pagar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "el socio no tiene fondos suficientes");
        }
    }

    public boolean facturasDisponibles() {
      
        for (int i = 0; i < facturas.length; i++) {
            if (facturas[i] == null) {
               
                return true;     
            }
        }

        return false;
    }
    public boolean contadorFacturasDisponibles() {
        int cont = 0;
        boolean variableQueVerificaLaFactura = false;
        for (int i = 0; i < facturas.length; i++) {
            if (facturas[i] != null) {
                cont +=1;
                   
            }
        }
        if (cont >= 2){
        variableQueVerificaLaFactura = true;}
        
        return variableQueVerificaLaFactura;
    }

    public String mostrarFacturas() {
        String factura = "";
        for (int i = 0; i < facturas.length; i++) {
            if (facturas[i] != null) {
                factura += (i + " concepto: " + facturas[i].getConcepto() + " valor: " + facturas[i].getValor() + " \n");
            }
        }
        return factura;
    }
     public void buscarConsumo() {
         String factura = mostrarFacturas();
        for (int i = 0; i < facturas.length; i++) {
            if (facturas[i] !=null) {
                JOptionPane.showMessageDialog(null,"Su consumo #"+(i++)+" son: "+facturas[i].getConcepto()+"Con un valor de:"+facturas[i].getValor());
            }else {
            JOptionPane.showMessageDialog(null,"No tiene comsumos ");
            }
        }
        
    }

    public void pagarFactura() {
        String factura = mostrarFacturas();
        if (factura.equals("")) {
            JOptionPane.showMessageDialog(null, "el socio no tiene facturas pendientes de pago");
        } else {
            int posicion = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el numero de factura a pagar \n" + factura));
            if (posicion >= 0 && posicion <= facturas.length && facturas[posicion] != null) {
                if (facturas[posicion].getValor() <= fondos) {
                    fondos -= facturas[posicion].getValor();
                    facturas[posicion] = null;
                } else {
                    JOptionPane.showMessageDialog(null, "el socio no cuenta con fondos suficientes");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ingrese una posicion valida");
            }
        }

    }
    public void aumentarFondos(){
      if (tipoDeSuscripcion.equals("Regular"));{
            double fondos = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese la actulización del fondo"));
            if (fondos>1000000){
                JOptionPane.showMessageDialog(null,"El fondo ingresado no es permitido");}
            else{
            JOptionPane.showMessageDialog(null,"Fondo Actualizado con exito");}
            
       
        }
      if (tipoDeSuscripcion.equals("Vip")) {
            double fondos = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese la actulización del fondo"));
            if (fondos>5000000){
                JOptionPane.showMessageDialog(null,"El fondo ingresado no es permitido");}
            else{
            JOptionPane.showMessageDialog(null,"Fondo Actualizado con exito");}
                
        }
     
     
    }
    
   
}
    
      
