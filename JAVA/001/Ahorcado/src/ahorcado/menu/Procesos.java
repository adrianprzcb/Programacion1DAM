package ahorcado.menu;

import ahorcado.juego.Juego;
import ahorcado.juego.PedirJugadores;
import ahorcado.juego.CargarPalabras;
import prog.util.es.*;

import java.io.IOException;

public class Procesos {
    UtilidadesES utilidadesES;
    Juego juego = new Juego();
    
    Procesos(UtilidadesES utilidadesES) {
        this.utilidadesES = utilidadesES;
    }

    void ejecutarOpc(int opc) {
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
    private void ejecutarOpc1()  {
        utilidadesES.mostrarln("Se cargaron las palabras del archivo");
        try {
            CargarPalabras cargarPalabras = new CargarPalabras();
            cargarPalabras.leerPalabras();
            juego.setPalabras(cargarPalabras.getPalabras());

        }catch(IOException e){
            System.out.println("No se ha encontrado el fichero");
        }
    }

    private void ejecutarOpc2() {
        PedirJugadores pedirJugadores = new PedirJugadores();
        pedirJugadores.crearJugadores();
        juego.setJugadores(pedirJugadores.getJugadores());
    }

    private void ejecutarOpc3() {
        utilidadesES.mostrarln("Empieza el juego");
        juego.jugar();
    }

    private void ejecutarNada() {
        utilidadesES.mostrarln("La opción introducida no tiene un proceso asociado.");
    }
}
