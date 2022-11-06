package dam.prog.beans;


/**
 * Bean que contiene los datos de un usuario
 * @author Eduardo A. Ponce
 * @version 1.0
 *
 */
public class Usuario {
	
        /**
         * Nombre del usuario
         */
        private String nombre = null;
        /**
         * Apellidos del usuario
         */
        private String apellidos = null;
        /**
         * DNI del usuario;
         */
        private String dni = null;
        

        
        /**
         * Constructor con parámetros de entrada para inicializar sus propiedades
         * @param nombre Nombre del usuario
         * @param apellidos Apellidos del usuario
         * @param dni DNI del usuario
         */
        public Usuario(String nombre, String apellidos, String dni) {
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.dni = dni;
        }
        /**
         * Obtiene el valor de nombre
         * @return El nombre
         */
        public String getNombre() {
                return nombre;
        }
        /**
         * Establece el valor de nombre
         * @param nombre El valor de nombre a establecer
         */
        public void setNombre(String nombre) {
                this.nombre = nombre;
        }
        /**
         * Obtiene el valor de apellidos
         * @return El apellidos
         */
        public String getApellidos() {
                return apellidos;
        }
        /**
         * Establece el valor de apellidos
         * @param apellidos El valor de apellidos a establecer
         */
        public void setApellidos(String apellidos) {
                this.apellidos = apellidos;
        }
        /**
         * Obtiene el valor de dni
         * @return El dni
         */
        public String getDni() {
                return dni;
        }
        /**
         * Establece el valor de dni
         * @param dni El valor de dni a establecer
         */
        public void setDni(String dni) {
                this.dni = dni;
        }
        
        /**
         * Convierte a cadena un objeto usuario
         * @return La cadena que representa al objeto usuario
         */
        public String toString() {
                return ("Nombre: "+nombre+"\nApellidos: "+apellidos+"\nDNI: "+dni);
        }
        
        /**
         * Implementación del método de comparación equals(), de manera que la comparación
         * se basa en los valores de dni, nombre y apellidos.
         * @param usr Objeto usuario con el que se desea comparar
         * @return true si ambos objetos representan al mismo usuario, true en caso contrario
         */
        public boolean equals(Object usr) {
                boolean iguales = false;
                System.out.println("Se emplea la comparación equals de Usuario"); // Este mensaje se elimina tras las pruebas
                
                if (usr != null && getClass() == usr.getClass()) {
                    Usuario usuario = (Usuario) usr;
                    if ( this.dni.equals(usuario.dni) &&
                         this.nombre.equals(usuario.nombre) &&
                         this.apellidos.equals(usuario.apellidos))
                                iguales = true;
                }
                return iguales;
        }
        
        /**
         * Implementación del método hashCode(). Este método es usado en las clases de tipo hash
         * para realizar las comparaciones. Este método identifica unívocamente cada objeto. Por defecto
         * se emplea un código que tiene como base la dirección de memoria de dicho objeto. En nuestro caso
         * lo sobreescribimos con el propósito de que este código indicador se base en el propio estado del
         * objeto. Para ello se obtiene un código hash a partir de la cadena resultante de la concatenación 
         * de dni, nombre y apellidos. 
         */
        public int hashCode() {
                System.out.println("Se emplea hashCode del objeto Usuario"); //Este mensaje se elimina tras las pruebas
                return (this.dni+this.nombre+this.apellidos).hashCode();
        }

}

