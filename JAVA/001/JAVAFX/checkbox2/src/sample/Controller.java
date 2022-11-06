package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class Controller {
    @FXML
    private CheckBox check;

    @FXML
    void eventButton(ActionEvent event) {

        if(check.isSelected()){
            System.out.println("Selected");
        }else{
            System.out.println("Not Selected");
        }
    }
}
