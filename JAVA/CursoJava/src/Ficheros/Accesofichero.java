package Ficheros;

import java.io.*;

public class Accesofichero{
	public static void main(String[] args){

		File ruta = new File("Ejemplos");
		String[] nombresArchivos=ruta.list();

		for(int i=0; i<nombresArchivos.length; i++){
			System.out.println(nombresArchivos[i]);

			File f=new File(ruta.getAbsolutePath(),nombresArchivos[i]);

			if(f.isDirectory()){
				String[] archivosSubcarpeta=f.list();

				for(int j=0;j<archivosSubcarpeta.length;j++){
					System.out.println(archivosSubcarpeta[j]);
				}
			}

		}
	}
}