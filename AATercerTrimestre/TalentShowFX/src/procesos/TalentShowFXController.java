/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package procesos;

import beans.Artista;
import beans.Cantante;
import beans.Malabarista;
import beans.Musico;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Usuario
 */
public class TalentShowFXController implements Initializable {
    
    @FXML
    private Button btnAnadirArtistas;

    @FXML
    private Label label;

    @FXML
    private Button btnConcursar;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnClasAct;

    @FXML
    private Button btnClasFinal;

    @FXML
    private Button btnIniciarNuevoConc;
    
    @FXML
    private RadioButton radioparado;

    @FXML
    private RadioButton radiofinalizado;

    @FXML
    private RadioButton radioiniciado;
    
      @FXML
    private ToggleGroup estado;
      
      
        @FXML
    private ToggleGroup artistas;
      
       @FXML
    private RadioButton chCantante;

    @FXML
    private RadioButton chMalabarista;

    @FXML
    private RadioButton chMusico;

    @FXML
    private RadioButton chPoeta;
    
     @FXML
    private TextArea labell;

        @FXML
    private TextField nombre;

    @FXML
    private TextField edad;

    @FXML
    private TextField localidad;

    @FXML
    private TextField melodia;

    @FXML
    private TextField poema;

    @FXML
    private TextField instrumento;

    @FXML
    private TextField numObjetos;

    @FXML
    private TextField objeto;
    
    @FXML
    private Button btnCreaArtista;
    
     @FXML
    private TextArea labelConcurso;

    @FXML
    private TextField textPuntos;

    @FXML
    private Button btnPuntuar;
    
    
    private HashMap<String, Artista> listaConcursantes;
    private Serializar ser;
    private File saveArt;
    
     private HashMap<String, Artista> comprobarDatosGuardados(){
        HashMap<String, Artista> listaArtistas=null;
        try {
            saveArt=new File("artistas.ser");
            if (saveArt.exists()) {
                listaArtistas= ser.leerArtistas();
                listaConcursantes = listaArtistas;
            }else
                listaArtistas= new HashMap<>();
            
            return listaArtistas;
        } catch (IOException ioe) {
            System.out.println("Error en al cargar los datos guardados");
        }
         
        return listaArtistas;  
    }

    @FXML
    void anadirArtistas(ActionEvent event) {
        quitarConcurso();
        if(radioparado.isSelected()){
        chCantante.setVisible(true);
        chMusico.setVisible(true);
        chPoeta.setVisible(true);
        chMalabarista.setVisible(true);
       labell.setText("");
        }else{
            
           labell.setText("El concurso debe estar en Parado para ejecutar esta opción");
        }
    }

    @FXML
    void anadirCantante(ActionEvent event) {
       btnCreaArtista.setVisible(true);
     nombre.setVisible(true);
     edad.setVisible(true);
     localidad.setVisible(true);
     melodia.setVisible(true);
     poema.setVisible(false);
     instrumento.setVisible(false);
     numObjetos.setVisible(false);        
     objeto.setVisible(false);

    }

    @FXML
    void anadirMalabarista(ActionEvent event) {
    btnCreaArtista.setVisible(true);
    nombre.setVisible(true);
     edad.setVisible(true);
     localidad.setVisible(true);
     melodia.setVisible(false);
     poema.setVisible(false);
     instrumento.setVisible(false);
     numObjetos.setVisible(true);        
     objeto.setVisible(true);
    }

    @FXML
    void anadirMusico(ActionEvent event) {
     btnCreaArtista.setVisible(true);
     nombre.setVisible(true);
     edad.setVisible(true);
     localidad.setVisible(true);
     melodia.setVisible(true);
     poema.setVisible(false);
     instrumento.setVisible(true);
     numObjetos.setVisible(false);        
     objeto.setVisible(false);
    }

