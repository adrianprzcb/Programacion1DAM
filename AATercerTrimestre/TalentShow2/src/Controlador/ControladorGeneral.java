/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Artista;
import modelo.Cantante;
import modelo.EstadoConcurso;
import modelo.Malabarista;
import modelo.Musico;
import modelo.Poeta;
import modelo.procesos.Aplicacion;
import modelo.serializar.SerializarIMPL;
import vista.utiles.Util;

/**
 * FXML Controller class
 *
 * @author raulm
 */
public class ControladorGeneral implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtLocalidad;
    @FXML
    private Label lblActuacion;
    @FXML
    private TextField txtNombreActuacion;
    @FXML
    private ToggleGroup tipoArtista;
    @FXML
    private RadioButton rdMusico;
    @FXML
    private RadioButton rdMalabarista;
    @FXML
    private RadioButton rdPoeta;
    @FXML
    private RadioButton rdCantante;
    @FXML
    private Button btRegistrar;

    private Artista artista;
    private String nombre;
    private String apellidos;
    private String procedencia;
    private String actuacion;
    private int edad;
    private boolean isOk;
    private Iterator<Artista> iterador;
    private SerializarIMPL serializar;
    private ArrayList<Artista> artistasRegistrados;
    private ArrayList<Artista> artistasPuntuados;
    private HashSet<String> nombresArtistas;
    private int puntero;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.serializar = new SerializarIMPL();

        if (Files.exists(Util.convertirEnPath("registrados.ser")) && Files.exists(Util.convertirEnPath("filtradoDeRegistro.ser")) && Files.exists(Util.convertirEnPath("puntuados.ser"))
                && Files.exists(Util.convertirEnPath("puntero.ser"))) {
            try {
                this.artistasRegistrados = (ArrayList<Artista>) serializar.desSerializar("registrados.ser");
                this.nombresArtistas = (HashSet<String>) serializar.desSerializar("filtradoDeRegistro.ser");
                this.artistasPuntuados = (ArrayList<Artista>) serializar.desSerializar("puntuados.ser");
                this.puntero = (int) serializar.desSerializar("puntero.ser");
            } catch (IOException ex) {
                Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Files.exists(Util.convertirEnPath("registrados.ser")) && Files.exists(Util.convertirEnPath("filtradoDeRegistro.ser"))) {
            try {
                this.artistasRegistrados = (ArrayList<Artista>) serializar.desSerializar("registrados.ser");
                this.nombresArtistas = (HashSet<String>) serializar.desSerializar("filtradoDeRegistro.ser");
                this.artistasPuntuados = new ArrayList<>();

            } catch (IOException ex) {
                Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            artistasRegistrados = new ArrayList<>();
            artistasPuntuados = new ArrayList<>();
            nombresArtistas = new HashSet<>();
        }

    }

    @FXML
    private void nombreActuacion(ActionEvent event) {
        lblActuacion.setText("Nombre Actuación:");
    }

    @FXML
    private void tipoObjeto(ActionEvent event) {
        lblActuacion.setText("Nombre Objetos:");
    }

    @FXML
    private void registrarConcursante(ActionEvent event) {
        isOk = true;
        try {
            this.nombre = txtNombre.getText();
            this.apellidos = txtApellidos.getText();
            this.procedencia = txtLocalidad.getText();
            this.actuacion = txtNombreActuacion.getText();
            this.edad = Integer.parseInt(txtEdad.getText());

//            isOk = compruebaRelleno();
            if (!nombresArtistas.contains((nombre + apellidos).toUpperCase().trim())) {

                if (rdMusico.isSelected()) {
                    artista = new Musico(nombre, apellidos, procedencia, edad, "tocar su melodia " + actuacion, "Musico");
                } else if (rdCantante.isSelected()) {
                    artista = new Cantante(nombre, apellidos, procedencia, edad, "cantar su canción " + actuacion, "Cantante");
                } else if (rdMalabarista.isSelected()) {
                    artista = new Malabarista(nombre, apellidos, procedencia, edad, "realizar malabares con " + actuacion, "Malabarista");
                } else if (rdPoeta.isSelected()) {
                    artista = new Poeta(nombre, apellidos, procedencia, edad, "recitar su poema " + actuacion, "Poeta");
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error de registro");
                    alert.setContentText("Debe marcar un tipo de artista.");
                    alert.showAndWait();
                    isOk = false;
                }

                if (isOk == true) {
                    artistasRegistrados.add(artista);
                    nombresArtistas.add((nombre + apellidos).toUpperCase().trim());
                    JOptionPane.showMessageDialog(null, "Usuario Registrado Exitosamente.");
                    guardarRegistrados();

                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error de registro");
                alert.setContentText("Ya existe un usuario con ese nombre.");
                alert.showAndWait();
            }

        } catch (NumberFormatException nf) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error de registro");
            alert.setContentText("Se requiere un entero.");
            alert.showAndWait();
        }
    }

    private void guardarRegistrados() {
        try {
            serializar.serializar(artistasRegistrados, "registrados.ser");
            serializar.serializar(nombresArtistas, "filtradoDeRegistro.ser");
        } catch (IOException ex) {
            Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-------------------------------------------------------------------------------
    //          Actuaciones
    //-------------------------------------------------------------------------------
    @FXML
    private TextField txtPuntuacion;

    @FXML
    private Button btPuntuar;

    @FXML
    private Button btNuevaActuacion;

    @FXML
    private Label lblSalidaActuacion;

    @FXML
    private TextArea areaActuacion;

    @FXML
    void actuar(ActionEvent event) {
        cargaPuntero();
        if (puntero == artistasRegistrados.size()) {
            JOptionPane.showMessageDialog(null, "No hay artistas por concursar.");

        } else {
            lblSalidaActuacion.setText(artistasRegistrados.get(puntero).getNombre() + " " + artistasRegistrados.get(puntero).getApellidos() + " está actuando.");

            areaActuacion.appendText(artistasRegistrados.get(puntero).saludar() + "\n");
            areaActuacion.appendText("-> El concursante " + artistasRegistrados.get(puntero).getNombre() + " comienza a " + artistasRegistrados.get(puntero).getActuacion() + "\n");
            areaActuacion.appendText(artistasRegistrados.get(puntero).despedirse());
            btNuevaActuacion.setDisable(true);
            btPuntuar.setDisable(false);
        }

    }

    @FXML
    void puntuar(ActionEvent event) {

        try {
            int puntuacion = Integer.parseInt(txtPuntuacion.getText());
            if (puntuacion < 0 || puntuacion > 12) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error de registro");
                alert.setContentText("La puntuación se establece entre 0 y 12.");
                alert.showAndWait();
            } else {
                artistasRegistrados.get(puntero).setPuntuacion(puntuacion);
                artistasPuntuados.add(artistasRegistrados.get(puntero));
                JOptionPane.showMessageDialog(null, "Artista puntuado correctamente.");

                puntero++;
                guardarPostConcursar();
                btNuevaActuacion.setDisable(false);
                lblSalidaActuacion.setText("Seleccione 'Nueva Actuación'.");
                areaActuacion.setText("");
                txtPuntuacion.setText("");
                btPuntuar.setDisable(true);

            }
        } catch (NumberFormatException nf) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error de registro");
            alert.setContentText("Se requiere un entero.");
            alert.showAndWait();
        }

    }

    private void cargaPuntero() {
        if (artistasPuntuados.isEmpty()) {
            this.puntero = 0;
        } else {
            if (Files.exists(Util.convertirEnPath("puntero.ser"))) {
                try {
                    this.puntero = (int) serializar.desSerializar("puntero.ser");
                } catch (IOException ex) {
                    Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private void guardarPostConcursar() {
        try {
            serializar.serializar(artistasPuntuados, "puntuados.ser");
            serializar.serializar(puntero, "puntero.ser");
        } catch (IOException ex) {
            Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------------------------------------------
    //          Mostrar Clasificacion
    //--------------------------------------------------------------
    private ObservableList<Artista> concursantes;

    @FXML
    private Button btConsultar;

    @FXML
    private TableView<Artista> tblTabla;

    @FXML
    private TableColumn colArtista;

    @FXML
    private TableColumn colPuntos;

    @FXML
    void consultar(ActionEvent event) {
        if (!artistasPuntuados.isEmpty()) {
            cargaTable();
            ordenaPuntuados();
            mostrarClasificacion();
        } else {
            JOptionPane.showMessageDialog(null, "No hay artistas puntuados.");
        }

    }

    private void cargaTable() {
        this.concursantes = FXCollections.observableArrayList();
        this.colArtista.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colPuntos.setCellValueFactory(new PropertyValueFactory("puntuacion"));
    }

    private void ordenaPuntuados() {

        artistasPuntuados.sort(Comparator.comparing(Artista::getPuntuacion).reversed());
        int indice = 1;
        for (Artista artista : artistasPuntuados) {
            concursantes.add(artistasPuntuados.get(indice - 1));
            indice++;
        }

    }

    private void mostrarClasificacion() {
        this.tblTabla.setItems(concursantes);
    }
}
