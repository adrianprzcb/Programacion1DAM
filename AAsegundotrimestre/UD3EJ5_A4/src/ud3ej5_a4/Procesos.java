
package ud3ej5_a4;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
     String DIRECCION;
     File archivo;
    
   ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
   HashMap<Integer,Usuario> usuaris=new HashMap<Integer,Usuario>();       
   ArrayList<String> nombresDeUsuario = new ArrayList<String>();
      
      
    public void ejecutar() throws FileNotFoundException, IOException, ClassNotFoundException{
        pedirArchivo();
        recolectorDatos();
        arrayAhash(usuarios);
        mostrarDatos();
        crearArchivo();
        grabaListaUsuarios(archivo,usuaris);
        leeListaUsuarios(archivo);
        
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
                                 //si ya estaba dentro pues es elimina ya que est?? repetido.
                                 System.out.println("DUPLICADO");
                                 usuarios.remove(i);
                             } 
                        }
                    }
                    
                }else{System.out.println("Usuario con datos Invalidos");}   
         }
         
      
    
    }
    
    public void arrayAhash(ArrayList<Usuario> usuarios){
        for(int i=0; i<usuarios.size();i++){
            usuaris.put(i,usuarios.get(i));
        }
            
    }

    
    public void mostrarDatos(){
        System.out.println(" -------- USUARIOS GUARDADOS:");
    for(Map.Entry m:usuaris.entrySet()){    
       System.out.println(m.getValue());    
      }  
               /* for(int i=0; i<usuarios.size();i++){
                    System.out.println(" -------- ");
                    System.out.println("Login: " +usuarios.get(i).getLogin());
                    System.out.println("Password: " +usuarios.get(i).getPassword());
                    System.out.println("Mail: " +usuarios.get(i).getEmail());
                    System.out.println("Nombre Completo: " +usuarios.get(i).getNombreCompleto());
                }
                   */
            }
    
    
    public void crearArchivo() throws IOException{
        System.out.println("Escribe el nombre del archivo Importante: A??ade .dat al final y no pongas car??cteres especiales");
        DIRECCION = sc.next();
      if(DIRECCION.contains(".dat")){
            archivo = new File(DIRECCION);
        }else{
          System.out.println("Error en el nombre del fichero");
          System.exit(0);
      }
    }
        public boolean grabaListaUsuarios(File fArchivo, HashMap listaUsuarios) throws FileNotFoundException, IOException{
            ObjectOutputStream oos = null;
            boolean ok = true;
            
            try {
                    oos = new ObjectOutputStream(new FileOutputStream(fArchivo));
                    oos.writeObject(listaUsuarios);
            }
            // Este catch debe ir antes que el de IOException.
            catch (FileNotFoundException fnfe) {
                  System.out.print("El nombre del archivo no ha sido introducido correctamente, por lo cual no se ha creado.");
            }
            catch (IOException ioe) {
                    System.out.print("Error al escribir el objeto en m??todo grabaListaUsuarios()");
            }
            finally {
                    if (oos != null)
                            oos.close();
            }
            return ok;
    }
        public HashMap<Integer, Usuario> leeListaUsuarios(File fArchivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        HashMap<Integer, Usuario> listaUsr = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fArchivo));
            listaUsr = (HashMap<Integer, Usuario>) ois.readObject();
            for(int i=0; i<listaUsr.size();i++){
                System.out.println(listaUsr.get(i).getLogin()+ ":"+listaUsr.get(i).getPassword()+":"+
                        listaUsr.get(i).getEmail()+":"+listaUsr.get(i).getNombreCompleto());
            }
        }
        // Este catch debe ir antes que el de IOException.
        catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("No se encuentra archivo en m??todo leeListaUsuarios()");
        }
        catch (IOException ioe) {
            throw new IOException("Error al leer el objeto en m??todo leeListaUsuarios()",ioe);
        } catch (ClassNotFoundException cnfe) {
            throw new ClassNotFoundException("Error al leer el objeto en m??todo leeListaUsuarios()",cnfe);
        }
        finally {
            if (ois != null)
                ois.close();
        }
        return listaUsr;
    }


     
   }


