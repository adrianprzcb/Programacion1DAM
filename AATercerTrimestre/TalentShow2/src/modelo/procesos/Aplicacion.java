/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.procesos;

import Controlador.ControladorGeneral;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import modelo.Artista;

/**
 *
 * @author raulm
 */
public class Aplicacion implements Serializable {

    static ArrayList<Artista> artistasRegistrados;
    static ArrayList<Artista> artistasPuntuados;
    static HashSet<String> nombresArtistas;

    public Aplicacion() {

        artistasRegistrados = new ArrayList<>();
        artistasPuntuados = new ArrayList<>();
        nombresArtistas = new HashSet<>();
        

    }

    /**
     * Metodo que solicita los datos del artista al usuario y crea un objeto del
     * tipo de artista especificado
     */


    public ArrayList<Artista> getArtistasRegistrados() {
        return artistasRegistrados;
    }

    public ArrayList<Artista> getArtistasPuntuados() {
        return artistasPuntuados;
    }

    public HashSet<String> getNombresArtistas() {
        return nombresArtistas;
    }

    public static void setArtistasRegistrados(ArrayList<Artista> artistasRegistrados) {
        Aplicacion.artistasRegistrados = artistasRegistrados;
    }

    public static void setArtistasPuntuados(ArrayList<Artista> artistasPuntuados) {
        Aplicacion.artistasPuntuados = artistasPuntuados;
    }

    public static void setNombresArtistas(HashSet<String> nombresArtistas) {
        Aplicacion.nombresArtistas = nombresArtistas;
    }
    
    

}
