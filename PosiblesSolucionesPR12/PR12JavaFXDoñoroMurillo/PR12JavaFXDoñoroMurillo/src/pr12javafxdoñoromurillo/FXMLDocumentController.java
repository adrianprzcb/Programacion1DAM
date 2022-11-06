/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr12javafxdoñoromurillo;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import modelo.procesos.Procesos;

/**
 *
 * @author Alumno1DAM
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button introducirNombres;

    @FXML
    private TextField nombre1;

    @FXML
    private TextField nombre2;

    @FXML
    private TextArea mostrarJuego;

    @FXML
    private Button btnJugar;
    
    @FXML
    private Label labelError;
    
    Procesos pr= new Procesos();
    String siguienteJugador;

    @FXML
    void comprobarNombres(MouseEvent event) {
        if (nombre1.getText().isEmpty() || nombre2.getText().isEmpty()) {
            labelError.setText("No se puede dejar el campo vacio");
        }else if( nombre1.getText().equals(nombre2.getText())){
            labelError.setText("No se pueden introducir dos nombres iguales");
        }else {
            pr.addZombies(nombre1.getText(), nombre2.getText());
            btnJugar.setDisable(false);
        }
    }

    @FXML
    void jugar(MouseEvent event) {
        if (mostrarJuego.isDisable()) {
            siguienteJugador=nombre1.getText();
        }
        
        mostrarJuego.setDisable(false);
        if (siguienteJugador.equals(nombre1.getText())) {
            mostrarJuego.setText(pr.realizarJugada(siguienteJugador));
            siguienteJugador=nombre2.getText();
        }else if (siguienteJugador.equals(nombre2.getText())) {
            mostrarJuego.setText(pr.realizarJugada(siguienteJugador));
            siguienteJugador=nombre1.getText();
        }
        

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
