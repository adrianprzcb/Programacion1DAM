/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgswitch;

/**
 *
 * @author adria
 */
public class Switch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nota ;
        String calificacion ;
        nota = 7;
        
        switch(nota){
            case 10:
            case 9: calificacion = "Sobre";break; 
            case 8:
            case 7:calificacion = "Notable"; break;
            case 6:calificacion = "Bien"; break;
            case 5:calificacion = "Suficiente"; break;
            default: calificacion = "Suspenso"; break;
        }
        System.out.println(calificacion);
    }
    
}
