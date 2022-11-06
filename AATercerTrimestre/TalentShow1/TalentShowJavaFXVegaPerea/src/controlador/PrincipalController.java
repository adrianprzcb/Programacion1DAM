/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import procesos.Aplicacion;
import procesos.Serializar;
import procesos.SerializarImpl;

/**
 * FXML Controller class
 *
 * @author Marina
 */
public class PrincipalController implements Initializable {

    static String estado = "Parado";
    Aplicacion app = new Aplicacion();
    
    @FXML
    Button botonComenzarActuacion;
    
    @FXML
    Button registroCantante;
    
    @FXML
    Button botonCargarClasificacion;
    
    @FXML
    TextField localidadCantante;
    
    @FXML
    TextField localidadMusico;
    
    @FXML
    TextField localidadPoeta;
    
    @FXML
    TextField localidadMalabarista;
    
    @FXML
    TextField nombreCantante;
    
    @FXML
    TextField nombreMusico;
    
    @FXML
    TextField nombrePoeta;
    
    @FXML
    TextField nombreMalabarista;
    
    @FXML
    TextField edadCantante;
    
    @FXML
    TextField edadMusico;
    
    @FXML
    TextField edadPoeta;
    
    @FXML
    TextField edadMalabarista;
    
    @FXML
    TextField cancionCantante;
    
    @FXML
    TextField instrumentoMusico;
    
    @FXML
    TextField tituloPoeta;
    
    @FXML
    TextField numObjMalabarista;
    
    @FXML
    TextField nombreObjMalabarista;
    
    @FXML
    TextField presentacion;
    
    @FXML
    TextField actuacion;
    
    @FXML
    TextField despedida;
    
    @FXML
    TextField puntuacion;
    
    @FXML
    Button botonSetPuntuacion;
    
    @FXML
    TextField preguntaPuntuacion;
    
    @FXML
    TextField pistaPuntuacion;
    
    @FXML
    TextArea clasificacion;
    
    @FXML
    ImageView imgMusico;
    
    @FXML
    ImageView imgPoeta;
    
    @FXML
    ImageView imgCantante;
    
    @FXML
    ImageView imgMalabarista;
    
    
        
    //Event event;
    private Stage stage;
    private Scene scene;
    private Parent root;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    

    /**
     * Método para salir de la aplicacion.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     */
    @FXML
    private void salir(Event  event) {
        System.exit(1);
    }

    /**
     * Método para cambiar de la ventana actual a la ventana CambiarEstado.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void cambioEstado(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/CambiarEstado.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para cambiar de la ventana actual a la ventana RegistroArtista.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void registrarArtistas(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/RegistroArtista.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para cambiar de la ventana actual a la ventana Clasificacion.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void actionClasificacion(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/Clasificacion.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    /**
     * Método para cambiar de la ventana actual a la ventana Concurso.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void concursarArtistas(Event event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/Concurso.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para cambiar de la ventana actual a la ventana ContinuarSiNoConcursoNuevo.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void handleButtonActionContinuarConcursoNuevo(Event event) throws IOException {
        estado = "Parado";
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/ContinuarSiNoConcursoNuevo.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para cambiar de la ventana actual a la ventana OpcionesParado.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void handleButtonActionParado(Event event) throws IOException {
        estado = "Parado";
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/OpcionesParado.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para cambiar de la ventana actual a la ventana OpcionesLanzado.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void handleButtonActionLanzado(Event event) throws IOException {
        estado = "Lanzado";
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/OpcionesLanzado.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para cambiar de la ventana actual a la ventana OpcionesFinalizado.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void handleButtonActionFinalizado(Event event) throws IOException {
        estado = "Finalizado";
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/OpcionesFinalizado.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para cambiar de la ventana actual a la ventana ContinuarSiNoPuntuacion.fxml.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void irVentanaContinuar(Event event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/vista/fxml/ContinuarSiNoPuntuacion.fxml"));
        stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Método para volver al menú correspondiente del estado de la aplicacion indicado anteriormente.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void volverMenu(Event event) throws IOException{
        
        switch (estado) {
            case "Lanzado":
                handleButtonActionLanzado(event); 
                break;
            case "Parado":
                handleButtonActionParado(event);  
                break;
            case "Finalizado":
                handleButtonActionFinalizado(event);
                break;
            default:
                break;
        }
        
          
        
    }
    
    /**
     * Método para registrar los valores de las propiedades del artista Poeta.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     */
    @FXML
    private void registroPoeta(Event event){
        try{
            if(!localidadPoeta.getText().isEmpty() && !nombrePoeta.getText().isEmpty() && !tituloPoeta.getText().isEmpty()){
                if (Integer.parseInt(edadPoeta.getText()) > 18) {
                    app.registroPoeta(localidadPoeta.getText(), nombrePoeta.getText(), Integer.parseInt(edadPoeta.getText()), tituloPoeta.getText());
                    limpiarTextFieldPoeta();
                }else{
                    throw new ArithmeticException();
                }
            }else{
                throw new NullPointerException();
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "LA EDAD MÍNIMA REQUERIDA ES DE 18 AÑOS.");
        } catch (NumberFormatException  nfe) {
            JOptionPane.showMessageDialog(null, "ERROR. SE ESPERABA UN ENTERO: VUELVA A INTENTARLO.");
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos"); 
        }
         
    }
    
