/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertiesmenu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 *
 * @author bth
 */
public class Idioma extends Properties {
    Properties propiedades= new Properties();
    
    public Properties cargarPropiedades(String nombreArchivo) {
        try {
            propiedades.loadFromXML(new FileInputStream(nombreArchivo));
            return propiedades;
        } catch (InvalidPropertiesFormatException ipfe){
            System.out.println("Error en las propiedades");
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo XML no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de E/S mientras se cargaban las propiedades");
        } 
        return propiedades;
    }
}
