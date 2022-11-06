package dam.prog.procesos;

import dam.prog.beans.ListaUsuarios;
import dam.prog.beans.Usuario;

import java.util.ListIterator;

/**
 * Proceso que emplea LinkedList
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class ProcesoLinkedList {
	/**
	 * Ejecuta el proceso asociado al ejemplo de uso de ArrayList
	 */
	public void ejecutar() {
		ListaUsuarios lUsr = null;
		Usuario usr1, usr2, usr3, usr;
		ListIterator<Usuario> iterador = null;
		
		// Se crean los usuarios
		usr1 = new Usuario("José","López Rodríguez","19226458E");
		usr2 = new Usuario("Francisco","Martín Luca","29226458J");
		usr3 = new Usuario("Ana","Viera Luján","24781902T");
		
		// Se crea el contenedor
		lUsr = new ListaUsuarios();
		
		// Se añaden los usuarios uno a uno al contenedor
		
		lUsr.addUsuario(usr1);
		lUsr.addUsuario(usr2);
		lUsr.addUsuario(usr3);
		
		/*
		 * Un c�digo alternativo:
		 * 
		 * LinkedList<Usuario> lista = new LinkedList<Usuario>();
		 * lista.add(usr1);
		 * lista.add(usr2);
		 * lista.add(usr3);
		 * lUsr = new ListaUsuarios(lista);
		 */
		
		// Se accede al primer usuario de la lista de usuarios
		mensaje("Se accede usuario de la lista de usuarios según dni");
		usr = lUsr.getUsuario("24781902T");
		// Se muestra la informaci�n correspondiente al usuario extraído
		mensaje("Se muestra la información correspondiente del usuario extraído");
		mensaje(usr);
		// Se muestran los datos de todos los usuarios
		mensaje("Se muestran los datos de todos los usuarios");
		// Se obtiene un iterador para el ArrayList<Usuario>
		iterador = lUsr.getListaUsr().listIterator();
		
		// Recorrer la lista de usuarios mediante el iterador
		while (iterador.hasNext()) {
			usr = (Usuario) iterador.next();
			mensaje(usr);
		}
		
		// Se extrae de la lista un usuario según dni
		mensaje("Se extrae de la lista un usuario según dni");
		usr = lUsr.remove("24781902T");
		mensaje("Datos del usuario extraído");
		mensaje(usr);
		// Se muestran los datos de todos los usuarios
		mensaje("Se muestran los datos de todos los usuarios");
		/*
		 * Código alternativo usando un bucle foreach
		 */
		for (Usuario usuario: lUsr.getListaUsr()) {
			mensaje(usuario);
		}	
		
		// Se inserta un nuevo usuario en medio de los dos existentes
		mensaje("Se inserta un nuevo usuario al final de la lista");
		lUsr.addUsuario(new Usuario("Javier","Solís Lora","29001433C"));
		
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


