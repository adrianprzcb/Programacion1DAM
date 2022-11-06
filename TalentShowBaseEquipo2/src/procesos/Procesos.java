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
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author alumno
 */
public class Procesos {
     
       HashMap<String,Artista> artistas =new HashMap<>();
       HashMap<String,Artista> actuantes = new HashMap<String,Artista>();   
       Boolean PARADO = true;
       Boolean LANZADO = false;
       Boolean FINALIZADO = false;
       File archivoArtistas = new File("artistas.dat");
       File archivoActuantes = new File("actuantes.dat");
       Scanner sc = new Scanner(System.in);
        String nombre;
        int edad;
        int puntuacion;
        String localidad;
        int numeroEleccion;
        private Serializar ser;
        String tituloCancion;
        Artista artista;
        int numObjetos;
        String nombreObjeto;
        String poema;
        String instrumento;
            private File saveArt;
                private RegistroArtistas regArtista;
    private UtilidadesES util;



    public Procesos() {
     this.util = util;

        this.numeroEleccion = 0;
        this.ser = new SerializarImpl();
        this.artistas = comprobarDatosGuardados();
        regArtista = new RegistroArtistas(util);

    }
    
        private HashMap<String, Artista> comprobarDatosGuardados(){
        HashMap<String, Artista> listaArtistas=null;
        try {
            saveArt=new File("artistas.ser");
            if (saveArt.exists()) {
                artistas= ser.leerArtistas();
            }else
                artistas= new HashMap<>();
            
            return listaArtistas;
        } catch (IOException ioe) {
            System.out.println("Error en al cargar los datos guardados");
        }
         
        return listaArtistas;  
    }
        
        // OPCIÓN 1. REGISTRO DE ARTISTAS   
    void opcionUno() {
        if(PARADO){
           
            registroArtistas();

    }else{
            System.out.println("El concurso no está en PARADO, no se pueden añadir artistas.");
        }
    }
    
    
        private void registroArtistas() {
  String seleccion;
  try {
          seleccion = regArtista.seleccionarArtista();
         regArtista.crearArtista(seleccion);   
        } catch (IOException ioe) {
            System.out.println("Error en la toma de los datos");
         }
        
            
        
    }
    
    public void registroArtista() {
        
        System.out.println("¿Qué tipo de Artista quieres añadir?");
        System.out.println("(1)CANTANTE , (2) MALABARISTA , (3)MUSICO , (4) POETA , (5) SALIR");
     try{
          numeroEleccion = sc.nextInt();
           }catch(NumberFormatException e){
            System.out.println("Introduce sólo números.");
            numeroEleccion = 0;
        }catch(InputMismatchException e){
            System.out.println("Introduce sólo números.");
            numeroEleccion = 0;
            
        }
           switch (numeroEleccion) {
               case 1:
                   registroDatosGenerales();
                   registroCantante();
                   numeroEleccion = 0;
                   break;
               case 2:
                   registroDatosGenerales();
                   registroMalabarista();
                   numeroEleccion = 0;
                   break;
               case 3:
                   registroDatosGenerales();
                   registroMusico();
                   numeroEleccion = 0;
                   break;
               case 4:
                   registroDatosGenerales();
                   numeroEleccion = 0;
                   registroPoeta();
                   break;
               default:
                   System.out.println("Número no tiene opción.");
                   numeroEleccion = 0;
                   break;
           }
       
           
               
    }
   
    
    
    
    
    public void registroDatosGenerales() {
        System.out.println("Introduce el nombre:");
        nombre = sc.next();
        try{
        System.out.println("Introduce la edad (Debe ser mayor de 18 años):");
        edad = sc.nextInt();
        }catch(InputMismatchException e){
        System.out.println("¡Introduce un número para la edad!");
        }
        System.out.println("Introduce la localidad:");
        localidad = sc.next();        
    }
    
    

    public void registroCantante(){
        System.out.println("Introduce el nombre de la canción:");
        tituloCancion = sc.next();
        if(nombre!=null && edad>17 && localidad!= null && tituloCancion!=null){
        artista = new Cantante(nombre, edad, localidad ,tituloCancion);
        artistas.put(artista.getNombre(), artista);
        actuantes.put(nombre, artista);}
        else{
            System.out.println("Datos mal introducidos");
        }
        
    }
        

