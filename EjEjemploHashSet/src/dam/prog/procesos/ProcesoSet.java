package dam.prog.procesos;

import java.util.HashSet;
import java.util.Iterator;

import dam.prog.beans.Usuario;

/**
 * Proceso que emplea HashSet
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class ProcesoSet {
	/**
	 * Ejecuta el proceso asociado al ejemplo de uso de HashSet
	 */
	public void ejecutar() {
		              
                // Se procesan DNI
                procesarDNI();
                
                // Se procesan usuarios
                procesarUsuarios();
	}
        /**
         * Proceso específico de DNI
         */
        private void procesarDNI() {
            HashSet<String> conjuntoDNI = new HashSet<String>();
            
            // Se insertan 3 DNI
            insertarVariosDNI(conjuntoDNI);
    
            // Se muestran todos los DNI
            mostrarLosDNI(conjuntoDNI);
            
            // Se busca el DNI 24781902T
            buscarDNI(conjuntoDNI,"24781902T");
        }
        /**
         * Se insertan 3 DNI.
         * @param conjuntoDNI El conjunto en el que se insertarán los 3 DNI
         */
        private void insertarVariosDNI(HashSet<String> conjuntoDNI) {
            mensaje("Se inserta 19226458E");
            conjuntoDNI.add("19226458E");
            mensaje("Se inserta 24781902T");
            conjuntoDNI.add("24781902T");
            mensaje("Se inserta 19226458E");
            conjuntoDNI.add("19226458E");
        }
    
        /**
         * Se listan los DNI almacenados en el conjunto proporcionado como parámetro
         * @param conjuntoDNI El conjunto de DNI, que son de tipo String
         */
        private void mostrarLosDNI(HashSet<String> conjuntoDNI) {
            Iterator<String> iterador = null;
            
            mensaje("Se listan los dni del conjunto:");
            
            mensaje("Con foreach, sin iterador");
            iterador = conjuntoDNI.iterator();
            
            // Con foreach, sin iterador
            for (String dni: conjuntoDNI) {
                    mensaje("DNI: "+dni);
            }
            
            mensaje ("Con forEach de Java 8");
            conjuntoDNI.forEach(System.out::println);
            
            mensaje ("Otra posibilidad con forEach de Java 8");
            conjuntoDNI.forEach(elemento->System.out.println("DNI: "+elemento));
            
            mensaje("Sin foreach, con iterador");
            // Sin foreach, con iterador
            while (iterador.hasNext()) {
                mensaje("DNI: "+iterador.next());
            }
        }
        
        /**
         * Busca un dni en el conjunto de DNI
         * @param conjuntoDNI
         * @param dni
         */
        private void buscarDNI(HashSet<String> conjuntoDNI, String dni) {
            if (conjuntoDNI.contains(dni))
                mensaje("El usuario con DNI "+dni+" pertenece al conjunto.");
            else
                mensaje("El usuario con DNI "+dni+" NO pertenece al conjunto.");
        }
        
        /**
         * Proceso específico de usuarios
         */
        private void procesarUsuarios() {
            HashSet<Usuario> conjuntoUsuarios = new HashSet<Usuario>();
            
            // Se insertan 4 usuarios
            insertarVariosUsuarios(conjuntoUsuarios);
            
            // Se muestran todos los usuarios del conjunto
            mostrarLosUsuarios(conjuntoUsuarios);
                    
            // Comprobar si un usuario pertenece al conjuntoUsuarios
            buscarUsuario(conjuntoUsuarios);
        }
        /**
         * Se insertan varios cuatro usuarios en el conjunto proporcionado como parámetro
         * @param conjuntoUsuarios El conjunto de usuarios
         */
        private void insertarVariosUsuarios(HashSet<Usuario> conjuntoUsuarios) {
            Usuario usuario = null;
            usuario = new Usuario("José","López Rodríguez","19226458E");
            mensaje("Se inserta "+usuario);
            conjuntoUsuarios.add(usuario);
            usuario = new Usuario("Francisco","Martín Luca","29226458J");
            mensaje("Se inserta "+usuario);
            conjuntoUsuarios.add(usuario);
            usuario = new Usuario("Ana","Viera Luján","24781902T");
            mensaje("Se inserta "+usuario);
            conjuntoUsuarios.add(usuario);
            mensaje("Se inserta "+usuario);
            conjuntoUsuarios.add(usuario);
        }
        
        /**
         * Muestra todos los usuarios almacenados en el conjunto que se proporciona como parámetro
         * @param conjuntoUsuarios El conjunto de usuarios
         */
        private void mostrarLosUsuarios(HashSet<Usuario> conjuntoUsuarios) {
            Iterator<Usuario> iterador = null;
           
            iterador = conjuntoUsuarios.iterator();
            
            mensaje("Se listan los usuarios del conjunto (Con iterador):");
            // Sin foreach, con iterador
            while (iterador.hasNext()) {
                mensaje("Usuario: "+iterador.next());
            }
            
            mensaje("Se listan los usuarios del conjunto (Con foreach clásico):");
            // Con foreach clásico
            for (Usuario usuario: conjuntoUsuarios) {
                    mensaje(usuario);
            }
            
            mensaje("Se listan los usuarios del conjunto (Con foreach Java 8):");
            // Con forEach de Java 8
            conjuntoUsuarios.forEach(elemento->System.out.println("Usuario, (dni): "+elemento.getDni()));            
        }
    
        /**
         * Proceso encargado de realizar la búsqueda de un usuario en el conjunto
         * @param conjuntoUsuarios
         */
        private void buscarUsuario(HashSet<Usuario> conjuntoUsuarios) {
            Usuario usuario = null;
            usuario = new Usuario("Francisco","Martín Luca","29226458J");
            if (conjuntoUsuarios.contains(usuario)) 
                    mensaje("El usuario con DNI "+usuario.getDni()+" pertenece al conjunto.");
            else
                    mensaje("El usuario con DNI "+usuario.getDni()+" NO pertenece al conjunto.");
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
