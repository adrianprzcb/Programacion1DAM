package prtalentshowamp;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import packageutilidadeses.UtilidadesES;
public class Jurado {
    /** Instanciacion de propiedades **/
    UtilidadesES ues = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)),System.out);
    private int nota;
    /** Metodo setter de nota 
     * @return nota
     * **/
    public void setNota(int nota) {
        this.nota = nota;
    }
    /**Metodo que pide y devuelve una nota
     * @return nota
     * **/
    public int evaluar(){
        try {
            nota = Integer.parseInt(ues.pideCadena("Introduzca la nota que tiene el artista "+"\n"));
        } catch (IOException ioe) {
            ues.mostrarln("Error a la toma de datos");
            } catch (NumberFormatException nfe){
                ues.mostrarln("No ha introducido un valor numerico.");
            }
        return nota;
    }
   
}
