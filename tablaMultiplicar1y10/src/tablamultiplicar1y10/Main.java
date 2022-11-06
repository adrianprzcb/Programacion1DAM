/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablamultiplicar1y10;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author adria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
              int numero;
              Scanner sc = new Scanner(System.in);
              int resultado;
                try{
              do{
               System.out.print("Introduzca un número a multiplicar: ");
               numero = sc.nextInt();
               
               mostrarTabla(numero,0);
               
               }while(numero>=1 && numero<=9);
              
         }catch(InputMismatchException e){
         System.out.println("No has introducido un número.");
         }
              

        }
    
    
    
    public static void mostrarTabla(int numero, int resultado){
    for(int contador=0;contador<=10;contador++){
              resultado = numero * contador;
              System.out.println(numero+ " * " + + contador + "= " + resultado);
              }
              
              }
    }
    
    

