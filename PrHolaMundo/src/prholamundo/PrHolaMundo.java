
package prholamundo;
import prholamundo.Numeros;


public class PrHolaMundo {
    

    public static void main(String[] args) {
       System.out.println("Hola");
    /* Numeros numeros = new Numeros();
       numeros.ejecutar();
       numeros.ejecutar2();  */
       
       //Declaración de Variables
       int numero1;
       int numero2;
       boolean aprobado = true;
       
       //Instrucciones
       numero1 = 4;
       numero2 = 3;
       int resultado;
       
       int suma = numero1+numero2;
       System.out.println("El resultado de la suma es "+ suma);
       
       
       if(suma>=9){
              System.out.println("Sobresaliente");
       } else if(suma>=7){
              System.out.println("Notable");
       } else if (suma==6){
              System.out.println("Bien");
       } else if (suma==5){
              System.out.println("Suficiente");
       } else if (suma<5){
              System.out.println("Suspenso");
       }
       
       
       
       /*
       if(suma>=5){
            aprobado = true;
       }else {
            aprobado = false;
       }
       
       if(aprobado){
       System.out.println("Estás aprobado");
       }
       
       
       if(numero1>numero2){
       System.out.println("El número 1 es mayor al número 2.");
       resultado= numero1-numero2;
       System.out.println("La diferencia es de "+ resultado + ".");
       }else {
       System.out.println("El número 2 es mayor al número 1.");
       resultado= numero2-numero1;
       System.out.println("La diferencia es de "+ resultado + ".");
       }
       
       */
       
       
    }


    
}
