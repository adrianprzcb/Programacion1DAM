/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejvariastablas2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class EjVariasTablas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
    EjVariasTablas2 aplicacion = new EjVariasTablas2();
    aplicacion.ejecutar();
    
    
    
    
    
    
    }

    private void ejecutar() throws IOException {
 
      String cadena;
        char caracter; 
        int numTabla;

        do {
            System.out.println("Introduzca número entre 1 y 9:");
            // Método 1: leer de otra forma. No funciona dentro del IDE
            //cadena = System.console().readLine();
            //numTabla = Integer.parseInt(cadena);
            
            
            // Método 2: convirtiendo el dato
            caracter = (char) System.in.read();
            
            // Se descartan resto de caracteres incluido el Intro
            do {
                System.in.read();
            } while (System.in.available()!=0);
            // Se convierte al dígito numérico correspondiente
            numTabla = Character.getNumericValue(caracter);
                       
            
            //------------
            if (numTabla >= 1 && numTabla <=9) 
                mostrarTabla(numTabla);
        } while (numTabla >= 1 && numTabla <=9);
        

        }
    
    
    
  public static void mostrarTabla(int numTabla) {
        int resultado = 0;
        
        for (int contador=1; contador <=10; contador++) {
            resultado = contador*numTabla;
            System.out.println(numTabla+"*"+contador+"="+resultado);
        }
    }
    
    
    }
    
    
    