    @FXML
    void anadirPoeta(ActionEvent event) {
    btnCreaArtista.setVisible(true);
     nombre.setVisible(true);
     edad.setVisible(true);
     localidad.setVisible(true);
     melodia.setVisible(false);
     poema.setVisible(true);
     instrumento.setVisible(false);
     numObjetos.setVisible(false);        
     objeto.setVisible(false);
    }
    
    
     @FXML
    void crearArtista(ActionEvent event) {
        if(chCantante.isSelected()){
            creaCantante();
        }
        else if (chMusico.isSelected()){
            creaMusico();
         }
        else if(chMalabarista.isSelected()){
            creaMalabarista();
        }
        else if(chPoeta.isSelected()){
            creaPoeta();
        }
    }
    
     private void creaCantante() {
      String nombreA = nombre.getText();
      int edadA = 0;
      try{
      edadA = Integer.parseInt(edad.getText());
      }catch(NumberFormatException e){
          labell.setText("Introduce un número en la edad");
      }
     String localidadA = localidad.getText();
     String melodiaA = melodia.getText();
     
     if(nombreA.isEmpty()){
      labell.setText("Introduce un nombre");
     }
     else if(localidadA.isEmpty()){
      labell.setText("Introduce una localidad");
     }
     else if(melodiaA.isEmpty()){
       labell.setText("Introduce una melodia");
       
     }else if(edadA<18){
         labell.setText("Introduce una edad de más de 17.");
     }else{
        crearCantante(nombreA, edadA, localidadA, melodiaA);
     }
    }
     
      public void crearCantante(String nombre, int edad, String localidad, String melodia){
                  Artista artista;
                  artista = new Cantante(nombre, edad,localidad, melodia);
                   if (!listaConcursantes.containsKey(artista.getNombre())) {
                  listaConcursantes.put(nombre, artista);
                  labell.setText("Cantante añadido con exito");

            }else{
             labell.setText("Ya existe un arista con ese nombre");
     
                   }
          
      }
     
     
     
     private void creaMusico(){
     String nombreA = nombre.getText();
     int edadA = 0;
      try{
      edadA = Integer.parseInt(edad.getText());
      }catch(NumberFormatException e){
          labell.setText("Introduce un número en la edad");
      }
     String localidadA = localidad.getText();
     String melodiaA = melodia.getText();
     String instrumentoA = instrumento.getText();
     
         if(nombreA.isEmpty()){
      labell.setText("Introduce un nombre");
     }
     else if(localidadA.isEmpty()){
      labell.setText("Introduce una localidad");
     } else if(melodiaA.isEmpty()){
       labell.setText("Introduce una melodia");
       
     }else if(instrumentoA.isEmpty()){
     labell.setText("Introduce un instrumento");
     }else if(edadA<18){
         labell.setText("Introduce una edad de más de 17.");
     }else{
        crearMusico(nombreA, edadA, localidadA,instrumentoA, melodiaA);
     }
     }
     
        public void crearMusico(String nombre, int edad, String localidad, String instrumento, String melodia){
                  Artista artista;
                  artista = new Musico(nombre, edad,localidad, instrumento,melodia);
                   if (!listaConcursantes.containsKey(artista.getNombre())) {
                  listaConcursantes.put(nombre, artista);
                  labell.setText("Músico añadido con exito");

            }else{
             labell.setText("Ya existe un arista con ese nombre");
     
                   }
          
      }
     
     
     
     
     private void creaMalabarista(){
     String nombreA = nombre.getText();
     int edadA = 0;
     int numObjetosA = 0;
      try{
      edadA = Integer.parseInt(edad.getText());
      numObjetosA = Integer.parseInt(numObjetos.getText());
      }catch(NumberFormatException e){
          labell.appendText("Introduce un número en la edad y en el numero de objetos.");
      }
     String localidadA = localidad.getText();
     String objetoA = objeto.getText();
              System.out.println(numObjetosA);

         if(nombreA.isEmpty()){
      labell.appendText("Introduce un nombre");
     }
     else if(localidadA.isEmpty()){
      labell.appendText("Introduce una localidad");
     } else if(objetoA.isEmpty()){
     labell.appendText("Introduce un objeto");
     }else if(edadA<18){
         labell.appendText("Introduce una edad de más de 17.");
     }else if(numObjetosA<1 || numObjetosA>100){
         System.out.println(numObjetosA);
         labell.appendText("Introduce un numero de objetos entre 0 y 100");
     }else{
         crearMalabarista(nombreA, edadA, localidadA, numObjetosA, objetoA);
     }
         
     }
     
