/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.es;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class EntradaSalida {
    public String pideCadena(String mensaje){
        Scanner sc= new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextLine();
    }
    
    public int pideNumero(String mensaje) throws NumberFormatException{
        Scanner sc= new Scanner(System.in);
        System.out.println(mensaje);
        return Integer.parseInt(sc.nextLine());
    }
}
