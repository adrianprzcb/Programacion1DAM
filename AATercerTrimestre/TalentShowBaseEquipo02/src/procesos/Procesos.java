/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Artista;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import vista.UtilidadesES;

/**
 *
 * @author bth
 */
public class Procesos {
    private final String LANZAR="LANZADO";
    private final String PARAR="PARADO";
    private final String FINALIZAR="FINALIZADO";
    private UtilidadesES util;
    private RegistroArtistas regArtista;
    private String estadoConcurso;
    private HashMap<String, Artista> listaConcursantes;
    private Serializar ser;
    private File saveArt;

    public Procesos(UtilidadesES util) {
        this.util = util;
        this.ser= new SerializarImpl();
        this.regArtista = new RegistroArtistasImpl(util);
        this.listaConcursantes=comprobarDatosGuardados();
        this.estadoConcurso= PARAR;
    }
    /**
     * Comprueba si exiten datos y carga el estado del juego
     * @author ana
     * @return listaArtistas devuelve un HashMap
     */
    private HashMap<String, Artista> comprobarDatosGuardados(){
        HashMap<String, Artista> listaArtistas=null;
        try {
            saveArt=new File("artistas.ser");
            if (saveArt.exists()) {
                listaArtistas= ser.leerArtistas();
                regArtista.setListaArtistas(listaArtistas);
            }else
                listaArtistas= new HashMap<>();
            
            return listaArtistas;
        } catch (IOException ioe) {
            System.out.println("Error en al cargar los datos guardados");
        }
         
        return listaArtistas;  
    }
    /**
     * Ejecuta el proceso correspondiente a la opcion introducida por el usuario
     * @author ana
     * @param opc recibe un numero entero 
     * @throws IOException si se produce un error en la toma de datos
     */
    public void ejecutarOpc(int opc) throws IOException {
        switch (opc) {
            case 1:registroDeArtistas();break;
            case 2:concurso();break;
            case 3:estadoConcurso();break;
            case 4:clasficacionActual();break;
            case 5:clasificacionFinal();break;
            case 6:iniciarNuevoConcurso();break;
            case 7:salir();break;
            default:opcNoValida();
        }
    }
    /**
     *Llama a los metodos de la clase clase registroUsuarios para la creacion de los artistas 
     * @author ana
     */
    private void registroDeArtistas() {
        String seleccion;
        Artista artista;
        try {
            if (estadoConcurso.equals(PARAR)) {
                seleccion = regArtista.seleccionarArtista();
                artista= regArtista.crearArtista(seleccion);
                comprobarYaddArtista(artista);
            }else System.out.println("No se puede ejecutar esta opcion en este momento. Estado del concurso: "+ estadoConcurso);
        } catch (IOException ioe) {
            System.out.println("Error en la toma de los datos");
        }
    }
    /**
     * Comprueba que la clave del artista no exista en el HashMap para añadir al artista
     * @author ana
     * @param artista recibe al artista
     */
    private void comprobarYaddArtista(Artista artista){
        if (!listaConcursantes.containsKey(artista.getNombre())) {
                listaConcursantes.put(artista.getNombre(), artista); 
        }else System.out.println("No se puede añadir, ya existe un artista con ese nombre"); 
    }
    
