package prejmenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjMenu {
    
    private Menu menu;
    private OpcionesMenu opcionesMenu;
    private Procesos procesos;
    private UtilidadesES utilidadesES;
    
    public EjMenu() {
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        
        opcionesMenu = new OpcionesMenu();
        opcionesMenu.add("Insertar");
        opcionesMenu.add("Borrar");
        opcionesMenu.add("Modificiar");
        
        menu = new Menu(opcionesMenu, utilidadesES);
        procesos = new Procesos(utilidadesES);
    }

    public void ejecutar() {
        int opc = -1;
        menu.presentaMenu();
        try {
            opc = menu.leeOpcMenu("Introduzca una opción: ");
            procesos.ejecutarOpc(opc);
            utilidadesES.mostrarln("Fin del proceso asociado a la opción "+opc);
        } catch (IOException e) {
            utilidadesES.mostrarln("La opción introducida no es un número. Ejecute el programa de nuevo.");
        }
        finally {
            utilidadesES.mostrarln("Fin del programa");
        }
    }
}
