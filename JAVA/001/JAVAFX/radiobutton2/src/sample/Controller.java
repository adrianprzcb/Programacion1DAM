package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton other;

    @FXML
    void eventButton(ActionEvent event) {
            if(male.isSelected()){
                System.out.println("Male");
            }else if(female.isSelected()){
                System.out.println("Female");
            }
            else{
                System.out.println("Other");
            }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
