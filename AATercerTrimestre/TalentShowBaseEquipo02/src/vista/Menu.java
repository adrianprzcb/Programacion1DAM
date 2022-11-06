package vista;

import java.io.IOException;
/**
 *
 * @author bth
 */
public class Menu {
    OpcionesMenu opcionesMenu;
    UtilidadesES utilidadesES;
    Menu(OpcionesMenu opcionesMenu, UtilidadesES utilidadesES) {
        this.opcionesMenu = opcionesMenu;
        this.utilidadesES = utilidadesES;
    }

    void presentarMenu() {
        int indice = 1;
        for (String opcion: opcionesMenu) {
            utilidadesES.mostrarln(indice+ " "+opcion);
            indice++;
        }
    }

    /**
     * Lee una opción.
     * @param texto Mensaje Que se muestra para leer el dato.
     * @return La opción introducida, como entero.
     * @throws IOException Error de entrada de datos por teclado
     * @throws NumberFormatException nfe Error en formato de dato no numérico
     */
    int leeOpcMenu(String texto) throws IOException, NumberFormatException {
        int opc;
        opc = Integer.parseInt((utilidadesES.pideCadena(texto)));
        return opc;
        
    }
}
 
