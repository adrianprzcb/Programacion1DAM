package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        

        VBox vb = new VBox(10);
        vb.setPadding(new Insets(10,20,10,10));

        Button btn = new Button("Click me");
        Button btn1 = new Button("Click me 1");
        Button btn2 = new Button("Click me 2");
        vb.getChildren().addAll(btn,btn1,btn2);
        
        primaryStage.setScene(new Scene(vb, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
