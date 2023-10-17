package Entidad;

import GUI.EntidadGrafica;
import Tablero.Tablero;
import utils.Utils;

public abstract class Entidad implements Intercambiable, Destruible, Matcheable{
    protected EntidadGrafica eg;
    protected Color color;
    protected int fila;
    protected int columna;
    protected String imagePath;

    protected Entidad(int fila, int columna,String i) {
        this.fila = fila;
        this.columna = columna;
        imagePath=i;
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
        eg.notificarCaida(Utils.labelPositionX(columna), Utils.labelPositionY(fila));
        this.fila = fila;
        this.columna = columna;
    }
    public boolean se_destruyen(Glaseado glaseado) {
        return false;
    }
    public String getImage(){
        return imagePath;
    }
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
}