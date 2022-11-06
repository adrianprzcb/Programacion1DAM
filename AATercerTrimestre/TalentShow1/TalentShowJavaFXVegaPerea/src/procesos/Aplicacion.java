/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Artista;
import beans.Cantante;
import beans.Malabarista;
import beans.Musico;
import beans.Poeta;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marina
 */
public class Aplicacion implements Serializable {
    static ArrayList<Artista> artistas = new ArrayList();
    static int indiceActuaciones = 0;
    static ArrayList<String> nombres = new ArrayList<>();
    
    ArrayList<Artista> artistasObject = new ArrayList();
    int indiceActuacionesObject = 0;
    ArrayList<String> nombresObject = new ArrayList<>();
    
    public void prepararSerializacion(){
        this.artistasObject = artistas;
        this.indiceActuacionesObject = indiceActuaciones;
        this.nombresObject = nombres;
    }
    
    public void recuperarValoresEstaticos(){
        artistas = this.artistasObject;
        indiceActuaciones = this.indiceActuacionesObject;
        nombres = this.nombresObject;
    }
    
    public int getIndiceActuaciones(){
        return indiceActuaciones;
    }
    
    public int setSumaActuaciones(){
        return indiceActuaciones++;
    }
    
    public Artista getArtistaActual(){
        return artistas.get(indiceActuaciones);
    }
    
    public int getNumArtista(){
        int numArtista = artistas.size();
        
        return numArtista;
    }
    
    
    public String getSaludo() {
       
        return artistas.get(indiceActuaciones).saludar();
    }
    
    public String getActuacion() {
        
        return artistas.get(indiceActuaciones).actuar();
    }
    
    public String getDespedida() {
        
        return artistas.get(indiceActuaciones).despedirse();
    }
    
    
     /**
     * Crea un poeta
     */
    public void registroPoeta(String localidad, String nombre, int edad, String poema) {
        if(nombres.contains(nombre.toLowerCase())){
            JOptionPane.showMessageDialog(null, "El nombre introducido ya ha sido creado con anterioridad."); 
        }else{
            Poeta poeta = new Poeta(localidad, nombre, edad, poema);
            nombres.add(poeta.getNombre().toLowerCase());
            artistas.add(poeta);
            JOptionPane.showMessageDialog(null, "Ha registrado exitosamente el poeta.");
        }
        

    }
    
    /**
     * Crea un cantante
     */
    public void registroCantante(String localidad, String nombre, int edad, String tituloCancion) {
        if(nombres.contains(nombre.toLowerCase())){
            JOptionPane.showMessageDialog(null, "El nombre introducido ya ha sido creado con anterioridad."); 
        }else{
           Cantante cantante = new Cantante(localidad, nombre, edad, tituloCancion);
           nombres.add(cantante.getNombre().toLowerCase());
           artistas.add(cantante); 
           JOptionPane.showMessageDialog(null, "Ha registrado exitosamente el cantante.");
        }
        

    }
    
    /**
     * Crea un musico
     */
    public void registroMusico(String localidad, String nombre, int edad, String instrumento) {
        if(nombres.contains(nombre.toLowerCase())){
            JOptionPane.showMessageDialog(null, "El nombre introducido ya ha sido creado con anterioridad."); 
        }else{
            Musico musico = new Musico(localidad, nombre, edad, instrumento);
            nombres.add(musico.getNombre().toLowerCase());
            artistas.add(musico);
            JOptionPane.showMessageDialog(null, "Ha registrado exitosamente el musico.");
        }
        

    }
    
    /**
     * Crea un malabarista
     */
    public void registroMalabarista(String localidad, String nombre, int edad, int numObjeto, String nombreObjeto) {
        if(nombres.contains(nombre.toLowerCase())){
            JOptionPane.showMessageDialog(null, "El nombre introducido ya ha sido creado con anterioridad."); 
        }else{
            Malabarista malabarista = new Malabarista(localidad, nombre, edad, numObjeto, nombreObjeto);
            nombres.add(malabarista.getNombre().toLowerCase());
            artistas.add(malabarista);
            JOptionPane.showMessageDialog(null, "Ha registrado exitosamente el malabarista.");
        }
        

    }
    
    /**
     * Transmite el valor de la puntuacion al artista indicado del array artistas
     * @param puntuacion 
     */
    public void determinarPuntuacion(int puntuacion){
        artistas.get(indiceActuaciones).setPuntuacion(puntuacion);
    }
    
    /**
     * Ordena la clasificacion actual.
     */
    public String ordenarClasificacion() {
        String clasificacion = "";
        if (!artistas.isEmpty()) {
            
            artistas = ordenarArtistas();

            for (int i = 0; i < artistas.size(); i++) {
                clasificacion += "Puntuación de " + artistas.get(i).getNombre() + ": " + artistas.get(i).getPuntuacion()+ "\n";
            }
        } else {
            clasificacion = "No hay ningun artista registrado.";
        }

        return clasificacion;
    }
    
    /**
     * Ordena los artistas
     * @return devuleve el ArrayList ordenado de artistas.
     */
    private ArrayList<Artista> ordenarArtistas() {

        for (int i = 0; i < artistas.size(); i++) {
            for (int j = i + 1; j < artistas.size(); j++) {
                if (artistas.get(i).getPuntuacion() < artistas.get(j).getPuntuacion()) {
                    Collections.swap(artistas, i, j);
                }
            }
        }

        return artistas;
    }
    
    /**
     * Borra los artistas del arrayList artistas.
     */
    public void borrarArtistas(){
        artistas.clear();
    }
    
    /**
     * valida si todos los artistas han sido puntuados.
     * @return 
     */
    public boolean validadorClasificacionFinal(){
        boolean valido = false;
        for (int i = 0; i < artistas.size(); i++) {
            if(artistas.get(i).getPuntuacion() != 0){
                valido = true;
            }else{
                valido = false;
            }
        }
        return valido;
    }
}
