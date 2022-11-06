package dam.prog.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Jugador {

    private String nombre;
    private ArrayList<Dado> cubilete;
    private HashMap<CarasDadoPoker,Integer> ultimaJugada;
    private int puntosTotales;
    private int partidasGanadas;

    public Jugador(String nombre, int numDados) {
        this.partidasGanadas = 0;
        this.puntosTotales = 0;
        this.nombre = nombre;
        this.cubilete = new ArrayList<>();
        dadosAlCubilete(numDados);
    }

    private void dadosAlCubilete(int numDados) {
        for (int i = 0; i < numDados; i++) {
            cubilete.add(new Dado());
        }
    }

    public HashMap<CarasDadoPoker, Integer> lanzarDados() {
        int puntos = 0;
        CarasDadoPoker resultado;
        this.ultimaJugada = creaJugada();
        for (Dado dado: cubilete) {
            resultado = lanzarDado(dado);
            actualizaJugada(this.ultimaJugada, resultado);
        }
        System.out.println(this.ultimaJugada);
        return this.ultimaJugada;
    }

    private HashMap<CarasDadoPoker, Integer> creaJugada() {
        HashMap<CarasDadoPoker,Integer> jugada = new HashMap<CarasDadoPoker,Integer>();
        jugada.put(CarasDadoPoker.AS, 0);
        jugada.put(CarasDadoPoker.K, 0);
        jugada.put(CarasDadoPoker.Q, 0);
        jugada.put(CarasDadoPoker.J, 0);
        jugada.put(CarasDadoPoker.ROJO, 0);
        jugada.put(CarasDadoPoker.NEGRO, 0);
        return jugada;
    }

    private void actualizaJugada(HashMap<CarasDadoPoker, Integer> jugada, CarasDadoPoker resultado) {
        int total;
        total = jugada.get(resultado)+1;
        jugada.put(resultado,total);
    }

    private CarasDadoPoker lanzarDado(Dado dado) {
        int resultado;

        resultado = calcularAleatorio(dado.getNumCaras());
        return getCaraDadoPoker(resultado);
    }

    private CarasDadoPoker getCaraDadoPoker(int resultado) {
        CarasDadoPoker cara;
        switch (resultado) {
            case 1:cara = CarasDadoPoker.AS; break;
            case 2:cara = CarasDadoPoker.K; break;
            case 3:cara = CarasDadoPoker.Q; break;
            case 4:cara = CarasDadoPoker.J; break;
            case 5:cara = CarasDadoPoker.ROJO; break;
            case 6:cara = CarasDadoPoker.NEGRO; break;
            default:
                throw new IllegalStateException("Unexpected value: " + resultado);
        }
        return cara;
    }

    public int calcularAleatorio(int limSuperior) {
        return (new Random()).nextInt(limSuperior) + 1;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public HashMap<CarasDadoPoker, Integer> getUltimaJugada() {
        return ultimaJugada;
    }

    public String getNombre() {
        return nombre;
    }

    public int incrementaPartidasGanadas() {
        this.partidasGanadas = this.getPartidasGanadas() + 1;
        return this.getPartidasGanadas();
    }

    public int incrementaPuntosTotales(int puntos) {
        this.puntosTotales = this.getPuntosTotales() + puntos;
        return getPuntosTotales();
    }




}
