
package event;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable{

    @FXML
    private Button btn;

    @FXML
    void eventButton(ActionEvent event) {
               btn.setStyle("-fx-text-fill:#333");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btn.setStyle("-fx-text-fill:#ccc;");
    }
}