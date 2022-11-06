package talentshow;

import prog.util.es.EntradaSalida;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Miguel on 09/10/2020.
 */
public class Concurso {
    EntradaSalida entradaSalida = new EntradaSalida();

    ArrayList <Artista> listaConcursantes = new ArrayList<>();

    public void ejecutarConcurso() throws IOException {
        int numConcursantes;

        numConcursantes = tomarDatoEnteroPositivo("Introducza el numero de concursantes: ");

        tomarDatos(numConcursantes);

        comenzarConcurso();
    }


    private void tomarDatos(int numConcursantes) throws IOException {
        String nombre, melodia, instrumento;
        int edad;
        Artista nuevoArtista;

        for (int i = 0; i < numConcursantes; i++) {
            nombre=tomarDatoTexto("Introduzca su nombre: ");
            melodia=tomarDatoTexto("Introduzca la melodía: ");
            instrumento=tomarDatoTexto("Introduzca el instrumento: ");
            edad =tomarDatoEnteroPositivo("Introduzca su edad: ");

            nuevoArtista = new Artista(nombre, melodia, instrumento, edad);

            listaConcursantes.add(nuevoArtista);
        }
    }

    public String tomarDatoTexto(String mensaje) throws IOException {
        String texto="";
        while(texto.isEmpty()){
            texto=entradaSalida.pideCadena(mensaje);
            if (texto.isEmpty()){
                mostrarAtencionCampoOblig();
            }
        }
        return texto;
    }

    public int tomarDatoEnteroPositivo(String mensaje) {

        int entero =0;
        while(entero <=0){
            try {
                entero =entradaSalida.pideEntero(mensaje);
                if (entero <=0){
                    entradaSalida.mostrar("No es posible que el dato sea 0 o menor que cero, por favor, introduzca el dato de nuevo.\n");
                } else;
            } catch (NumberFormatException nfe){
                mostrarAtencionCampoOblig();
            }
        }
        return entero;
    }
    public void mostrarAtencionCampoOblig(){
        entradaSalida.mostrar("Es obligatorio que este dato sea rellenado correctamente.\n");
    }
    public void comenzarConcurso(){
        entradaSalida.mostrar("|Concurso Talent Show|\nSe inicia el concurso:\n");
        for (Artista artista: listaConcursantes){
            entradaSalida.mostrar("Artista: "+ artista.getNombre() + ", " + artista.getEdad() + " años." + "\nActuación: "+ artista.actuar() + "\n");
        }
        entradaSalida.mostrar("Fin del concurso.");
    }
}