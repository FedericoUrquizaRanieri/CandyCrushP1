package Entidad;

import GUI.EntidadGrafica;
import Tablero.Tablero;

public abstract class Entidad implements Intercambiable{
    //Atributos
    protected EntidadGrafica eg;
    protected Color color;
    protected int fila;
    protected int columna;

    protected Entidad(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    //Metodos
    public void destruirse(Tablero t){
        eg.destruirse();
    }

    public void setEntidadGrafica(EntidadGrafica eg){
        this.eg = eg;
    }

    public EntidadGrafica getEntidadGrafica() {
        return eg;
    }
    public Color getColor() {
        return color;
    }
    public void cambiarPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        //eg.animarMovimiento();
    }

    // Matchea Con

    public boolean match_con(Caramelo caramelo) {
        return false;
    }
    public boolean match_con(RalladoV ralladoV) {
        return false;
    }
    public boolean match_con(RalladoH ralladoH) {
        return false;
    }
    public boolean match_con(Envuelto envuelto) {
        return false;
    }
    public boolean match_con(Glaseado glaseado) {
        return false;
    }

    // Destruirse


}