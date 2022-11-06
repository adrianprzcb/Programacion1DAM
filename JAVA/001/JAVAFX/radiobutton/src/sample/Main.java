package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       // primaryStage.setTitle("Hello World");

        HBox root= new HBox();

        ToggleGroup group = new ToggleGroup();
        RadioButton btn = new RadioButton("Male");
        btn.setToggleGroup(group);

        btn.setSelected(true);

        RadioButton btn1 = new RadioButton("Female");
        btn1.setToggleGroup(group);

        RadioButton btn2 = new RadioButton("Other");
        btn2.setToggleGroup(group);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> gp, Toggle old_t, Toggle new_t) {
                System.out.println("Old toggle : " +old_t);
                System.out.println("New toggle : " +new_t);
            }
        });

        root.getChildren().addAll(btn,btn1,btn2);



        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
