package sample;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Observable;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox root = new HBox();
        primaryStage.setTitle("Hello World");



        ObservableList<String> list = FXCollections.observableArrayList("Java", "JavaFX","CPP", "HTML");
        ChoiceBox choice = new ChoiceBox(list);
       // choice.getItems().addAll("Java", "JavaFX","CPP", "HTML");

        choice.getSelectionModel().selectedItemProperty().addListener((ObservableValue ob, Object oldValue, Object newValue)-> {

            System.out.println((String)newValue);
            System.out.println((String)oldValue);

        });
        root.getChildren().add(choice);

        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
