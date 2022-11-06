package ahorcado.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import prog.util.es.*;

public class MenuAhorcado {
    
    private Menu menu;
    private OpcionesMenu opcionesMenu;
    private Procesos procesos;
    private UtilidadesES utilidadesES;
    
    public MenuAhorcado() {
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        //son las opciones que se a�aden en el contenedor
        opcionesMenu = new OpcionesMenu();

        opcionesMenu.add("Cargar Palabras del diccionario");
        opcionesMenu.add("Añadir Jugadores");
        opcionesMenu.add("Jugar");
        
        menu = new Menu(opcionesMenu, utilidadesES);
        procesos = new Procesos(utilidadesES);
    }

    public void ejecutar() {
        int opc = -1;
        try {
            do {
                opc = ejecutarMenuyProceso();
            }
            while (opc != Menu.SALIR);
        } catch (IOException e) {
            utilidadesES.mostrarln("Error de toma de datos. Ejecute el programa de nuevo.");
            
        }
        finally {
            utilidadesES.mostrarln("Fin del programa");
        }
    }
    private int ejecutarMenuyProceso() throws IOException {
        int opc = -1;
        try {
            menu.presentaMenu();
            opc = menu.leeOpcMenu("Introduzca una opción: ");
            procesos.ejecutarOpc(opc);
        } catch(NumberFormatException nfe) {
            utilidadesES.mostrarln("La opción introducida no es un número.");
        }
        return opc;
    }
}
