package ejlectura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjemploLectura {
    // Compartiendo los métodos el objeto producto como una variable de ejecutar()
    public void ejecutar() {
        // Declaraciones
        Producto producto = null;

        producto = leerProducto();
        mostrarProducto(producto);
        // FIN
    }

    private Producto leerProducto() {
        String cadena;
        Producto producto = null;
        BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(System.in));
        // Toma de datos
        try {
            System.out.print("Introduzca referencia del producto: ");
            cadena = flujoEntrada.readLine();
            producto = new Producto(cadena);
            System.out.print("Introduzca nivel stock: ");
            cadena = flujoEntrada.readLine();
            producto.setNivelStock(Integer.parseInt(cadena));
            System.out.print("Introduzca precio: ");
            cadena = flujoEntrada.readLine();
            producto.setPrecio(Double.parseDouble(cadena));
        }
        catch (IOException ioe) {
            System.out.println("Se ha producido un error en la toma de datos. El producto no se crea.");
            if (producto != null)
                producto = null;
        }
        catch (NumberFormatException nfe) {
            System.out.println("Se ha producido un error en el formato de los datos. El producto no se crea.");
            if (producto != null)
                producto = null;
        }
        return producto;
    }

    private void mostrarProducto(Producto producto) {
        // Muestra datos producto
        if (producto != null) {
            System.out.println("Datos del producto: "+producto.getReferencia());
            System.out.println("Nivel stock: "+producto.getNivelStock());
            System.out.println("Precio: "+producto.getPrecio());
        }
        else System.out.println("Producto nulo.");
    }
}
