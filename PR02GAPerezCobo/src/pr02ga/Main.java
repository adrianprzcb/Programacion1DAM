
package pr02ga;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Procesos pr = new Procesos();
        pr.ejecutar();
        }
        catch(Exception e){
            System.out.println("Error no soportado");
        }
    }
    
}
