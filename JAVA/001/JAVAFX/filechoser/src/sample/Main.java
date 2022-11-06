package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
HBox root = new HBox(); primaryStage.setTitle("Hello World");


Button btn = new Button("Load");
btn.setOnAction(e ->{

    FileChooser fc = new FileChooser();

    fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF File", "PDF"));
    File file = fc.showOpenDialog(primaryStage);
    System.out.println(file);


});
root.getChildren().add(btn);




primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
