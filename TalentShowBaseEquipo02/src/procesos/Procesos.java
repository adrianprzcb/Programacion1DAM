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
    private final String LANZAR="LANZAR";
    private final String PARAR="PARAR";
    private final String FINALIZAR="FINALIZAR";
    private UtilidadesES util;
    private RegistroArtistas regArtista;
    private String estadoConcurso;
    private HashMap<String, Artista> listaConcursantes;
    private Serializar ser;
    private File saveArt;

    public Procesos(UtilidadesES util) {
        this.util = util;
        this.ser= new SerializarImpl();
        this.regArtista = new RegistroArtistas(util);
        this.listaConcursantes=comprobarDatosGuardados();
        this.estadoConcurso= PARAR;
    }
    /**
     * Comprueba si exiten datos y carga el estado del juego
     * @return listaArtistas 
     */
    private HashMap<String, Artista> comprobarDatosGuardados(){
        HashMap<String, Artista> listaArtistas=null;
        try {
            saveArt=new File("artistas.ser");
            if (saveArt.exists()) {
                listaArtistas= ser.leerArtistas();
            }else
                listaArtistas= new HashMap<>();
            
            return listaArtistas;
        } catch (IOException ioe) {
            System.out.println("Error en al cargar los datos guardados");
        }
         
        return listaArtistas;  
    }
    /**
     * 
     * @param opc
     * @throws IOException 
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
            case 8:d();break;//listar Hash
            default:opcNoValida();
        }
    }
    /*
    * Llama al clase registroUsuarios para la creacion de los artistas 
     */
    private void registroDeArtistas() {
        System.out.println(estadoConcurso);
        String seleccion;
        try {
            if (estadoConcurso.equals(PARAR)) {
                seleccion = regArtista.seleccionarArtista();
                regArtista.crearArtista(seleccion);
            }else System.out.println("No se puede ejecutar esta opcion en este momento");
        } catch (IOException ioe) {
            System.out.println("Error en la toma de los datos");
        }
    }
    /*
    * Ejecuta el concurso hasta que lo pare el usuario 
     */
    private void concurso() throws IOException {
        boolean seguirConcurso = true;
        if (estadoConcurso.equals(LANZAR)) {
            while (seguirConcurso) {
                seguirConcurso = concursar();
            }
        }else System.out.println("No se puede ejecutar esta opcion en este momento");
            
        
    }
    /**
     * 
     * @return
     * @throws IOException 
     */
    private boolean concursar() throws IOException {
        listaConcursantes = regArtista.getListaArtistas();
        boolean seguirConcurso = true;
        int contador = listaConcursantes.size();

        seguirConcurso= comprobarConcursantes();
        for (Map.Entry<String, Artista> artista : listaConcursantes.entrySet()) {
            actuacionYpuntuacionArtista(artista.getValue());
            contador--;
            if (contador == 0) {return false;}
            else{seguirConcurso= siguienteArtista();
                if (!seguirConcurso) {return seguirConcurso;}
            }   
        }
        return seguirConcurso;
    }
    
    private boolean comprobarConcursantes(){
        if (listaConcursantes.size() < 1) {
            System.out.println("No hay concursantes participando actualmente");
            return false;
        }else
            return true;
    }
    /**
     * 
     * @param artista
     * @throws IOException 
     */
    private void actuacionYpuntuacionArtista(Artista artista) throws IOException{
            artista.saludar();
            artista.actuar();
            artista.despedirse();
            puntuarArtista(artista);
    }
    /**
     * 
     * @param artista
     * @throws IOException 
     */
    private void puntuarArtista(Artista artista) throws IOException{
        int puntuacion;
        puntuacion= Integer.parseInt(util.pideCadena("Introduce una puntuacion para el artista: "));
        artista.setPuntuacion(puntuacion);
    }
    /**
     * 
     * @return
     * @throws IOException 
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
     * 
     */
    private void estadoConcurso() {
        try {
            mostrarEstado();
            seleccionarEstado();
        } catch (IOException ex) {
            System.out.println("Se ha producido un error al introducir los datos");
        }
    }
    private void mostrarEstado(){
        System.out.println("1. Lanzar");
        System.out.println("2. Parar");
        System.out.println("3. Finalizar");
    }
    
    private void seleccionarEstado() throws IOException{
        int opc;
        opc= Integer.parseInt(util.pideCadena("Introduce una opcion: "));
        
        switch(opc){
            case 1: estadoConcurso="LANZAR"; break;
            case 2: estadoConcurso="PARAR"; break;
            case 3: estadoConcurso="FINALIZAR"; break;
            default:System.out.println("Introduce una opcion correcta");
        }
    }
    /**
     * 
     */
    private void clasficacionActual() {
        if (estadoConcurso.equals(LANZAR) || estadoConcurso.equals(PARAR)) {
            addArtistasList();
        }else System.out.println("No se puede ejecutar esta opcion en este momento");
        
    }
    private void clasificacionFinal() {
        if (estadoConcurso.equals(FINALIZAR)) {
            addArtistasList();
        }else System.out.println("No se puede ejecutar esta opcion en este momento");
    }
    /**
     * 
     */
    private void addArtistasList(){
        List<Artista> clasificacionActual= new ArrayList<>();
        if (listaConcursantes.isEmpty()) {
            System.out.println("Aun no ha participado ningun concursante");
        }else{
            for (Map.Entry<String, Artista> artista : listaConcursantes.entrySet()) {
                clasificacionActual.add(artista.getValue());
            }       
            mostrarClasificacionOrdenada(clasificacionActual);
        }
    }
    /**
     * 
     * @param lista 
     */
    private void mostrarClasificacionOrdenada(List<Artista> lista){
        Collections.sort(lista, Collections.reverseOrder());
        for (Artista artista : lista) {
            System.out.println("Nombre: "+artista.getNombre()+ " Puntuacion :"+ artista.getPuntuacion());
        }
    }
    /*
    * Este método se encarga de borrar todos los datos asociados al concurso anterior.
    */
    private void iniciarNuevoConcurso() {
        if(estadoConcurso.equals(FINALIZAR)){
            this.listaConcursantes=new HashMap<>();
            saveArt.delete();
            System.out.println("Iniciando nuevo concurso...");
        }else System.out.println("No se puede ejecutar esta opcion en este momento");
    }
    /**
     * Guarda el HashMap listaConcursantes en un archivo.
     */
    private void salir() { 
        try {
            ser.guardarArtistas(listaConcursantes);    
        } catch(IOException ioe){
            System.out.println("Error al guardar los datos");
        }finally{
            System.out.println("Progreso guardado");
            System.exit(0);
        }
    }
    /**
    *Muestra la opcion default del metodo ejecutarOpc(). 
    */
    private void opcNoValida() {
        System.out.println("La opcion introducida no es valida.\n");
    }
    
    /***BORRAR :Metodo de prueba para listar array*/
    private void d(){
        for (Map.Entry<String, Artista> entry : listaConcursantes.entrySet()) {
            System.out.println("\n"+entry.toString());
        }
    }
}
