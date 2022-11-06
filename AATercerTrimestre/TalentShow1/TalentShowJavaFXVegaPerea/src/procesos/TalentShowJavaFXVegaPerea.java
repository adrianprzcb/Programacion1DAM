/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Marina
 */
public class TalentShowJavaFXVegaPerea extends Application {
    
    /**
     * Método invocado automáticamente cuando la aplicación es lanzada desde el método main.
     * Indica la dirección de la ventana de inicio y el css utilizado. 
     * @param stage
     * @throws Exception 
     */
        @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/fxml/Intro.fxml"));
            Scene scene = new Scene(root);
            
            String css = this.getClass().getResource("/vista/css_img/estilo1.css").toExternalForm();
            scene.getStylesheets().add(css);
            
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
