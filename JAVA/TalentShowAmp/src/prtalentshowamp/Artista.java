package prtalentshowamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import packageutilidadeses.UtilidadesES;

public abstract class Artista implements Serializable{
    /** Instancion de variables **/
    private String nombre;
    private int edad;
    private String actuacion;
    private String IdArtista;
    transient UtilidadesES ues = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
    transient Jurado jurado = new Jurado();
    //transient ListaNotas listanotas = new ListaNotas();
    /** Constructor de Artista
     *  set @nombre, @edad and @actuacion dados como argumento
     ***/
    public Artista(String nombre,int edad,String actuacion,String IdArtista){
        this.nombre = nombre;
        this.edad = edad;
        this.actuacion = actuacion;
        this.IdArtista = IdArtista;
    }
    /**Constructor de Artista **/
    public Artista(){
    }
    /**Metodo getter de IdArtista
     * return @idArtista
     * **/
    public String getIdArtista() {
        return IdArtista;
    }
    /**Metodo setter de nombre,edad,actuacion
     * set @nombre
     * set @edad
     * set @actuacion
     * set @IdArtista
     * **/
    public void creacionArtista(){
        try {
            IdArtista = ues.pideCadena("Introduzca el ID del artista a crear");
            edad = Integer.parseInt(ues.pideCadena("Introduzca la edad del artista a crear"));
            nombre = ues.pideCadena("Introduzca el nombre del artista a crear");
            actuacion = ues.pideCadena("Introduzca la actuacion del artista a crear"+"\n");
            
        } catch (IOException ioe){
            ues.mostrarln("Error en la toma de datos de artista.");
               } catch (NumberFormatException nfe){
                   ues.mostrarln("El tipo de dato que ha introducido no es numerico.");
               }
}   /**Metodo que muestra el valor actuacion del artista
     * sysoutpln @actuacion
     * **/
    public void actuar(){
        System.out.println(actuacion);
    }
    /**Metodo que sobreescribe toString, el cual muestra @nombre y @edad
     * @Override
     * sysoutpln @nombre @edad**/
    public String toString(){
        return "Soy "+nombre+" y tengo "+edad+"\n";
    }
}
