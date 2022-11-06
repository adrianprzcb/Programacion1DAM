/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package withscene;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author adria
 */
public class Controller implements Initializable {
    
      @FXML
    private RadioButton female;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton other;

    @FXML
    void eventButton(ActionEvent event) {
               if(male.isSelected()){
              
                 System.out.println("Male");
               }
               else if(female.isSelected()){
                  System.out.println("Female");

               }
               else {
                 System.out.println("Other");

               }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}
