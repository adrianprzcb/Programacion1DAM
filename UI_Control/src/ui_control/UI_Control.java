/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_control;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author adria
 */
public class UI_Control extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        Scene scene = new Scene(root,300,300);
        
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
                
                
             System.out.println("Old Toggle : " + old_t);
             System.out.println("New Toggle : " + new_t);
            }
        });
        
        root.getChildren().addAll(btn,btn1,btn2);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
  
       public static void main(String args[]){
    launch(args);
    }
}
