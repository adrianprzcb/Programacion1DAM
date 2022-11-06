/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.EstadoConcurso;
import modelo.procesos.Aplicacion;
import modelo.serializar.SerializarIMPL;
import vista.utiles.Util;

/**
 * FXML Controller class
 *
 * @author raulm
 */
public class ControladorMain implements Initializable {

    @FXML
    private Button btRegistro;
    @FXML
    private Button btNuevo;
    @FXML
    private Button btConcurso;
    @FXML
    private Button btClasificacion;
    @FXML
    private Button btSalir;
    @FXML
    private RadioButton rdParado;
    @FXML
    private RadioButton rdLanzado;
    @FXML
    private RadioButton rdFinalizado;
    @FXML
    private ToggleGroup estadoActual;
    private ControladorGeneral general;
    private EstadoConcurso estado;
    private SerializarIMPL serializar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.serializar = new SerializarIMPL();
        this.general = new ControladorGeneral();

        if (Files.exists(Util.convertirEnPath("finalizado.ser"))) {
            try {
                this.estado = (EstadoConcurso) serializar.desSerializar("finalizado.ser");
            } catch (IOException ex) {
                Logger.getLogger(ControladorMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                Logger.getLogger(ControladorMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.estado = new EstadoConcurso();
        }

        if (estado.getFinalizado() == true) {
            finalizar();
        } else {
            estaParado();
        }
    }

    @FXML
    private void registrarConcursantes(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registros.fxml"));
            Parent root = loader.load();
            ControladorGeneral controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void concursar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Actuaciones.fxml"));
            Parent root = loader.load();
            ControladorGeneral controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void consultarClasificacion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Puntuados.fxml"));
            Parent root = loader.load();
            ControladorGeneral controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) this.btSalir.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void paradoMarcado(ActionEvent event) {
        estaParado();

    }

    @FXML
    private void lanzadoMarcado(ActionEvent event) {
        estaLanzado();
    }

    @FXML
    private void finalizadoMarcado(ActionEvent event) {
        finalizar();
    }

    private void estaParado() {
        btConcurso.setDisable(true);
        btRegistro.setDisable(false);
        estado.setLanzado(false);
        rdParado.setSelected(true);
        btNuevo.setDisable(true);

    }

    private void estaLanzado() {
        btConcurso.setDisable(false);
        btRegistro.setDisable(true);
        estado.setLanzado(true);
        rdLanzado.setSelected(true);
        btNuevo.setDisable(true);
    }

    private void finalizar() {

        JOptionPane.showMessageDialog(null, "Concurso finalizado, esta acción no es reversible");
        estado.setFinalizado(true);
        btRegistro.setDisable(true);
        btConcurso.setDisable(true);
        rdLanzado.setDisable(true);
        rdParado.setDisable(true);
        rdFinalizado.setSelected(true);
        btNuevo.setDisable(false);
        guardarEstado();

    }

    @FXML
    private void nuevoConcurso(ActionEvent event) {
        try {
            Files.deleteIfExists(Util.convertirEnPath("registrados.ser"));
            Files.deleteIfExists(Util.convertirEnPath("filtradoDeRegistro.ser"));
            Files.deleteIfExists(Util.convertirEnPath("puntero.ser"));
            Files.deleteIfExists(Util.convertirEnPath("puntuados.ser"));
            Files.deleteIfExists(Util.convertirEnPath("finalizado.ser"));

            estaParado();
            rdParado.setDisable(false);
            rdLanzado.setDisable(false);

        } catch (IOException ex) {
            Logger.getLogger(ControladorMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarEstado() {
        try {

            serializar.serializar(estado, "finalizado.ser");
        } catch (IOException ex) {
            Logger.getLogger(ControladorMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(ControladorMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
