/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.IOException;



/**
 *
 * @author alumno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   
      	public static void main(String[] args) {
                  try {
                      Menu m =new Menu();
                      m.menuprincipal();
                  } catch (IOException ex) {
                      System.out.println("Excepcion.");
                  }
}
}