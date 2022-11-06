package packagemenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import packageutilidadeses.UtilidadesES;

public class OpcionesMenu extends ArrayList<String> {
    private int nOpciones;
    transient UtilidadesES ues = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
    /** Metodo que pide el numero de opciones que tendra el menu 
     *  set @nOpciones
     *  @throws IOException, NumberFormatException
     *  **/
    public int pedirNumeroOpciones(){
        try {
            nOpciones = Integer.parseInt(ues.pideCadena("Introduzca el numero de opciones que quiere agregar"+"\n"));
        } catch (IOException ioe) {
            ues.mostrarln("Error al tomar datos. Reinicie la aplicacion"+"\n");
            } catch (NumberFormatException nfe){
                ues.mostrarln("No ha introducido un tipo de dato numerico. Reinicie la aplicacion"+"\n");
            }
        return nOpciones;
    }
    /** Metodo que agrega opciones que se daran teclados dependiendo de nOpciones
     * add cada opcion al objeto Opciones 
     * @throws IOException, NumberFormatException**/
    public void agregarOpciones(int nOpciones){
        for (int i=0;i<nOpciones;i++){
            try {
                add(ues.pideCadena("Introduzca la opcion"));
            } catch (IOException ioe) {
                ues.mostrarln("Error a la toma de datos."+"\n"+"Reinicie la aplicacion.");
            }
        }
    }
}
