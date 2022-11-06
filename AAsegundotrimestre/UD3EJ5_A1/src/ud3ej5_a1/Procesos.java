
package ud3ej5_a1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Procesos{
    Scanner sc = new Scanner(System.in);
    File archivoBase = null;
    FileReader fr = null;
    BufferedReader br = null;
    String[] datos;
    String login;
     String password;
     String email;
     String nombreCompleto;

      
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
      
      
    public void ejecutar() throws FileNotFoundException, IOException{
        pedirArchivo();
        recolectorDatos();
        //mostrarDatos();
        meterDatosEnNuevoArchivo();
    }
    
    public void pedirArchivo(){
        String nombreArchivo = "";
        System.out.print("Introduzca el nombre del archivo: ");
        nombreArchivo = sc.next();
        archivoBase = new File(nombreArchivo);
        if(archivoBase.exists()){
            System.out.println("El archivo existe.");
        }else{
            System.out.println("El archivo no existe");
                System.exit(0);
        }
    }
    
    public void recolectorDatos() throws FileNotFoundException, IOException{
         fr = new FileReader (archivoBase);
         br = new BufferedReader(fr);
         String linea = null;
         int numLineas = 0;
         
         while ((linea=br.readLine())!=null) {
            System.out.println(linea);
            numLineas++;
            String[] lineas = linea.split(":");
                if(lineas[0]!=null && lineas[0].length() >= 5 
                    && lineas[1]!=null && lineas[1].length() >= 5
                    && lineas [2]!=null && lineas[2].length() >= 5 && lineas[2].contains("@") 
                    && lineas [3]!=null && lineas[3].length() >= 5){
                         System.out.println("Usuario aceptado.");
                         usuarios.add(new Usuario(lineas[0],lineas[1],lineas[2],lineas[3]));
                }else{System.out.println("Usuario con datos Invalidos");}   
         }
    
    }
    
    public void mostrarDatos(){
        System.out.println(" -------- USUARIOS GUARDADOS:");
                for(int i=0; i<usuarios.size();i++){
                    System.out.println(" -------- ");
                    System.out.println("Login: " +usuarios.get(i).getLogin());
                    System.out.println("Password: " +usuarios.get(i).getPassword());
                    System.out.println("Mail: " +usuarios.get(i).getEmail());
                    System.out.println("Nombre Completo: " +usuarios.get(i).getNombreCompleto());
                }
                   
            }
    
    
    public void meterDatosEnNuevoArchivo() throws IOException{
        System.out.println("Escribe el nombre del archivo Importante: Añade .txt al final y no pongas carácteres especiales");
        String DIRECCION = sc.next();
        try{
        if( DIRECCION.contains(".txt")){
                System.out.println(DIRECCION);
                
                FileWriter  writer      = new FileWriter(DIRECCION);
                PrintWriter printWriter = new PrintWriter(writer);
                
                  for(int i=0; i<usuarios.size();i++){
                     printWriter.print(usuarios.get(i).getLogin()+ ":"+usuarios.get(i).getPassword()+ ":"+
                           usuarios.get(i).getEmail()+ ":"+usuarios.get(i).getNombreCompleto()+"\n");}
                  printWriter.close();
        }else{System.out.println("NOMBRE DE ARCHIVO NO VALIDO");}
        }catch(FileNotFoundException e){
            System.out.println("ARCHIVO CON NOMBRE INVALIDO");
        }
        
       
    }
     
   }


