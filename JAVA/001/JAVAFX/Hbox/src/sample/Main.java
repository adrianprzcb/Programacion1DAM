package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.scene.control.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox hb=new HBox(10);
        hb.setPadding(new Insets(10,10,20,30));
        Button btn= new Button("h");
        Button btn1= new Button("a");

        hb.getChildren().addAll(btn,btn1);

        primaryStage.setScene(new Scene(hb, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
