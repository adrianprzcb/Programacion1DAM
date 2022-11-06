package modelo.beans;

import java.util.List;



public class Jugador {
    private String nombre;
    private int valorTirada1;
    private int valorTirada2;
    private int valorTirada3;
    private int valorTiradaPartida;
    private int valorTotal;
    private Dado dado1;
    private Dado dado2;
    private Dado dado3;

    public Jugador(String nombre){
        this.nombre = nombre;
        dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
    }

    public String getNombre() {
        return nombre;
    }

    public int getValorTirada1() {
        return valorTirada1;
    }

    public void setValorTirada1(int valorTirada1) {
        this.valorTirada1 = valorTirada1;
    }

    public int getValorTirada2() {
        return valorTirada2;
    }

    public void setValorTirada2(int valorTirada2) {
        this.valorTirada2 = valorTirada2;
    }

    public int getValorTirada3() {
        return valorTirada3;
    }

    public void setValorTirada3(int valorTirada3) {
        this.valorTirada3 = valorTirada3;
    }

    public int getValorTiradaPartida() {
        return valorTiradaPartida;
    }

    public void setValorTiradaPartida(int valorTiradaPartida) {
        this.valorTiradaPartida = valorTiradaPartida;
    }

    public Dado getDado1() {
        return dado1;
    }

    public Dado getDado2() {
        return dado2;
    }

    public Dado getDado3() {
        return dado3;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String toString(){
        return "El jugador: "+nombre+" ha obtenido una puntuacion total de: "+valorTotal;
    }

}
