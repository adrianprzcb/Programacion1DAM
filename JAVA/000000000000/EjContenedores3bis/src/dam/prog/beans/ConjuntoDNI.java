package dam.prog.beans;


import java.util.HashSet;

/**
 * Clase que encapsula un conjunto (set) de DNI. Los DNI se implementan mediante un String
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class ConjuntoDNI extends HashSet<String>{
   
    // Constructores
    /**
     * Constructor sin parámetros
     */
    public ConjuntoDNI() {
        super();
    }
    // Métodos
    /**
     * Comprueba si un dni está en el conjunto. Se entiende que son iguales si ambos representan la misma cadena.
     * @param dni DNI a comparar
     * @return true si representan el mismo DNI, false en caso contrario.
     */
    public boolean existe(String dni) {
        if (this.contains(dni))
            return true;
        else
            return false;
    }
}
