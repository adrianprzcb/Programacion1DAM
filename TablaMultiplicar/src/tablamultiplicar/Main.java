/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablamultiplicar;

import java.util.Scanner;

/**
 *
 * @author adria
 */
public class Main {

 
    public static void main(String[] args) {
        
        Scanner entrada=new Scanner(System.in);
           System.out.println("Introduce un número:");
        int numero=entrada.nextInt();

        int resultado;
        
        for(int veces = 1 ; veces<10;veces++){
           
           resultado = numero * veces ;
           System.out.println(numero + " por "+ veces + " es igual a = "+ resultado);
                      

        }
    }
    
}
