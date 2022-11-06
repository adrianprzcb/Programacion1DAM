package packagemenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import packageutilidadeses.UtilidadesES;
//Clase encargada de crear la salida de un menu
//Necesita de ella la clase opcionesmenu, la cual crea entradas del menu, y tiene otra opcion en la que puedes indicarle
//el numero de opciones que va a tener y crearte ese numero de entradas

public class Menu { 
    /** Instancion de variables **/
    OpcionesMenu opcionesmenu = new OpcionesMenu();
    UtilidadesES ues = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)),System.out);
    private String opc;
    /** Constructor de Menu **/
    public Menu(OpcionesMenu opcionesmenu){
        this.opcionesmenu = opcionesmenu;
    }
    /** Metodo que muestra opcion del objeto opcionesMenu
     * sysoutpln @i+@opcion
     * **/
    public void presentaMenu(){
        int i=1;
        for(String opcion: opcionesmenu){
            ues.mostrarln(i+". "+opcion);
            i++;
        }
    }
    /**Metodo que elige opc
     * set @opc
     * @throws IOException, NumberFormatException
     * **/
    public void elegirOpc(){
        try {
            opc = (ues.pideCadena("Introduzca una opcion"+"\n"));
        } catch (IOException ioe) {
            ues.mostrarln("Error provocado al tomar datos"+"\n"+"Reinicie la aplicacion.");
            } 
    }
    /** Metodo getter de Opc
     * @return opc
     * **/
    public String getOpc(){
        return opc;
    }
}
