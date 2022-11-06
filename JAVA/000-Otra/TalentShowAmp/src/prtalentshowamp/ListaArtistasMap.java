package prtalentshowamp;


import java.util.TreeMap;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.Collections;
import java.util.Map;


public class ListaArtistasMap {
    /**Instanciacion de variables **/
    HashMap<String,Artista> listaArtistas = new HashMap<String,Artista>();
    /** Map que esta ordenado ya de mayor a menor **/
    SortedMap<Integer,Artista> listanotas = new TreeMap<Integer,Artista>(Collections.reverseOrder());
    Jurado jurado = new Jurado();
    /** Constructor por defecto **/
    
    public ListaArtistasMap(){
        
    }
    /**Metodo que añade un artista al Map
     * set @key and @artista
     * **/
    public void putArtista(String idArtista,Artista artista){
        listaArtistas.put(idArtista, artista);
    }
    
    public void putNota(int nota,Artista artista){
        listanotas.put(nota, artista);
    }
    /**Metodo que lista todos los artistas mediante un artista
     * @foreach
     * sysotln @key and @value
     * **/
    public void listarArtistas(){
        if (listaArtistas.isEmpty()){
            System.out.println("El contenedor esta vacio.Agregue artistas antes por favor (Opcion1)."+"\n");
        } else {
            listaArtistas.forEach((k,v) -> System.out.println("Identificador: "+k+ " Artista: "+v));
        }
    }
    /**Metodo que muestra el valor del objeto incluido por el HashMap dado el identificador
     * Si existe @key, sysoutpln @value
     * sino @sysoutln mensaje 
     * */
    public void mostrarArtistaEspecifico(String IdArtista){
        if (listaArtistas.containsKey(IdArtista))
        System.out.println(listaArtistas.get(IdArtista));
        else {
            System.out.println("No existe ningun artista para el ID dado"+"\n");
        }
    }
    /**Metodo que hace que todos los artistas dentro del map actuen y se agreguen a un contenedor de notas
     * @value.actuar()
     * **/
    public void actuacionArtistas(){
        if (listaArtistas.isEmpty()){
            System.out.println("El contenedor esta vacio.Agregue artistas antes por favor(Opcion 1)."+"\n");
        } else {
            listaArtistas.forEach((k,v) -> v.actuar());
            agregarNotas();
        }
    }
    /**Metodo que almacena los artistas segun la nota en un contenedor  de tipo Map
     * **/
    public void agregarNotas(){
        listaArtistas.forEach((k,v) -> listanotas.put(jurado.evaluar(),v));
    }
    /**Metodo que muestra en pantalla todos los elementos del Map listanotas y comprueba si esta vacio o no **/
    public void mostrarNotas(){
        if (listanotas.isEmpty()){
            System.out.println("Los artistas no han actuado aun. Porfavor, pulse la opcion 3 antes.");
        } else {
        listanotas.forEach((k,v) -> System.out.println("Nota: "+k+" Artista: "+v));
      //  listanotas.clear();
        }
    }
}
