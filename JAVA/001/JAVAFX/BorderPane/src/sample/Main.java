package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.control.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane bp=new BorderPane();
        bp.setPadding(new Insets(10,10,20,30));


        Button btnTop=new Button("Top");
        bp.setTop(btnTop);
        Button btnBottom=new Button("Bottom");
        bp.setBottom(btnBottom);

        Button btnLeft=new Button("Left");
        bp.setLeft(btnLeft);

        Button btnRight=new Button("Right");
        bp.setRight(btnRight);

        Button btnCenter=new Button("Center");
        bp.setCenter(btnCenter);

        primaryStage.setScene(new Scene(bp, 300, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
