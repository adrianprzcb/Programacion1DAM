/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.Serializable;

/**
 * 
 * @author Marina y Salvador
 */
public class Menu implements Serializable{
    
    public static final int SALIR = 7;
    OpcionesMenu opcionesMenu;
    /**
     * Este es el constructor de menú
     * @param opcionesMenu 
     */
    public Menu(OpcionesMenu opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }
    /**
     * Presenta el menú del esrado correspondiente.
     * @param estado 
     */
    public void presentaMenu(String estado) {
        int indice = 1;
        int i = 1;
        
       UtilidadesES.mostrarln("**MENÚ**");
        for (String opcion: opcionesMenu) {
            if("Parado".equals(estado) && (indice==1 || indice==3 || indice==4 ||  indice==5 || indice==8 )){
                UtilidadesES.mostrarln(i+ " "+opcion);
                i++;
            }else if("Lanzado".equals(estado) && (indice==2 || indice==4 || indice==5|| indice==8)){
                UtilidadesES.mostrarln(i+ " "+opcion);
                i++;
            }else if("Finalizado".equals(estado) && (indice==4 || indice==6 || indice==7|| indice==8)){
                UtilidadesES.mostrarln(i+ " "+opcion);
                i++;
            }
            
            
            indice++;
        }
        //UtilidadesES.mostrarln(Menu.SALIR+ " Salir");
        
    }

    /**
     * Lee una opción.
     * @param texto Mensaje Que se muestra para leer el dato.
     * @return La opción introducida, como entero.
     * @throws IOException Error de entrada de datos por teclado
     * @throws NumberFormatException nfe Error en formato de dato no numérico
     */
    public int leeOpcMenu(String texto) throws IOException, NumberFormatException {
        int opc;
        opc = Integer.parseInt((UtilidadesES.pideCadena(texto)));
        return opc;
        
    }
}
