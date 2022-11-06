package ejcontenedores.procesos;


import java.util.Iterator;

import ejcontenedores.beans.ListaUsuarios;
import ejcontenedores.beans.Usuario;

/**
 * Proceso que emplea ArrayList
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class ProcesoArrayList {

    /**
     * Ejecuta el proceso asociado al ejemplo de uso de ArrayList
     */
    public void ejecutar() {
        ListaUsuarios lUsr = null;
        Usuario usr1, usr2, usr3, usr;
        Iterator<Usuario> iterador = null;

        // Se crean los usuarios
        usr1 = new Usuario("José","López Rodríguez","19226458E");
        usr2 = new Usuario("Francisco","Martín Luca","29226458J");
        usr3 = new Usuario("Ana","Viera Luján","24781902T");

        // Se crea el contenedor
        lUsr = new ListaUsuarios();

        // Se a�aden los usuarios uno a uno al contenedor

        lUsr.addUsuario(usr1);
        lUsr.addUsuario(usr2);
        lUsr.addUsuario(usr3);

		/*
		 * Un código alternativo:
		 *
		 * ArrayList<Usuario> lista = new ArrayList<Usuario>();
		 * lista.add(usr1);
		 * lista.add(usr2);
		 * lista.add(usr3);
		 * lUsr = new ListaUsuarios(lista);
		 */

        // Se accede al primer usuario de la lista de usuarios
        mensaje("Se accede al primer usuario de la lista de usuarios");
        usr = lUsr.getUsuario(0);
        // Se muestra la información correspondiente al usuario extraído
        mensaje("Se muestra la información correspondiente del usuario extraido");
        mensaje(usr);
        // Se accede al segundo usuario
        mensaje("Se accede al segundo usuario");
        usr = lUsr.getUsuario(1);
        // Se muestra la informaci�n correspondiente al usuario extra�do
        mensaje("Se muestra la información correspondiente al usuario extraido");
        mensaje(usr);
        // Se muestran los datos de todos los usuarios
        mensaje("Se muestran los datos de todos los usuarios");
        // Se obtiene un iterador para el ArrayList<Usuario>
        iterador = lUsr.getListaUsr().iterator();

        // Recorrer la lista de usuarios mediante el iterador
        while (iterador.hasNext()) {
            usr = (Usuario) iterador.next();
            mensaje(usr);
        }

        // Se extrae de la lista el segundo usuario
        mensaje("Se extrae de la lista el segundo usuario");
        usr = lUsr.remove(1);
        mensaje("Datos del usuario extraido");
        mensaje(usr);
        // Se muestran los datos de todos los usuarios
        mensaje("Se muestran los datos de todos los usuarios");
		/*
		 * C�digo alternativo usando un bucle foreach
		 */
        for (Usuario usuario: lUsr.getListaUsr()) {
            mensaje(usuario);
        }

        // Se inserta un nuevo usuario en medio de los dos existentes
        mensaje("Se inserta un nuevo usuario en medio de los dos existentes");
        lUsr.getListaUsr().add(1, new Usuario("Javier","Solís Lora","29001433C"));

        // Se muestran los usuarios de nuevo
        mensaje("Se muestran los datos de todos los usuarios");
        for (Usuario usuario: lUsr.getListaUsr()) {
            mensaje(usuario);
        }
    }

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
}

