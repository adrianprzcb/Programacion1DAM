package builder;

public class Principal {
    public static void main(String[] args) {
        Vehiculo vehiculo;
        CadenaMontaje cadenaMontaje = new CadenaMontaje();
        Builder montaToyotaRAV4 = new MontaToyotaRAV4();
        cadenaMontaje.setBuilder(montaToyotaRAV4); //Establece el modelo a construir
        cadenaMontaje.montarVehiculo(); //Monta el vehículo
        vehiculo = cadenaMontaje.getVehiculo(); //Devuelve el último vehículo montado
        mostrarDatos(vehiculo);
    }

    private static void mostrarDatos(Vehiculo vehiculo) {
        System.out.println("Datos del vehículo montado:");
        System.out.println("Bastidor: "+vehiculo.getNumBastidor());
        System.out.println("Número de puertas: "+vehiculo.getNumPuertas());
        System.out.println("Fecha fabricación: "+vehiculo.getFechaFabricacion());
        
        System.out.println("Motor: ");
        System.out.println(vehiculo.getMotor());
        System.out.println("Dimensiones: ");
        System.out.println(vehiculo.getDimensiones());
        System.out.println("Matrícula: ");
        System.out.println(vehiculo.getMatricula());
        System.out.println("Color: ");
        System.out.println(vehiculo.getColor());
        System.out.println("Modelo y Fabricante:");
        System.out.println(vehiculo.getModelo());
    }
}
