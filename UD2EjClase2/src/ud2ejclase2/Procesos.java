
package ud2ejclase2;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Procesos {
    //Ambos
    Scanner sc = new Scanner(System.in);
    
    //cuentaNumero()
     int[] numeros = {1,2,3,4,5,6,7,8,9,2,1,2,1,2,1,2,1,6,7,8};
     int numeroInt;
     int contador;
     
     //concatenaPalabras()
     int[] arrayNum = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
     String[] arrayPal = {"coche","un","dos","andar","tres","mono","tren","cienmil","no sé","hola","adios","bandera","aguila","imperial","rata"};
     
     
     public void ejecutar(){
            
         cuentaNumero(numeros);
         concatenaPalabras(arrayNum, arrayPal);

}
     
 
    public void cuentaNumero(int[] num){
    
        
       System.out.println("Introduzca un número:");
       try{
       numeroInt = sc.nextInt();
       }catch(InputMismatchException e){
       System.out.println("No has introducido un número.");
       }
       for(int i=0; i<num.length;i++){
           
           if(numeroInt ==num[i]){
               contador++;     
           }
       }
       
       if(contador==0){
       System.out.println("El número "+ numeroInt + " no está en el Array.");
       }else if(contador==1){
       System.out.println("El número "+ numeroInt + " está "+ contador + " vez en el Array.");
       }else{
       System.out.println("El número "+ numeroInt + " está "+ contador + " veces en el Array.");
       }
       
    }
    
    
    public void concatenaPalabras(int[] num, String[] str){
        
        for(int i=0; i<num.length; i++){
            
            if(i<str.length){
            System.out.print(str[i]+" ");
            }
                    
        }
        
    }
    
}
