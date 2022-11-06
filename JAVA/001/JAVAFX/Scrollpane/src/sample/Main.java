package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView browser = new WebView();
        WebEngine we = browser.getEngine();

        ScrollPane sc = new ScrollPane();
        sc.setContent(browser);

        we.loadContent("<h1>Hello </h1>");

        VBox vb = new VBox(10);
        vb.getChildren().add(sc);
        Scene scene = new Scene(vb,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
