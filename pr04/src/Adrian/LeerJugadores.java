package Adrian;

import prog.util.es.UtilidadesES;

import java.io.*;
import java.util.ArrayList;


public class LeerJugadores {

    private File archivo = null;
    private UtilidadesES utilES;
    private ArrayList<String> jugadores;

    public LeerJugadores(){
        utilES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        jugadores = new ArrayList<String>();
    }



    public void leerPalabras() throws IOException {
        archivo = new File("datos.txt");
        String cadena = "";
        String[] auxiliar;
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        while ((cadena = br.readLine()) != null) {
            auxiliar = cadena.split(":");
            for(int i=0 ;i<auxiliar.length; i++){
                jugadores.add(auxiliar[i]);

            }
        }

    }


    public ArrayList<String> getJugadores() {
        return jugadores;
    }

}
