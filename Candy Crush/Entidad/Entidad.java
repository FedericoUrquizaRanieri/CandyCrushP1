package Entidad;

import GUI.EntidadGrafica;
import Entidad.Color;
import Tablero.Tablero;

public abstract class Entidad {
    //Atributos
    protected EntidadGrafica eg;
    protected Color color;
    protected int fila;
    protected int columna;
    protected String path_img;

    protected Entidad(int fila, int columna, Color color, String path_img) {
        this.fila = fila;
        this.columna = columna;
        this.color = color;
        this.path_img = path_img;
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
}