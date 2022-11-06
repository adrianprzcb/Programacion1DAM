package prejmenu;

import java.io.IOException;

public class Menu {
    OpcionesMenu opcionesMenu;
    UtilidadesES utilidadesES;
    Menu(OpcionesMenu opcionesMenu, UtilidadesES utilidadesES) {
        this.opcionesMenu = opcionesMenu;
        this.utilidadesES = utilidadesES;
    }

    void presentaMenu() {
        int indice = 1;
        for (String opcion: opcionesMenu) {
            utilidadesES.mostrarln(indice+ " "+opcion);
            indice++;
        }
    }

    int leeOpcMenu(String texto) throws IOException {
        int opc;
        opc = Integer.parseInt(utilidadesES.pideCadena(texto));
        return opc;
    }
}
