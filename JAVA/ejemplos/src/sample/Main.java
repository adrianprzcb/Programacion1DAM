package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Button btn = new Button("Hello Udemy");
       Pane root = new Pane();
       Scene scene = new Scene(root, 300,400);
       root.getChildren().add(btn);

       btn.setOnAction(e -> {
           onEvent(btn);
       });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onEvent(Button btn){
        btn.setText("Hello JavaFX");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
