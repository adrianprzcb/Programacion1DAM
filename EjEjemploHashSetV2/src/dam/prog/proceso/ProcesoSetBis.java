package dam.prog.proceso;

import dam.prog.beans.ConjuntoDNI;
import dam.prog.beans.ConjuntoUsuarios;
import dam.prog.beans.Usuario;

import java.util.HashSet;

/**
 * Proceso que emplea HashSet
 * @author Eduardo A. Ponce
 * @version 1.0
 */
public class ProcesoSetBis {
    // Propiedades
    /**
     * Representa el flujo de salida que se empleará
     */
    IO flujoSalida = new IO();
    
    // Constructores
    /**
     * Constructor sin par�metros
     */
    public ProcesoSetBis() {
        super();
    }
    
    // Procesos
    /**
     * Ejecuta el proceso asociado al ejemplo de uso de ArrayList
     */
    public void ejecutar() {
                          
            // Se procesan DNI
            procesarDNI();
            
            // Se procesan usuarios
            procesarUsuarios();
    }
    /**
     * Procesamiento específico de DNI.
     */
    private void procesarDNI() {
        ConjuntoDNI conjuntoDNI = new ConjuntoDNI();
        
        // Se insertan 3 DNI
        insertarVariosDNI(conjuntoDNI);
    
        // Se muestran todos los DNI
        mostrar(conjuntoDNI,"Listado completo de DNI");
        
        if (buscarDNI(conjuntoDNI, "19226456E"))
            flujoSalida.mensaje("El usuario con dni 19226458E, existe.");
        else
            flujoSalida.mensaje("El usuario con dni 19226458E, NO existe.");
    }
    /**
     * Se insertan 3 DNI.
     * @param conjuntoDNI El conjunto en el que se insertarán los 3 DNI
     */
    private void insertarVariosDNI(ConjuntoDNI conjuntoDNI) {
        flujoSalida.mensaje("Se inserta 19226458E");
        conjuntoDNI.add("19226458E");
        flujoSalida.mensaje("Se inserta 24781902T");
        conjuntoDNI.add("24781902T");
        flujoSalida.mensaje("Se inserta 19226458E");
        conjuntoDNI.add("19226458E");
    }
    /**
     * Procesamiento específico de usuarios
     */
    private void procesarUsuarios() {
        ConjuntoUsuarios conjuntoUsuarios = new ConjuntoUsuarios();
        
        // Se insertan 4 usuarios
        insertarVariosUsuarios(conjuntoUsuarios);
        
        // Se muestran todos los usuarios del conjunto
        mostrar(conjuntoUsuarios, "Se listan los usuarios del conjunto:");
                
        // Comprobar si un usuario pertenece al conjuntoUsuarios
        buscarUsuario(conjuntoUsuarios);
    }
    private boolean buscarDNI(ConjuntoDNI conjuntoDNI, String dni) {
        if (conjuntoDNI.existe(dni))
            return true;
        else return false;
    }
    /**
     * Se insertan 4 usuarios, dos de ellos son iguales.
     * @param conjuntoUsuarios Conjunto de tipo Usuario.
     */
    private void insertarVariosUsuarios(ConjuntoUsuarios conjuntoUsuarios) {
        Usuario usuario = null;
        usuario = new Usuario("José","López Rodríguez","19226458E");
        flujoSalida.mensaje("Se inserta "+usuario);
        conjuntoUsuarios.add(usuario);
        usuario = new Usuario("Francisco","Martín Luca","29226458J");
        flujoSalida.mensaje("Se inserta "+usuario);
        conjuntoUsuarios.add(usuario);
        usuario = new Usuario("Ana","Viera Luján","24781902T");
        flujoSalida.mensaje("Se inserta "+usuario);
        conjuntoUsuarios.add(usuario);
        flujoSalida.mensaje("Se inserta "+usuario);
        conjuntoUsuarios.add(usuario);
    }
    /**
     * Proceso que buscará un usuario dentro del conjunto
     * @param conjuntoUsuarios Conjunto de tipo Usuario
     */
    private void buscarUsuario(ConjuntoUsuarios conjuntoUsuarios) {
        Usuario usuario = new Usuario("Francisco","Martín Luca","29226458J");
        if (conjuntoUsuarios.contiene(usuario))
            
        //if (conjuntoUsuarios.contains((Usuario)usr)) 
                flujoSalida.mensaje("El usuario con DNI "+usuario.getDni()+" pertenece al conjunto.");
        else
                flujoSalida.mensaje("El usuario con DNI "+usuario.getDni()+" NO pertenece al conjunto.");
    }
    /**
     * Muestra el contenido de un conjunto basándose en el método toString() implementado en la clase del 
     * tipo de objeto del conjunto.
     * @param conjunto Conjunto de objetos a mostrar.
     * @param mensaje Frase que se muestra antes de visualizar los datos de los objetos.
     */
    private void mostrar(HashSet conjunto, String mensaje) {
        flujoSalida.mensaje(mensaje);
        for (Object elemento: conjunto)
            flujoSalida.mensaje(elemento);
    }
}
