
package areasgeometricasfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentController implements Initializable {
    
    
    
 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox choicebox;

    @FXML
    private Button btnCalcular;

    @FXML
    private Label choiceLabel;

    @FXML
    private TextField insLado;

    @FXML
    private TextField insAltura;

    @FXML
    private TextField insBase;

    @FXML
    private TextField insRadio;

       @FXML
    private Button btnElegir;
          @FXML
    private Label labell;

   
   @FXML
    void elegirFigura(ActionEvent event) {
        try{
           
       if(choicebox.getValue().toString().equals("Cuadrado")){
           insLado.setVisible(true);
           insAltura.setVisible(false);
           insBase.setVisible(false);
           insRadio.setVisible(false);
           btnCalcular.setVisible(true);
       }
       else if(choicebox.getValue().toString().equals("Triangulo") || choicebox.getValue().toString().equals("Rectangulo")){
           insLado.setVisible(false);
           insAltura.setVisible(true);
           insBase.setVisible(true);
           insRadio.setVisible(false);
           btnCalcular.setVisible(true);
       }
       else if(choicebox.getValue().toString().equals("Circulo")){
            insLado.setVisible(false);
           insAltura.setVisible(false);
           insBase.setVisible(false);
           insRadio.setVisible(true);
           btnCalcular.setVisible(true);
       }
       }catch(NullPointerException e){
                   choiceLabel.setText("Elija una opción" );

       }
        
       
    }
   
    public void calcular(){
        //choiceLabel.setText(choicebox.getValue().toString());
        try{

        if(choicebox.getValue().toString().equals("Cuadrado")){
           calcularAreaCuadrado();
        }
        else if(choicebox.getValue().toString().equals("Triangulo")){
           calcularAreaTriangulo();
        }
        else if(choicebox.getValue().toString().equals("Rectangulo")){
           calcularAreaRectangulo();
        }
        else if(choicebox.getValue().toString().equals("Circulo")){
           calcularAreaCirculo();
        }
        }catch(Exception ex){
            choiceLabel.setText("Introduce datos validos.");

        }
    }
    
    public void calcularAreaCuadrado(){
        int lado = Integer.parseInt(insLado.getText());
        int area =lado*lado;
        choiceLabel.setText("El area del cuadrado es: " + area );

    } 
    
    public void calcularAreaTriangulo(){
        int base = Integer.parseInt(insBase.getText());
        int altura = Integer.parseInt(insAltura.getText());
        int area =(base*altura)/2;
        choiceLabel.setText("El area del triangulo es: " + area );

    } 
       
    public void calcularAreaRectangulo(){
        int base = Integer.parseInt(insBase.getText());
        int altura = Integer.parseInt(insAltura.getText());
        int area =base*altura;
        choiceLabel.setText("El area del rectangulo es: " + area );

    } 
    
    public void calcularAreaCirculo(){
        int radio = Integer.parseInt(insRadio.getText());
        int area =(int) (Math.PI * Math.pow(radio,2));
        choiceLabel.setText("El area del circulo es: " + area );

    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        choicebox.getItems().add("Cuadrado");
        choicebox.getItems().add("Rectangulo");
        choicebox.getItems().add("Triangulo");
        choicebox.getItems().add("Circulo");
        
      

    }    
    
}
