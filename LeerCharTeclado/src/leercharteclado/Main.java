/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leercharteclado;

import java.io.IOException;

/**
 *
 * @author adria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        char caracter;
        
        System.out.println("Introduzca un carácter por teclado: ");
        caracter = (char) System.in.read();
        
        System.out.println("El carácter introducido es "+ caracter);
    }
    
}
