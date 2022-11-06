/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.Scanner;
import vista.UtilidadesES;

/**
 *
 * @author bth
 */
public class ValidarDatos {

    UtilidadesES util;
    /**
     * 
     * @param util 
     */
    public ValidarDatos(UtilidadesES util) {
        this.util = util;
    }
    /**
     * Comprueba que el artista se introduzca hasta que sea valido
     * @author ana
     * @param cad mensaje a mostrar
     * @return tipoArt cadena con el tipo de artista
     * @throws IOException si se produce un error en la toma de datos
     */
    public String validarArtista(String cad) throws IOException{
        String tipoArt="";
        do {         
            tipoArt= util.pideCadena(cad).toLowerCase();
            if (tipoArt.equals("cantante") || tipoArt.equals("malabarista") || "poeta".equals(tipoArt)|| tipoArt.equals("musico")) {
                return tipoArt;
            }else System.out.println("Introduce un tipo de artista valido");
        } while (!tipoArt.equals("cantante") || !tipoArt.equals("malabarista") || !"poeta".equals(tipoArt)|| !tipoArt.equals("musico") );
        return tipoArt;
    }
    /**
     * Comprueba que la cadena no este vacia
     * @author ana
     * @param cad mensaje a mostrar
     * @return nombre devuelve un String validado
     * @throws IOException si se produce un error en la toma de datos
     */
    public String validarCadena(String cad) throws IOException {
        String nombre;
        do {
            nombre = util.pideCadena(cad).trim();
            if ("".equals(nombre)) {
                System.out.println("No se puede introducir una cadena vacia. Vuelve a intentarlo.\n");
            }
        } while ("".equals(nombre));
        return nombre;
    }
    /**
     * Comprueba que la edad sea un numero y mayor o igual a 18
     * @author ana
     * @param cad mensaje a mostrar
     * @return edad numero entero validado
     * @throws IOException si se produce un error en la toma de datos
     */
    public int validarEdad(String cad) throws IOException {
        int edad;
        do {
            edad = validarNumero(cad);
            if (edad<18) {
                System.out.println("La edad minima debe ser de 18 años.\n");
            }
        } while (edad < 18);
        return edad;
    }
    /***
     * Comprueba que se ha introducido un numero
     * @author ana
     * @param mensaje cadena a mostrar
     * @return numero un entero validado
     */
    public int validarNumero(String mensaje) {
        Scanner sc;
        int numero = 0;
        boolean valido = false;
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println(mensaje);
                numero = sc.nextInt();
                valido = true;
            } catch (Exception e) {
                System.out.println("Se debe introducir un numero.\n");
            }
        } while (!valido);
        return numero;
    }

}
