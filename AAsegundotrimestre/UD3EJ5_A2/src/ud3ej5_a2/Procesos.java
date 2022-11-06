
package ud3ej5_a2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;



public class Procesos{
    Scanner sc = new Scanner(System.in);
    File archivoBase = null;
    FileReader fr = null;
    BufferedReader br = null;
    String[] datos;
     String login;
     String loginCerta;
     Boolean yaDentro = false;
    
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ArrayList<String> nombresDeUsuario = new ArrayList<String>();
      
      
    public void ejecutar() throws FileNotFoundException, IOException{
        pedirArchivo();
        recolectorDatos();
        mostrarDatos();
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
         
         while ((linea=br.readLine())!=null) {
            System.out.println(linea);
            String[] lineas = linea.split(":");
                if(lineas[0]!=null && lineas[0].length() >= 5 
                    && lineas[1]!=null && lineas[1].length() >= 5
                    && lineas [2]!=null && lineas[2].length() >= 5 && lineas[2].contains("@") 
                    && lineas [3]!=null && lineas[3].length() >= 5){
                    usuarios.add(new Usuario(lineas[0],lineas[1],lineas[2],lineas[3]));
                    for (int i=0; i<usuarios.size();i++){
                        login = lineas[0];
                        loginCerta = usuarios.get(i).getLogin();
                        if(login.equals(loginCerta)){
                            //Login encontrado
                             for (String element : nombresDeUsuario){
                                 yaDentro=false;
                              if (element.equals(login)){
                                        yaDentro=true;
                                 }
                           }
                             if(!yaDentro){
                                 nombresDeUsuario.add(login);
                             }else{
                                 //si ya estaba dentro pues es elimina ya que está repetido.
                                 System.out.println("DUPLICADO");
                                 usuarios.remove(i);
                             } 
                        }
                    }
                    
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
                
                
                FileWriter  writer      = new FileWriter(DIRECCION);
                PrintWriter printWriter = new PrintWriter(writer);
                System.out.println("Archivo Creado");
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


