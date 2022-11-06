package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox root = new HBox();
        Scene scene = new Scene(root,300,300);

        TextField txt = new TextField();
        PasswordField pass = new PasswordField();
        Button btn = new Button("Click me");
        btn.setOnAction(e -> {
            System.out.println(txt.getText());
            System.out.println(pass.getText());
        });
        root.getChildren().addAll(txt,pass,btn);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
