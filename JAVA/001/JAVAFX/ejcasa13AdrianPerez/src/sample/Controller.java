package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    Scanner reader = new Scanner(System.in);

    @FXML
    private MenuItem cuadrado;

    @FXML
    private MenuItem rectangulo;

    @FXML
    private MenuItem circulo;

    @FXML
    private MenuItem trinagulo;

    @FXML
    void onCirculo(ActionEvent event) {


        int radio = 0;
        boolean end = false;
        System.out.println("Introduce el radio del circulo:");
        do {
            try {
                radio = reader.nextInt();
                double area = 3.1416 * Math.pow(radio,2);
                System.out.println("El area del circulo es: "+ area);
                System.out.println("Vuelve a elegir figura o sal. ");
                end = true;
            } catch (InputMismatchException ime){
                System.out.println("¡Cuidado! Solo puedes insertar números. ");
                end=true;
                System.out.println("Vuelve a elegir figura o sal. ");
            }
        } while (!end);
    }

    @FXML
    void onCuadrado(ActionEvent event) {
        int lado = 0;
        boolean end = false;
        System.out.println("Introduce el radio del circulo:");
        do {
            try {
                lado = reader.nextInt();
                double area = lado*lado;
                System.out.println("El area del cuadrado es: "+ area);
                System.out.println("Vuelve a elegir figura o sal. ");
                end = true;
            } catch (InputMismatchException ime){
                System.out.println("¡Cuidado! Solo puedes insertar números. ");
                end=true;
                System.out.println("Vuelve a elegir figura o sal. ");
            }
        } while (!end);
    }

    @FXML
    void onRectangulo(ActionEvent event) {
        int base = 0;
        int altura=0;
        boolean end = false;
        do {
            try {
                System.out.println("Introduce la base del rectangulo: ");
                base = reader.nextInt();
                System.out.println("Introduce la altura del rectangulo: ");
                altura = reader.nextInt();
                double area = base*altura;
                System.out.println("El area del rectangulo es: "+ area);
                System.out.println("Vuelve a elegir figura o sal. ");
                end = true;
            } catch (InputMismatchException ime){
                System.out.println("¡Cuidado! Solo puedes insertar números. ");
                end=true;
                System.out.println("Vuelve a elegir figura o sal. ");
            }
        } while (!end);
    }

    @FXML
    void onTriangulo(ActionEvent event) {
        int base = 0;
        int altura=0;
        boolean end = false;
        do {
            try {
                System.out.println("Introduce la base del triangulo: ");
                base = reader.nextInt();
                System.out.println("Introduce la altura del triangulo: ");
                altura = reader.nextInt();
                double area = base*altura/2;
                System.out.println("El area del triangulo es: "+ area);
                System.out.println("Vuelve a elegir figura o sal. ");
                end = true;
            } catch (InputMismatchException ime){
                System.out.println("¡Cuidado! Solo puedes insertar números. ");
                end=true;
                System.out.println("Vuelve a elegir figura o sal. ");
            }
        } while (!end);
    }

    @FXML
    void onSalir(ActionEvent event){
        System.exit(0);
    }
}