            public void crearMalabarista(String nombre, int edad, String localidad, int numObjetos, String objetos){
                  Artista artista;
                  artista = new Malabarista(nombre, edad,localidad, numObjetos,objetos);
                   if (!listaConcursantes.containsKey(artista.getNombre())) {
                  listaConcursantes.put(nombre, artista);
                  labell.setText("Malabarista añadido con exito");

            }else{
             labell.setText("Ya existe un arista con ese nombre");
     
                   }
          
      } 
     
     
     
     private void creaPoeta(){
      labell.setText("");
      String nombreA = nombre.getText();
      int edadA = 0;
      try{
      edadA = Integer.parseInt(edad.getText());
      }catch(NumberFormatException e){
          labell.appendText("Introduce un número en la edad\n");
      }
     String localidadA = localidad.getText();
     String poemaA = poema.getText();
     
         if(nombreA.isEmpty()){
      labell.appendText("Introduce un nombre\n");
     }
     else if(localidadA.isEmpty()){
      labell.appendText("Introduce una localidad\n");
     } else if(poemaA.isEmpty()){
       labell.appendText("Introduce un poema\n");
       
     }else if(edadA<18){
         labell.appendText("Introduce una edad de más de 17.\n");
     }else{
    crearPoeta(nombreA, edadA, localidadA, poemaA);
     }
     }
     
     public void crearPoeta(String nombre, int edad, String localidad, String poema){
                  Artista artista;
                  artista = new Cantante(nombre, edad,localidad, poema);
                   if (!listaConcursantes.containsKey(artista.getNombre())) {
                  listaConcursantes.put(nombre, artista);
                  labell.setText("Poeta añadido con exito");

            }else{
             labell.setText("Ya existe un arista con ese nombre");
     
                   }
          
      }
     
    
    
    @FXML
    void concursar(ActionEvent event) throws IOException {
        quitarAnadirArt();
     
        HashMap<String , Artista> participantes= new HashMap<>();
        
        if (radioiniciado.isSelected()) {   
            labelConcurso.setVisible(true);
          btnPuntuar.setVisible(true);
         textPuntos.setVisible(true);
            concurso(participantes);
            
        }else{
            labell.setText("El concurso debe estar en Iniciado para concursar");
        }
        
 
              
    }
    Scanner sc = new Scanner(System.in);

     private void concurso(HashMap<String , Artista> participantes) throws IOException {
     boolean seguirConcurso;
        //listaConcursantes = listaartistas
        participantes=artistasPorActuar(participantes);
        int contador = participantes.size();
        seguirConcurso= comprobarConcursantes(participantes);
        
        if(seguirConcurso){
         
        for (Map.Entry<String, Artista> artista : listaConcursantes.entrySet()) {
            if (participantes.containsKey(artista.getKey())&& artista.getValue().getPuntuacion()==0) {
                actuacionYpuntuacionArtista(artista.getValue());
                contador--;    
            }
            }
          
        }
     }
     

     
       private HashMap<String , Artista> artistasPorActuar(HashMap<String , Artista> map){ 
        for (Map.Entry<String, Artista> artista : listaConcursantes.entrySet()) {
            if (artista.getValue().getPuntuacion()==0) {
                map.put(artista.getKey(), artista.getValue());
            }
        }
        return map;
    }
       
