package vista;

import java.io.IOException;

/**
 * Created by alumno2 on 30/04/2021.
 */
public class Menu {
    public static final int SALIR = 0;
    OpcionesMenu opcionesMenu;
    UtilidadesES utilidadesES;
    public Menu(OpcionesMenu opcionesMenu, UtilidadesES utilidadesES) {
        this.opcionesMenu = opcionesMenu;
        this.utilidadesES = utilidadesES;
    }

    public void presentaMenu() {
        int indice = 1;
        for (String opcion: opcionesMenu) {
            utilidadesES.mostrarln(indice+ " "+opcion);
            indice++;
        }
        utilidadesES.mostrarln(0+ " Salir");

    }

    /**
     * Lee una opción.
     * @param texto Mensaje Que se muestra para leer el dato.
     * @return La opción introducida, como entero.
     * @throws IOException Error de entrada de datos por teclado
     * @throws NumberFormatException nfe Error en formato de dato no numérico
     */
    public int leeOpcMenu(String texto) throws IOException, NumberFormatException {
        int opc;
        opc = Integer.parseInt((utilidadesES.pideCadena(texto)));
        return opc;

    }
}