   /**
    * Método para registrar los valores de las propiedades del artista Cantante.
    * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
    */
    @FXML
    private void registroCantante(Event event){
        
        try{
            if(!localidadCantante.getText().isEmpty() && !nombreCantante.getText().isEmpty() && !cancionCantante.getText().isEmpty()){
                if (Integer.parseInt(edadCantante.getText()) > 18) {
                     app.registroCantante(localidadCantante.getText(), nombreCantante.getText(), Integer.parseInt(edadCantante.getText()), cancionCantante.getText());
                     limpiarTextFieldCantante();
                }else{
                    throw new ArithmeticException();
                }
            }else{
                throw new NullPointerException();
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "LA EDAD MÍNIMA REQUERIDA ES DE 18 AÑOS.");
        } catch (NumberFormatException  nfe) {
            JOptionPane.showMessageDialog(null, "ERROR. SE ESPERABA UN ENTERO: VUELVA A INTENTARLO.");
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos"); 
        }
        
    }
    
    /**
    * Método para registrar los valores de las propiedades del artista Musico.
    * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
    */
    @FXML
    private void registroMusico(Event event){   
        
        try{
            if(!localidadMusico.getText().isEmpty() && !nombreMusico.getText().isEmpty() && !instrumentoMusico.getText().isEmpty()){
                if (Integer.parseInt(edadMusico.getText()) > 18) {
                    app.registroMusico(localidadMusico.getText(), nombreMusico.getText(), Integer.parseInt(edadMusico.getText()), instrumentoMusico.getText());
                    limpiarTextFieldMusico();
                }else{
                    throw new ArithmeticException();
                }
            }else{
                throw new NullPointerException();
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "LA EDAD MÍNIMA REQUERIDA ES DE 18 AÑOS.");
        } catch (NumberFormatException  nfe) {
            JOptionPane.showMessageDialog(null, "ERROR. SE ESPERABA UN ENTERO: VUELVA A INTENTARLO.");
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos"); 
        }
        
    }
    
