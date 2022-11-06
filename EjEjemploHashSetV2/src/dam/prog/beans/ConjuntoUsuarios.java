package dam.prog.beans;

import java.util.HashSet;
/**
 * Clase que encapsula un conjunto (set) de Usuarios. Los usuarios se implementan mediante un objeto Usuario
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class ConjuntoUsuarios extends HashSet<Usuario> {
    
    // Constructores
    /**
     * Constructor sin parámetros
     */
    public ConjuntoUsuarios() {
        super();
    }

    // M�todos
    /**
     * Comprueba si el conjunto contiene el objeto proporcionado como parámetro. Se realiza la comparación
     * en base al estado, de forma que si ambos objetos poseen el mismo estado de dni, nombre y apellidos, se considera
     * que son iguales.
     * @param usuario Objeto Usuario sobre el que se pregunta.
     * @return true si son iguales, false en caso contrario.
     */
    public boolean contiene(Usuario usuario) {
        if (this.contains(usuario))
            return true;
        else
            return false;
    }
}
