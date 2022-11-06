/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud1ejclase1;

import java.util.Scanner;

/**
 *
 * @author adria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Main main = new Main();
        main.buscaPalabras();
        main.sumaNumeros();
        
    }
        String[] palabras = {"Hola","Adiós","Perro","Gato","Koala","Canguro","Zumo","Piña","Pizza","Gol",};
        int[] numeros = {10,20,30,40,50,60,70,80,90,22,12,23,13,24,14,25,15,26,27,28};
        Scanner sc = new Scanner(System.in);
        Boolean palabraencontrada = false;        
        
        public void buscaPalabras(){
           do{
                System.out.println("Introduzca una palabra:");
                 String palabra = sc.next();

        for (int i = 0; i < palabras.length; i++) {
          
        
            if(palabra.equals(palabras[i])){
                System.out.println("Palabra Encontrada.");
                palabraencontrada=true;
            }
        }
        if(palabraencontrada!=true){
        System.out.println("Palabra No Encontrada. Inténtalo de nuevo.");
        }
                    
            }while(palabraencontrada!=true);
                                     

        }
        
        int resultado;
       
        
        public void sumaNumeros(){
           
            for(int i=0; i< numeros.length ; i++){
            
                 resultado += numeros[i];
                 
           
                 if(numeros[i]==numeros[19]){
                 System.out.print(numeros[i] + " = ");
                 }else {
                 System.out.print(numeros[i] + " + ");}
                 
            }
            System.out.println(resultado);
    
    }
    
}
