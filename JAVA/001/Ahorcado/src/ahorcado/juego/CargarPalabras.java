package ahorcado.juego;

import prog.util.es.UtilidadesES;

import java.io.*;
import java.util.ArrayList;

public class CargarPalabras {

    private File archivo =  null;
    private UtilidadesES utilES;
    private ArrayList<String> palabras;

    public CargarPalabras(){
        utilES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        palabras = new ArrayList<String>();
    }



    public void leerPalabras() throws IOException {

        archivo = new File("diccionario.txt");
        String cadena = "";
        String[] auxiliar;
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        while ((cadena = br.readLine()) != null) {
           auxiliar = cadena.split(":");
            for(int i=0 ;i<auxiliar.length; i++){
                palabras.add(auxiliar[i]);


            }
        }

        }


    public ArrayList<String> getPalabras() {
        return palabras;
    }

}
