package patrones;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Proporciona soporte para entrada y salida estándar
 * orientadas a carácter empleando patrón Singleton, inicializando
 * la instancia en la propia declaración de ésta.
 * @author Eduardo A. Ponce
 * @version 3.0
 */
public final class BeanESv3 {
    /**
     * Flujo de entrada
     */
    private BufferedReader flujoEntrada = null;
    /**
     * Flujo de salida
     */
    private PrintStream flujoSalida = null;

    // Propiedades propias del patrón Singleton
    
    /**
     * Indicador de instancia creada
     */
    private static boolean creado = false;
    /**
     * Objeto que representa a la instancia singleton
     */
    private static BeanESv3 instanciaBeanESv3 = new BeanESv3();
    /**
     * Constructor privado, sólo empleado al cargar la clase.
     */
    private BeanESv3() {
        this.flujoEntrada = new BufferedReader (new InputStreamReader(System.in));
        this.flujoSalida = System.out;
    }
    /**
     * Devuelve la instancia del patrón Singleton. Si no existía lo crea, y si existe,
     * la devuelve.
     * @return Instancia del bean singleton de ES
     */
    public static BeanESv3 getBeanESv3() {
        return BeanESv3.instanciaBeanESv3;
    }
    
    /**
     * Con este método se evita poder clonar un objeto de este tipo, lo que
     * supondría que habría dos instancias de esta misma clase.
     * @return Objeto clonado, aunque nunca se devolverá realmente.
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    /**
     * Muestra un mensaje por el flujo de salida
     * @param cadena Mensaje que se mostrar�
     */
    public void mostrar(String cadena) {
                    flujoSalida.print(cadena);
    }
    /**
     * Muestra un mensaje por el flujo de salida
     * con salto de l�nea
     * @param cadena Mensaje que se mostrar�
     */
    public void mostrarln(String cadena) {
            mostrar(cadena+"\n");
    }
    /**
     * Muestra un objeto por el flujo de salida
     * con salto de l�nea
     * @param cadena Mensaje que se mostrar�
     */
    public void mostrarln(Object objeto) {
            mostrar(objeto+"\n");
    }       
    /**
     * Pide una cadena desde el flujo de entrada mostrando previamente
     * un mensaje.
     * @param mensaje Mensaje que se muestra
     * @return Cadena leída
     * @throws IOException Error en lectura de datos desde flujo entrada.
     */
    public String pideCadena(String mensaje) throws IOException{
            String respuesta = null;
            mostrar(mensaje);
            try {
                    respuesta = flujoEntrada.readLine();
            }
            catch(IOException ioe) {
                    throw new IOException("Error al leer de teclado en pideCadena()",ioe);
            }
            return respuesta;
    }
}
