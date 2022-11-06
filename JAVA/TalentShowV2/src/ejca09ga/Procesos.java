package ejca09ga;

import prog.util.es.CadenaVaciaExcepcion;
import prog.util.es.EntradaSalida;

import java.io.IOException;
import java.util.*;

/**
 * Created by Javi on 03/04/2021.
 */
public class Procesos {
    public static final int EDAD_MIN_CONCURSANTE = 14;
    private static final int NUM_MIN_OBJETOS = 2;
    private static final int PUNT_MIN = 0;
    private static final int PUNT_MAX = 20;

    private EntradaSalida entradaSalida;
    private HashMap<Integer, Artista> listaConcursantes;
    private HashMap<Integer, Integer> listaPuntuaciones;

    public Procesos() {
        entradaSalida = new EntradaSalida();
        listaConcursantes = new HashMap<Integer, Artista>();
        listaPuntuaciones = new HashMap<Integer, Integer>();
    }
    public Procesos(int num_objetos) {
        entradaSalida = new EntradaSalida();
        listaConcursantes = new HashMap<Integer, Artista>();
        listaPuntuaciones = new HashMap<Integer, Integer>();
    }


    public void ejecutar() {
        try {
            crearConcursantes();
            ejecutarYPuntuar();
            consultarPuntuaciones();
        } catch (IOException e) {
            entradaSalida.mostrar("Se ha producido un error en la E/S de datos: "+e.getMessage());
        }


    }

    private void crearConcursantes() throws IOException {
        String eleccion = "";
        boolean continuar=true;
        int contador = 1;
        entradaSalida.mostrar("Añade los participantes: ");
        do {
            try {
                eleccion = entradaSalida.pideCadenaMensaje("Introduce C para cantante, P para poeta y M para malabarista: ");
                if (eleccion.equalsIgnoreCase("c")) {
                    introducirCantantes(contador);
                    contador++;
                } else if (eleccion.equalsIgnoreCase("p")) {
                    introducirPoetas(contador);
                    contador++;
                } else if (eleccion.equalsIgnoreCase("m")) {
                    introducirMalabaristas(contador);
                    contador++;
                } else
                    entradaSalida.mostrar("Introduzca un valor válido");
                continuar = preguntarOtroMas();
            } catch (CadenaVaciaExcepcion cve) {
                entradaSalida.mostrar("Error: "+cve.getMessage());
            } catch (NumberFormatException nfe) {
                entradaSalida.mostrar("Error: No se ha introducido un número");
            }
        } while (continuar);
    }


    private boolean preguntarOtroMas() throws IOException {
        boolean continuar = true;
        String respuesta;
        respuesta = entradaSalida.pideCadenaMensaje("¿Desea añadir otro artista? (S/Cualquier otra tecla para no)");
        if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
        }
        return continuar;
    }


    // INTRODUCIR CANTANTES , POETAS Y MALABARISTAS
    private void introducirCantantes(int numParticipante) throws IOException, NumberFormatException {
        Cantante cantante;
        String nombre = entradaSalida.pedirDatoTexto("Introduce el nombre: ");
        String cancion = entradaSalida.pedirDatoTexto("Introduce la canción: ");
        int edad = entradaSalida.pedirDatoNumero("Introduce la edad: ",Procesos.EDAD_MIN_CONCURSANTE);
        cantante = new Cantante(nombre, edad, numParticipante, cancion);
        listaConcursantes.put(cantante.getNumConcursante(), cantante);
    }

    private void introducirMalabaristas(int numConcursante) throws IOException, CadenaVaciaExcepcion, NumberFormatException {
        Malabarista malabarista;
        String nombre = entradaSalida.pedirDatoTexto("Introduce el nombre: ");
        int numObjetos = entradaSalida.pedirDatoNumero("Introduce el número de objetos: ",this.NUM_MIN_OBJETOS);
        int edad = entradaSalida.pedirDatoNumero("Introduce la edad: ",Procesos.EDAD_MIN_CONCURSANTE);
        malabarista = new Malabarista(nombre, edad, numConcursante, numObjetos);
        listaConcursantes.put(malabarista.getNumConcursante(), malabarista);
    }

    private void introducirPoetas(int numConcursante) throws IOException, CadenaVaciaExcepcion, NumberFormatException {
        Poeta poeta;
        String nombre = entradaSalida.pedirDatoTexto("Introduce el nombre: ");
        String poema = entradaSalida.pedirDatoTexto("Introduce el poema: ");
        int edad = entradaSalida.pedirDatoNumero("Introduce la edad: ",Procesos.EDAD_MIN_CONCURSANTE);
        poeta = new Poeta(nombre, edad, numConcursante, poema);
        listaConcursantes.put(poeta.getNumConcursante(), poeta);
    }


    private void ejecutarYPuntuar() throws IOException {
        for (int i=1; i<=listaConcursantes.size();i++) {
            ejecutarActuaciones(i);
            puntuarActuaciones(i);
        }
    }

    private void ejecutarActuaciones(int i) {
        listaConcursantes.get(i).saludar();
        listaConcursantes.get(i).actuar();
        listaConcursantes.get(i).despedirse();
    }

    private void puntuarActuaciones(int numConcursante) throws IOException {
        int puntuacion;
        boolean continuar=false;
        do {
            puntuacion = entradaSalida.pedirDatoNumero("Introduce la puntuación para este artista: ",Procesos.PUNT_MIN,Procesos.PUNT_MAX);
            if (puntuacion<Procesos.PUNT_MIN |puntuacion>Procesos.PUNT_MAX) {
                try {
                    throw new FueraLimitesExcepcion("Introduce un número entre "+Procesos.PUNT_MIN+" y "+ Procesos.PUNT_MAX);
                } catch (FueraLimitesExcepcion fueraLimitesExcepcion) {
                    entradaSalida.mostrar("Error: "+fueraLimitesExcepcion.getMessage());
                }
            } else continuar=true;
        } while (!continuar);
        listaPuntuaciones.put(numConcursante,puntuacion);
    }

    private void consultarPuntuaciones() throws IOException {
        int artistaBuscar;
        do {
            artistaBuscar = entradaSalida.pideNumeroMensaje("Introduce el número del artista para consultar su puntuación: (0 para salir)");
            if (artistaBuscar!=0)
                entradaSalida.mostrar("La puntuación del artista es: "+listaPuntuaciones.get(artistaBuscar).toString());
        } while (artistaBuscar!=0);
        mostrarOrdenadas(listaPuntuaciones);
    }

    private void mostrarOrdenadas(Map<Integer,Integer> listaPuntuaciones) {

    }

}