    /**
     * Método para registrar los valores de las propiedades del artista Malabarista.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     */
    @FXML
    private void registroMalabarista(Event event){
        
        try{
            if(!localidadMalabarista.getText().isEmpty() && !nombreMalabarista.getText().isEmpty() && !nombreObjMalabarista.getText().isEmpty()){
                if (Integer.parseInt(edadMalabarista.getText()) >= 18) {
                    if( Integer.parseInt(numObjMalabarista.getText()) >= 2){
                        
                        app.registroMalabarista(localidadMalabarista.getText(), nombreMalabarista.getText(), Integer.parseInt(edadMalabarista.getText()), Integer.parseInt(numObjMalabarista.getText()), nombreObjMalabarista.getText());
                        limpiarTextFieldMalabarista();
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Deberia hacer malabares con 2 objetos como mínimo");
                    }
                }else{
                    throw new ArithmeticException();
                }
            }else{
                throw new NullPointerException();
            }
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "LA EDAD MÍNIMA REQUERIDA ES DE 18 AÑOS.");
        } catch (NumberFormatException  nfe) {
            JOptionPane.showMessageDialog(null, "ERROR. SE ESPERABA UN ENTERO: VUELVA A INTENTARLO.");
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos"); 
        }
        
    }
    
    /**
     * Método para visualizar un gif que representa un artista segun su tipo.
     * @param tipo 
     */
    public void visualizarGif(String tipo){
        switch(tipo){
            case "Cantante":
                imgCantante.setVisible(true);
                break;
            case "Musico":
                imgMusico.setVisible(true);
                break;
            case "Malabarista":
                imgMalabarista.setVisible(true);
                break;
            case "Poeta":
                imgPoeta.setVisible(true);
                break;
        }
    }
    
    /**
     * Método para mostrar la actuacion del artista al usuario y proporcionar un método de puntuacion.
     */
    @FXML
    public void presentarArtista() {
            
        if (app.getIndiceActuaciones() < app.getNumArtista()) {
            presentacion.setText(app.getSaludo());
            actuacion.setText(app.getActuacion());
            despedida.setText(app.getDespedida());
            
            activarPuntuacion();
            visualizarGif(app.getArtistaActual().getClass().getSimpleName());
            botonComenzarActuacion.setDisable(false);
            
             
             
        }else{
                JOptionPane.showMessageDialog(null, "Ya no quedan mas concursantes por ver."); 
            
            }

    }
    
    /**
     * Método para activar la visualizacion de herramientas para puntuar la actuacion.
     */
    public void activarPuntuacion(){
        preguntaPuntuacion.setVisible(true);
        puntuacion.setVisible(true);
        botonSetPuntuacion.setVisible(true);
        pistaPuntuacion.setVisible(true);
    }
    
    /**
     * Método para puntuar la actuacion del artista y pasar a la ventana ContinuarSINoPuntuacion.fxml .
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    public void puntuarActuacion(Event event) throws IOException{
        
        try{
            if(Integer.parseInt(puntuacion.getText()) <= 12 && Integer.parseInt(puntuacion.getText()) >= 1){
            if (app.getIndiceActuaciones() < app.getNumArtista()) {
            
                    app.determinarPuntuacion(Integer.parseInt(puntuacion.getText()));

                    app.setSumaActuaciones();
                    
                    botonComenzarActuacion.setDisable(true);
                    
                    irVentanaContinuar(event);
                }
            
            }else{
                JOptionPane.showMessageDialog(null, "El dato introducido no es un numero comprendido entre 1 y 12. Inténtelo de nuevo."); 

            }  
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero"); 
        }
                  
        
    }
    
    /**
     * Método para imprimir la clasificacion ordenada en la clase Aplicacion
     * en el textArea clasificacion.
     */
    @FXML
    private void mostrarClasificacion(){
        clasificacion.setText(app.ordenarClasificacion());
    }
    
    /**
     * Método para vaciar todos los textField de los registros de cantante.
     */
    @FXML
    private void limpiarTextFieldCantante(){
        localidadCantante.clear();
        nombreCantante.clear();
        edadCantante.clear(); 
        cancionCantante.clear();
    }
    
    /**
     * Método para vaciar todos los textField de los registros de poeta.
     */
    @FXML
    private void limpiarTextFieldPoeta(){
        localidadPoeta.clear();
        nombrePoeta.clear();
        edadPoeta.clear(); 
        tituloPoeta.clear();
    }
    
    /**
     * Método para vaciar todos los textField de los registros de malabarista.
     */
    @FXML
    private void limpiarTextFieldMalabarista(){
        localidadMalabarista.clear();
        nombreMalabarista.clear();
        edadMalabarista.clear(); 
        numObjMalabarista.clear();
        nombreObjMalabarista.clear();
    }
    
    /**
     * Método para vaciar todos los textField de los registros de musico.
     */
    @FXML
    private void limpiarTextFieldMusico(){
        localidadMusico.clear();
        nombreMusico.clear();
        edadMusico.clear(); 
        instrumentoMusico.clear();
    }
    
    /**
     * Método para borrar los artistas registrados y cambiar a la ventana OpcionesParado.fxml .
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void crearNuevoConcurso(Event event) throws IOException{
        app.borrarArtistas();
        JOptionPane.showMessageDialog(null, "Se han borrado todos los registros.");     
        handleButtonActionParado(event);
    }
    
    /**
     * Método para validar que todos los artistas han sido puntuados.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void permitirClasificacionFinal(Event event) throws IOException{
        boolean valido;
        if(app.getNumArtista() != 0){
            valido= app.validadorClasificacionFinal();
            if(valido == true){
                actionClasificacion(event);
                mostrarClasificacion();
            }else{
                JOptionPane.showMessageDialog(null, "Aún no han sido puntuados todos los artistas.");
            } 
        }else{
            JOptionPane.showMessageDialog(null, "No hay artistas que hayan concursado.");
        }
        
    }
    
    /**
     * Método para guardar el estado de la aplicación en un serializable.
     * @throws IOException 
     */
    @FXML
    private void guardar() throws IOException{
        app.prepararSerializacion();
        Serializar serializador = new SerializarImpl();
        serializador.serializar("proceso.ser", app);
    }
    
    /**
     * Método para actualizar el archivo serializable con los nuevos registros.
     * @param event es el evento de la interfaz gráfica de usuario de la plataforma.
     * @throws IOException 
     */
    @FXML
    private void cargar(Event event) throws IOException{
        Serializar serializador = new SerializarImpl();
        try {
            app = (Aplicacion)serializador.leer("proceso.ser");
            app.recuperarValoresEstaticos();
        } catch (FileNotFoundException fnfe){
            Logger.getLogger(Aplicacion.class.getName()).log(Level.INFO, "No existe el fichero a cargar");
        } catch (IOException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        volverMenu(event);
    }
    

    
    
}
