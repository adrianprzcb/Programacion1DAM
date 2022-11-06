package dam.prog.proceso;

import dam.prog.beans.Usuario;

public class IO {
    /**
     * Muestra el mensaje cadena
     * @param cadena
     */
    public void mensaje(String cadena) {
            System.out.println(cadena);
    }
    /**
     * Muestra la cadena resultante de Usuario
     * @param usr Objeto Usuario que se mostrará como cadena
     */
    public void mensaje(Usuario usr) {
            System.out.println(usr);
    }
    
    public void mensaje(Object objeto) {
        System.out.println(objeto);
    }
}