    /**
     * Ejecuta el concurso hasta que lo pare el usuario o participen todos los artistas
     * @author ana
     * @throws IOException si se produce un error en la toma de datos
     */
    private void concurso() throws IOException {
        boolean seguirConcurso = true;
        HashMap<String , Artista> participantes= new HashMap<>();
        
        if (estadoConcurso.equals(LANZAR)) {
            while (seguirConcurso) {  
                seguirConcurso = concursar(participantes);
            }
        }else System.out.println("No se puede ejecutar esta opcion en este momento. Estado del concurso: "+ estadoConcurso);
    }
    /**
     * Ejecuta el proceso asociado al concurso
     * @author ana
     * @return seguirConcurso false si se para el concurso , true si sigue con el siguiente artista
     * @throws IOException si se produce un error en la toma de datos
     */
    private boolean concursar(HashMap<String , Artista> participantes) throws IOException {
        boolean seguirConcurso;
        listaConcursantes = regArtista.getListaArtistas();
        participantes=artistasPorActuar(participantes);
        int contador = participantes.size();
        
        seguirConcurso= comprobarConcursantes(participantes);
        
        for (Map.Entry<String, Artista> artista : listaConcursantes.entrySet()) {
            if (participantes.containsKey(artista.getKey())&& artista.getValue().getPuntuacion()==0) {
                actuacionYpuntuacionArtista(artista.getValue());
                contador--;
                if (contador == 0) {return false;}
                seguirConcurso= siguienteArtista();
            }
            if (!seguirConcurso) {return seguirConcurso;}
        }
        return seguirConcurso;
    }
    /**
     * Añade a un nuevo HashMap los artistas que aun no han concursado
     * @author ana
     * @param map recibe el map al que se añadiran los artistas que no han concursado
     * @return map con los artistas por concursar
     */
    private HashMap<String , Artista> artistasPorActuar(HashMap<String , Artista> map){ 
        for (Map.Entry<String, Artista> artista : listaConcursantes.entrySet()) {
            if (artista.getValue().getPuntuacion()==0) {
                map.put(artista.getKey(), artista.getValue());
            }
        }
        return map;
    }
    /**
     * Comprueba que listaConcursantes no este vacia antes de actuar
     * @author ana
     * @return false si listaConcursantes o art esta vacia, true si contiene artistas. 
     */
    private boolean comprobarConcursantes(HashMap<String , Artista> art){
        if (listaConcursantes.isEmpty()) {
            System.out.println("No hay concursantes participando actualmente");
            return false;
        }else if(art.isEmpty()){
            System.out.println("Ya han concursado todos los participantes inscritos");
            return false;
        }else
            return true;
    }
    /**
     * Ejecuta los metodos de la clase artista y llama al metodo puntuarArtista()
     * @author ana
     * @param artista se recibe como parametro el artista que va a actuar
     * @throws IOException si hay un error en la toma de datos
     */
    private void actuacionYpuntuacionArtista(Artista artista) throws IOException{
        artista.saludar();
        artista.actuar();
        artista.despedirse();
        puntuarArtista(artista);
    }
    /**
     * Se encarga de comprobar que la puntuacion que se introduce para el artista es correcta
     * @author ana
     * @param artista que acaba de actuar y se la va a asignar la puntuacion
     * @throws IOException si se produce un error en la toma de datos
     */
    private void puntuarArtista(Artista artista) throws IOException{
        int puntuacion;
            
        do{
            puntuacion= util.pideNumero("Introduce una puntuacion para el artista: ");
            if (puntuacion<1 || puntuacion>12) {System.out.println("La puntuacion debe estar entre 1 y 12.\n");}
            artista.setPuntuacion(puntuacion);
        }while (puntuacion<1 || puntuacion>12);
        
    }
    /**
     * Comprueba si el siguiente artista actua o se vuelve al menu
     * @author ana
     * @return true si se continua con el siguiente artista, false si se vuelve al menu
     * @throws IOException si se produce un error en la toma de datos
     */
    private boolean siguienteArtista() throws IOException {
        boolean seguirConcurso=true;
        String cad;
        cad = util.pideCadena("\nContinuar con el siguiente artista?. Intro continuar, cualquier otra tecla para salir");
        if (!"".equals(cad)) {
            seguirConcurso=false;
        }
        return seguirConcurso;
    }
    /**
     * Llama al metodo mostrarEstado() y seleccionarEstado()
     * @author adrian
     * @throws IOException si se produce un error en la toma de datos
     */
    private void estadoConcurso() {
        try {
            mostrarEstado();
            seleccionarEstado();
        } catch (IOException ex) {
            System.out.println("Se ha producido un error al introducir los datos");
        }
    }
    /**
     * Muestra los estados del concurso
     * @author adrian
     */
    private void mostrarEstado(){
        System.out.println("--- Estados del concurso ---\n");
        System.out.println("1. Lanzar");
        System.out.println("2. Parar");
        System.out.println("3. Finalizar");
    }
    /**
     * Se encarga de asignar el estado del concurso
     * @author adrian
     * @throws IOException si se produce un error en la toma de datos
     */
    private void seleccionarEstado() throws IOException{
        int opc;
        opc= Integer.parseInt(util.pideCadena("Introduce una opcion: "));
        
        switch(opc){
            case 1: estadoConcurso=LANZAR; break;
            case 2: estadoConcurso=PARAR; break;
            case 3: estadoConcurso=FINALIZAR; break;
            default:System.out.println("La opcion introducida no es correcta. Volviendo al menu..");
        }
    }
    /**
     * Muestra la puntuacion de todos los artistas que han participado
     * @author adrian
     */
    private void clasficacionActual() {
        if (estadoConcurso.equals(LANZAR) || estadoConcurso.equals(PARAR)) {
            addArtistasList("actual");
        }else System.out.println("No se puede ejecutar esta opcion en este momento. Estado del concurso: "+ estadoConcurso);
        
    }
    /**
     * Muestra la puntuacion de todos los artistas
     * @author adrian
     */
    private void clasificacionFinal() {
        if (estadoConcurso.equals(FINALIZAR)) {
            addArtistasList("final");
        }else System.out.println("No se puede ejecutar esta opcion en este momento. Estado del concurso: "+ estadoConcurso);
    }
    /**
     * Añade los artistas del Map listaConcursantes a una lista dependiendo de la clasificacion
     * @author adrian
     */
    private void addArtistasList(String cad){
        List<Artista> clasificacion= new ArrayList<>();
        if (listaConcursantes.isEmpty()) {
            System.out.println("Aun no ha participado ningun concursante");
        }else{
            System.out.println("\n----Clasificacion "+cad+"----");
            for (Map.Entry<String, Artista> artista : listaConcursantes.entrySet()) {
                if (cad.equals("final")) {
                    clasificacion.add(artista.getValue());
                }
                if(cad.equals("actual")){
                    if (artista.getValue().getPuntuacion()!=0) {
                        clasificacion.add(artista.getValue());
                    }
                }
            }       
            mostrarClasificacionOrdenada(clasificacion);
        }
    }
    /**
     * Muestra la clasificacion ordenada descendentemente
     * @author adrian
     * @param lista lista de concursantes
     */
    private void mostrarClasificacionOrdenada(List<Artista> lista){
        Collections.sort(lista, Collections.reverseOrder());
        for (Artista artista : lista) {
            System.out.println("Nombre: "+artista.getNombre()+ " Puntuacion :"+ artista.getPuntuacion());
        }
    }
    /**
     * Este metodo se encarga de borrar todos los datos asociados al concurso anterior
     * @author ana
     */
    private void iniciarNuevoConcurso() {
        if(estadoConcurso.equals(FINALIZAR)){
            this.listaConcursantes=new HashMap<>();
            regArtista.setListaArtistas(new HashMap<>());
            saveArt.delete();
            estadoConcurso="PARAR";
            System.out.println("Iniciando nuevo concurso...");
        }else System.out.println("No se puede ejecutar esta opcion en este momento. Estado del concurso: "+ estadoConcurso);
    }
    
    /**
     * Almacena el HashMap listaConcursantes en un archivo y finaliza la ejecucion del programa
     * @author ana
     */
    private void salir() { 
        try {
            ser.guardarArtistas(listaConcursantes);
            System.out.println("Progreso guardado");
        } catch(IOException ioe){
            System.out.println("Error al guardar los datos");
        }finally{
            System.exit(0);
        }
    }
    /**
     * Muestra la opc por defecto del metodo ejecutar
     * @author ana
     */
    private void opcNoValida() {
        System.out.println("La opcion introducida no es valida.\n");
    }
}