    public void registroMalabarista(){
        System.out.println("Introduce el nombre del objeto:");
        nombreObjeto = sc.next();
        System.out.println("Introduce el numero objetos:");
        numObjetos = sc.nextInt();
          if(nombre!=null && edad>17 && localidad!= null && nombreObjeto!=null && numObjetos <1){
        artista = new Malabarista(nombre, edad, localidad ,numObjetos, nombreObjeto);
        artistas.put(nombre, artista);
        actuantes.put(nombre, artista);

        
    }else{
                          System.out.println("Datos mal introducidos");

          }
    }
    
    public void registroMusico(){
        System.out.println("Introduce el nombre del instrumento:");
        instrumento = sc.next();
        if(nombre!=null && edad>17 && localidad!= null && instrumento!=null){
        artista = new Musico(nombre, edad, localidad ,instrumento);
        artistas.put(nombre, artista);
                actuantes.put(nombre, artista);
        }else{
                        System.out.println("Datos mal introducidos");

        }
        
    }
  
    public void registroPoeta(){
        System.out.println("Introduce el nombre del poema:");
        poema = sc.next();
        if(nombre!=null && edad>17 && localidad!= null && poema!=null){
        artista = new Poeta(nombre, edad, localidad ,poema);
        artistas.put(nombre, artista);
                actuantes.put(nombre, artista);
        }else{
         System.out.println("Datos mal introducidos");
        }
}
    
    
 
    
    void opcionDos() {

      if(LANZADO){
         Scanner sc = new Scanner(System.in);
        System.out.println("CONCURSO -----");
           for (String i : actuantes.keySet()) {
            System.out.println(actuantes.get(i).saludar());
            System.out.println(actuantes.get(i).actuar());
            System.out.println(actuantes.get(i).despedirse());
            System.out.println("Introduce la puntuación:");
            try{
            puntuacion = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("¡Introduce un número para la puntuación!");
        }
            actuantes.get(i).setPuntuacion(puntuacion);
           System.out.println("----- -----");
           //actuantes.remove(i);
           
           
            }
           
                 System.out.println("CONCURSO ACABADO");

      }
      
    else{
     System.out.println("El concurso no está en LANZADO, no se puede concursar.");

      }

}
    


    void opcionTres() {
        if(PARADO){
            PARADO=false;
            LANZADO=true;
            System.out.println("APLICACIÓN EN: LANZADO");
        }else if(LANZADO){
            LANZADO=false;
            FINALIZADO=true;
            System.out.println("APLICACIÓN EN: FINALIZADO");

        }else{
            FINALIZADO=false;
            PARADO=true;
            System.out.println("APLICACIÓN EN: PARADO");

        }
    }
    
    
    
    
    
    void opcionCuatro(){

        if(LANZADO || PARADO){
        addArtistasList();      
    }else{
   System.out.println("El concurso no está ni en LANZADO ni en PARADO, no se puede ver la clasificación actual.");

        }
    }
    
       void opcionCinco(){

        if(FINALIZADO){
        addArtistasList();      
    }else{
   System.out.println("El concurso no está en FINALIZADO, no se puede ver la clasificación FINAL.");

        }
    }
    
        private void addArtistasList(){
        List<Artista> clasificacionActual= new ArrayList<>();
        if (artistas.isEmpty()) {
            System.out.println("Aun no ha participado ningun concursante");
        }else{
            for (Map.Entry<String, Artista> artista : artistas.entrySet()) {
                clasificacionActual.add(artista.getValue());
            }       
            mostrarClasificacionOrdenada(clasificacionActual);
        }
    }
  
    private void mostrarClasificacionOrdenada(List<Artista> lista){
        Collections.sort(lista, Collections.reverseOrder());
        for (Artista artista : lista) {
            System.out.println("Nombre: "+artista.getNombre()+ " Puntuacion :"+ artista.getPuntuacion());
        }
    }
    
        public void opcionSeis() {
            if(FINALIZADO){
artistas.clear();
actuantes.clear();
   }else{
            System.out.println("No está en finalizado");
        }
    }
        
    public void salir() throws IOException{
        if(FINALIZADO){
               try {
            ser.guardarArtistas(artistas);    
        } catch(IOException ioe){
            System.out.println("Error al guardar los datos");
        }finally{
            System.out.println("Progreso guardado");
            System.exit(0);
        }

    }
    }
 
            
     
    
    
    
}