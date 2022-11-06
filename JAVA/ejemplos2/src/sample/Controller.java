package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button btn;

    public void initialize(URL arg0, ResourceBundle arg1){
       btn.setStyle("-fx-text-fill: #ccc;");
    }

    public void eventButton(ActionEvent actionEvent) {
        btn.setStyle("-fx-text-fill: #333");
    }
}
