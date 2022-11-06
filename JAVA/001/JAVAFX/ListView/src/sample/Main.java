package sample;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox root = new HBox();
        primaryStage.setTitle("Hello World");

        ObservableList<String> ob= FXCollections.observableArrayList("Java" , "Html" , "idk");
        ListView<String> list = new ListView<>(ob);

        list.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov,String old, String newW)->{

            System.out.println(old);
            System.out.println(newW);

        });

        root.getChildren().add(list);

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
