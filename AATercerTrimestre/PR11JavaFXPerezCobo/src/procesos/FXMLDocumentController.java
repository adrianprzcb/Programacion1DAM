/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import beans.Dado;
import beans.Jugador;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author alumno
 */
public class FXMLDocumentController implements Initializable {
    
      @FXML
    private Button btnIniciar;

    @FXML
    private TextField intrDados;

    @FXML
    private TextField intrJugadores;
    
        @FXML
    private TextField intrJugadas;

    @FXML
    private Label txtIntrD;

    @FXML
    private Label txtIntrP;
    
        @FXML
    private Label txtIntrJUG;
    
    @FXML
    private TextArea consola;
    
       @FXML
    private Button btnNext;
       
           @FXML
    private TextField nombre;
           
               @FXML
    private Button btnRESET;

    @FXML
    private Button btnSiguientePartida;

         int numJugadores = 0;
         int contador;
         int jugadas = 0;
        int numDados = 0;   
            private Jugador[] jugadores;

    @FXML
    void iniciar(ActionEvent event){
        
        
              try{
      numJugadores = Integer.parseInt(intrJugadores.getText());
      numDados = Integer.parseInt(intrDados.getText());
      jugadas = Integer.parseInt(intrJugadas.getText());
      }catch(NumberFormatException e){
          consola.setText("Introduce un número en los datos.");
      }
        
          if(numJugadores>0 && numJugadores < 11 && numDados > 0 && numDados <6 && jugadas>0 && jugadas<11){
              introducirNombres();
                      jugadores = new Jugador[numJugadores];
              contador = numJugadores;
            consola.setText("Introduce los nombres de los jugadores.");

          } else{
                        consola.setText("Introduce un número entre los valores marcados.");
          }   
              
    }
    
      //  private Scanner entrada = new Scanner(System.in);

    
      private void introducirNombres() {
                 btnIniciar.setVisible(false);
                intrDados.setVisible(false);
               intrJugadores.setVisible(false);
               txtIntrD.setVisible(false);
               txtIntrP.setVisible(false);
               txtIntrJUG.setVisible(false);
               intrJugadas.setVisible(false);
              btnNext.setVisible(true);
              nombre.setVisible(true);
              consola.setText("Introduce los nombres de los jugadores.");
    }
         @FXML
    void next(ActionEvent event) {
       
           String nombreA = nombre.getText();
            jugadores[contador-1] = new Jugador(nombreA, numDados);
            consola.setText("Usuario Creado: " + jugadores[contador-1].getNombre());
            contador--;
        if(contador==0){
            juego();
             btnNext.setVisible(false);
              nombre.setVisible(false);
            consola.setText("Concurso iniciado");
        }

    }
    
     private void juego() {
                       btnSiguientePartida.setVisible(true);

         
    }


    @FXML
    void siguienteJugada(ActionEvent event) {
            jugadas--;
                        consola.setText("");
                           consola.appendText( "TIRADAS una a una:");
        Dado[] dados;
        int totalJugada;
        for (int dadoNum = 0; dadoNum <numDados ; dadoNum++){
            for(int i = 0; i< jugadores.length ; i++){
               dados=  jugadores[i].tirarDados();
               jugadores[i].setTotalRonda(dados[dadoNum].getValorUltTirada());
               consola.appendText(jugadores[i].getNombre() + " : " +dados[dadoNum].getValorUltTirada() + " |-|  ");
            }
        }
                                   consola.appendText( "  TOTALES :");
               int puntosMax = 0;
            for(int h = 0; h< jugadores.length ; h++){
             consola.appendText("////// " + jugadores[h].getNombre() + " : " + jugadores[h].getTotalRonda() + " |-|  ");
                if(jugadores[h].getTotalRonda()>=puntosMax){
                   puntosMax = jugadores[h].getTotalRonda();
                }            
        }
              for(int h = 0; h< jugadores.length ; h++){
                if(jugadores[h].getTotalRonda()==puntosMax){
           //        jugadores[h].setPuntos( jugadores[h].getPuntos());
                }            
        }
            
            
            if(jugadas==0){
             btnSiguientePartida.setVisible(false);
             consola.setText("Concurso finalizado. Pulsa RESET para empezar de nuevo");

            }
    }
    
    
    
    private void mostrarGanador() {
            String nombreGanador = "";
            int puntosGanador = 0;
            boolean hayEmpate = false;
            Jugador jugadorActual;
            
            for (int posJugadorActual=0; posJugadorActual<jugadores.length; posJugadorActual++) {
                jugadorActual = jugadores[posJugadorActual];
                System.out.println("Puntos del jugador "+jugadorActual.getNombre()+":"+jugadorActual.getPuntos());
                if (puntosGanador < jugadorActual.getPuntos()) {
                    nombreGanador = jugadorActual.getNombre();
                    puntosGanador = jugadorActual.getPuntos();
                    hayEmpate = false;
                }
                
                else {
                    if (puntosGanador == jugadorActual.getPuntos()) {
                        hayEmpate = true;
                        nombreGanador = "Hay empate con ";
                    }
                }
            }
            System.out.println("Ganador:");
            System.out.println(nombreGanador+ " , "+puntosGanador);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

         
         @FXML
    void reset(ActionEvent event) {
           btnIniciar.setVisible(true);
                intrDados.setVisible(true);
               intrJugadores.setVisible(true);
               txtIntrD.setVisible(true);
               txtIntrP.setVisible(true);
                txtIntrJUG.setVisible(true);
               intrJugadas.setVisible(true);
              btnNext.setVisible(false);
              nombre.setVisible(false);
              btnSiguientePartida.setVisible(false);
    }
   
    
    
}
