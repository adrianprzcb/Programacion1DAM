package ejcontenedores;


import ejcontenedores.procesos.ProcesoArrayList;

/**
 * Contenedores.
 * Clase principal que muestra un ejemplo de uso de ArrayList
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class EjArrayList {

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {
        ProcesoArrayList proceso = new ProcesoArrayList();
        proceso.ejecutar();
    }
}
