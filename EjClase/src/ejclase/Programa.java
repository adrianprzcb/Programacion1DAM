/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejclase;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Programa {
    
    int contador = 0;
    String palabra = null;
    Scanner sc = new Scanner(System.in);
    Boolean acabado = false;
    int mayorPalabra;
    String palabramayor;
    int caracteres = 0;

    
    public void ejecutar(){
        
      do{
    System.out.println("Introduzca una palabra.");
    palabra = sc.nextLine();
    
    if(palabra.length()==0){
        System.out.println("Palabras leídas: "+contador);
        System.out.println("La palabra más grande ha sido "+ palabramayor +" que ha tenido "+mayorPalabra + " carácteres.");
        acabado =true;
    }else{
    System.out.println(palabra.length()+ " carácteres.");
        contador++;
        caracteres = palabra.length();

        if(caracteres>mayorPalabra){
         palabramayor = palabra;
        mayorPalabra = caracteres;
        }
        
        acabado = false;
    
    }
      }while(acabado!=true);
   
    }
    
        }

