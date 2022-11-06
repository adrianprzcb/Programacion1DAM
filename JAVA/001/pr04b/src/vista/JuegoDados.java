package vista;

import modelo.procesos.Procesos;
import vista.Menu;
import vista.OpcionesMenu;
import vista.UtilidadesES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alumno2 on 30/04/2021.
 */
public class JuegoDados {
    private Menu menu;
    private OpcionesMenu opcionesMenu;
    private Procesos procesos;
    private UtilidadesES utilidadesES;

    public JuegoDados() {
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        //son las opciones que se a�aden en el contenedor
        opcionesMenu = new OpcionesMenu();
        //opcionesMenu.add("Salir");
        opcionesMenu.add("Introducir datos de jugadores");
        opcionesMenu.add("Jugar");
        opcionesMenu.add("Mostrar resultados de mejor a peor");
        opcionesMenu.add("Mostrar resultados de peor a mejor");
        opcionesMenu.add("Guardar Archivo");


        menu = new Menu(opcionesMenu, utilidadesES);
        procesos = new Procesos(utilidadesES);
    }

    public void ejecutar() {
        int opc = -1;
        try {
            do {
                menu.presentaMenu();
                try {
                    opc = menu.leeOpcMenu("Introduzca una opción: ");
                    procesos.ejecutarOpc(opc);
                    utilidadesES.mostrarln("Fin del proceso asociado a la opción "+opc);
                } catch(NumberFormatException nfe) {
                    utilidadesES.mostrarln("La opción introducida no es un número.");
                }
            }
            while (opc != Menu.SALIR);
        } catch (IOException e) {
            utilidadesES.mostrarln("Error de toma de datos. Ejecute el programa de nuevo.");

        }
        finally {
            utilidadesES.mostrarln("Fin del programa");
        }
    }
}
