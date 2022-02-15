package com.mycompany.clubsocial;

import javax.swing.JOptionPane;

/**
 *
 * @author TdeA
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Socio miPrimerSocio = new Socio(123456,"Regular",50000,"Andres");
        System.out.println("el nombre del socio es " + miPrimerSocio.getNombre());
        miPrimerSocio.setNombre("Diana");
        System.out.println("el nombre del socio es " + miPrimerSocio.getNombre());*/
        
        Club club = new Club("fase22");
        System.out.println("el club esta en " + club);
        
        int opc;
        do{
        opc= Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese \n" + 
                "1 para inscribir socio \n"
                + "2 para inscribir persona autorizada \n"
                 +"3. para pagar factura \n"
                +"4. para registrar el consumo de un socio\n"+
                 "5. para aumentar fondos\n"+
                "6. para eliminar socio\n"+
                "7. para mostrar consumos\n"+
                "0 para salir" ));
        
        switch (opc){
            case 1: {
                club.inscribirSocio();
                break;
            }
            case 2: {
                club.inscribirPersonaAutorizada();
                break;
            }
            case 3: {
                club.pagarFactura();
                break;
            }
            case 4: {
                club.registrarConsumo();
                break;
            }
            case 5:{
                club.aumentarFondos();
                break;
            }
            case 6:{
            club.eliminarSocio();
                 break;}
            case 7:{
            club.mostrarConsumos();
                 break;}
        }
        }while(opc!=0);
        
    }
    
}