           private boolean comprobarConcursantes(HashMap<String , Artista> art){
        if (listaConcursantes.isEmpty()) {
            labell.setText("No hay concursantes participando actualmente");
            return false;
        }else if(art.isEmpty()){
            labell.setText("Ya han concursado todos los participantes inscritos");
            return false;
        }else
            return true;
    }
    private void actuacionYpuntuacionArtista(Artista artista) throws IOException{
            
        artista.saludar();
        artista.actuar();
        artista.despedirse();
        puntuarArtista(artista);
       
    }
                int puntuacion;

       private void puntuarArtista(Artista artista) throws IOException{
       
        do{
          System.out.println("Introduce una puntuacion para el artista: ");
            labell.setText("Introduce una puntuacion para el artista:");
                 puntuacion = sc.nextInt();
            if (puntuacion<1 || puntuacion>12) {
                System.out.println("La puntuacion debe estar entre 1 y 12.\n");
            }
            artista.setPuntuacion(puntuacion);
        }while (puntuacion<1 || puntuacion>12);
        

        
    }
             
    @FXML
    void puntuar(ActionEvent event) {
          
     puntuacion = Integer.parseInt(textPuntos.getText());

    }

    @FXML
    void iniciarNuevoConcurso(ActionEvent event) {
        quitarAnadirArt();
        quitarConcurso();
    if(radiofinalizado.isSelected()){
            this.listaConcursantes=new HashMap<>();
           // regArtista.setListaArtistas(new HashMap<>());
            saveArt.delete();
            labell.setText("Concurso reseteado.");
        }else labell.setText("El concurso debe estar en finalizado para ejecutar esta opción.");
    }
    

    @FXML
    void mostrarClasActual(ActionEvent event) {
        quitarAnadirArt();
        quitarConcurso();
 if (radioiniciado.isSelected() || radioparado.isSelected()){
            addArtistasList("actual");
        }else labell.setText("No se puede ejecutar esta opcion en finalizado ");
    }

    @FXML
    void mostrarClasFinal(ActionEvent event) {
        quitarAnadirArt();
        quitarConcurso();
 if (radiofinalizado.isSelected()) {
            addArtistasList("final");
        }else labell.setText("Tienes que estar en finalizado para ejecutar esta opción ");
    }
    
    private void addArtistasList(String cad){
        List<Artista> clasificacion= new ArrayList<>();
        if (listaConcursantes.isEmpty()) {
            labell.setText("Aun no ha participado ningun concursante");
        }else{
            labell.setText("");
            labell.appendText("\n----Clasificacion "+cad+"----");
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
     private void mostrarClasificacionOrdenada(List<Artista> lista){
        Collections.sort(lista, Collections.reverseOrder());
        for (Artista artista : lista) {
            labell.appendText("Nombre: "+artista.getNombre()+ " Puntuacion :"+ artista.getPuntuacion() + "\n");
        }
    }

    @FXML
    void salir(ActionEvent event) {
        try {
            ser.guardarArtistas(listaConcursantes);
            System.out.println("Progreso guardado");
        } catch(IOException ioe){
            System.out.println("Error al guardar los datos");
        }finally{
            System.exit(0);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
        this.ser= new SerializarImpl();
        this.listaConcursantes=comprobarDatosGuardados();
 
        
    }    

 

    public void quitarAnadirArt(){
     chCantante.setVisible(false);
     chMusico.setVisible(false);
     chPoeta.setVisible(false);
     chMalabarista.setVisible(false);
     btnCreaArtista.setVisible(false);
     nombre.setVisible(false);
     edad.setVisible(false);
     localidad.setVisible(false);
     melodia.setVisible(false);
     poema.setVisible(false);
     instrumento.setVisible(false);
     numObjetos.setVisible(false);        
     objeto.setVisible(false);
    }
    
    public void quitarConcurso(){
         labelConcurso.setVisible(false);
          btnPuntuar.setVisible(false);
         textPuntos.setVisible(false);
    }
    
}
