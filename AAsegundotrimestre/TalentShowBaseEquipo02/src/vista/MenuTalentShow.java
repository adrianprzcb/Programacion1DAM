package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import procesos.Procesos;
/**
 *
 * @author bth
 */
public class MenuTalentShow {
    
    private Menu menu;
    private OpcionesMenu opcionesMenu;
    private Procesos procesos;
    private UtilidadesES utilidadesES;
    
    public MenuTalentShow() {
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        //son las opciones que se a�aden en el contenedor
        opcionesMenu = new OpcionesMenu();
        
        opcionesMenu.add(". Registro de artistas");
        opcionesMenu.add(". Concurso");
        opcionesMenu.add(". Lanzar/Parar/Finalizar");
        opcionesMenu.add(". Clasificacion actual");
        opcionesMenu.add(". Clasificacion final");
        opcionesMenu.add(". Iniciar nuevo concurso");
        opcionesMenu.add(". Salir");
        
        menu = new Menu(opcionesMenu, utilidadesES);
        procesos = new Procesos(utilidadesES);
    }

    public void ejecutar() {
        int opc;
        try {
            do {
                opc = ejecutarMenuyProceso();
            }
            while (opc != 7);
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
            System.out.println("\n--- Concurso TalentShow ---");
            menu.presentarMenu();
            opc = menu.leeOpcMenu("Introduzca una opción:\n");
            procesos.ejecutarOpc(opc);
        } catch(NumberFormatException nfe) {
            utilidadesES.mostrarln("La opción introducida no es un número.\n");
        }
        return opc;
    }
}
