/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejdowhile;

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
        char intro;
        
        
         System.out.print("Introduzca un carácter:");
        caracter = (char) System.in.read();
                intro = (char) System.in.read();
                
                while(caracter!= 's'){
                System.out.print("Introduzca un carácter:");
        caracter = (char) System.in.read();
                intro = (char) System.in.read();
                }
    
        
   /*         do{
        System.out.print("Introduzca un carácter:");
        caracter = (char) System.in.read();
                intro = (char) System.in.read();

        }while(caracter != 'S');
          
    }*/
    
}
}