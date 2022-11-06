package modelo;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Tipo de artista "Cantante" que extiende de la clase Padre Artista
 * @author Adrian Ramos Colon
 */
public class Cantante extends Artista {

    

    
    /**
     * Constructor de la clase Cantante
     * @param nombre
     * @param apellidos
     * @param localidad
     * @param edad 
     */
    public Cantante(String nombre, String apellidos, String localidad, int edad, String actuacion, String tipo) {
        super(nombre, apellidos, localidad, edad, actuacion,tipo);
        
    }
        
    
    /**
     * Metodo que anula el metodo de la clase Padre y que desarrolla la actuacion del Cantante
     * @throws java.lang.InterruptedException Se lanza cuando la ejecucion ha sido interrumpida
     * @throws java.lang.NullPointerException Se lanza cuando el artista que se pasa por parametro es nulo 
     * @throws javax.sound.sampled.LineUnavailableException Se lanza cuandoel flujo de audio no se puede abrir 
     * @throws javax.sound.sampled.UnsupportedAudioFileException Se lanza cuando el archivo de audio no es compatible
     * @throws java.io.IOException Se lanza cuando una IOException ocurre
     * @param artista 
     */
    public void actuar(Artista artista) throws NullPointerException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException{
        
        
    }
}
