package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    HBox root = new HBox();
    primaryStage.setTitle("Hello World");

        MenuBar mbr= new MenuBar();
        Menu menu = new Menu("File");

        menu.getItems().add(new MenuItem("New"));
        menu.getItems().add(new MenuItem("Open File"));
        menu.getItems().add(new MenuItem("Close"));
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Exit"));


        mbr.getMenus().add(menu);
        root.getChildren().add(mbr);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
