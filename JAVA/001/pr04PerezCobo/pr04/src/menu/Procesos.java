package menu;


import Adrian.Jugar;
import Adrian.LeerJugadores;
import prog.util.es.*;

import java.io.IOException;

public class Procesos {
    UtilidadesES utilidadesES;
    Jugar juego = new Jugar();


    Procesos(UtilidadesES utilidadesES) {
        this.utilidadesES = utilidadesES;
    }

    void ejecutarOpc(int opc) throws IOException {
        switch (opc) {
            case 0: ejecutarOpc0();break;
            case 1: ejecutarOpc1();break;
            case 2: ejecutarOpc2();break;
            case 3: ejecutarOpc3();break;
            default: ejecutarNada();
        }
    }

    private void ejecutarOpc0() {
        utilidadesES.mostrarln("Salir");
    }
    private void ejecutarOpc1() throws IOException {
        try {
            LeerJugadores leerJugadores = new LeerJugadores();
            leerJugadores.leerPalabras();
            juego.setJugadores(leerJugadores.getJugadores());

        }catch (IOException E){
            System.out.print("No se ha encontrado el archivo");
        }
    }

    private void ejecutarOpc2() {

    }

    private void ejecutarOpc3() {

        juego.ejecutar();
    }

    private void ejecutarNada() {
        utilidadesES.mostrarln("La opción introducida no tiene un proceso asociado.");
    }
}
