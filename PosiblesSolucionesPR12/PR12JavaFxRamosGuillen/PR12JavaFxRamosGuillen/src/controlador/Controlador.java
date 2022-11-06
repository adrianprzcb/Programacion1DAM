package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import modelo.procesos.Procesos;

public class Controlador {
	
	@FXML
    private AnchorPane inicio;
	
	@FXML
    private AnchorPane pantallaJuego;

    @FXML
    private TextField textNombreJugadores;

    @FXML
    private Button bttGuardarNombre;

    @FXML
    private Label labelInfo;
    
    @FXML
    private TextArea textRondas;

    @FXML
    private Button bttJugar;

    @FXML
    private Button reiniciarJuego;

    @FXML
    private Button bttVolverJugar;
    
    Procesos procesos;
    
    private int contador;
    
    String [] nombres;
    
    public Controlador() {
    	procesos=new Procesos();
    	nombres=new String [2];
    	contador=0;
    }

    @FXML
    void bttGuardarNombre_Click(ActionEvent event) {
    	
    	if(!textNombreJugadores.getText().trim().equals("")) {
    	nombres[contador]=textNombreJugadores.getText();
    	textNombreJugadores.setText("");
    	contador++;
    	}else {
    		labelInfo.setText("El nombre no puede estar vacio");
    	}
    	
    	if(contador==2) {
    		procesos.crearJugadores(nombres);
    		inicio.setVisible(false);
    		pantallaJuego.setVisible(true);
    		contador=0;
    		
    	}

    }
    
    @FXML
    void bttJugar_Click(ActionEvent event) {
    	textRondas.setText(procesos.jugar());
    	if(textRondas.getText().contains("ganador")){
    		bttVolverJugar.setVisible(true);
    		reiniciarJuego.setVisible(true);
    	}
    }
    
    @FXML
    void bttReiniciar_Click(ActionEvent event) {
    	textRondas.setText("");
    	procesos.reiniciar();
    		inicio.setVisible(true);
    		pantallaJuego.setVisible(false);
    		reiniciarJuego.setVisible(false);
    		bttVolverJugar.setVisible(false);
    	
    		
    	
    		
    }

    @FXML
    void bttVolverJugar_Click(ActionEvent event) {
    	
    	procesos.volverAJugar();
    	textRondas.setText("");
    	reiniciarJuego.setVisible(false);
		bttVolverJugar.setVisible(false);
    }

}
