package Entidad;

import GUI.EntidadGrafica;
import Tablero.Tablero;
import utils.Utils;

public abstract class Entidad implements Intercambiable, Destruible{
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
//    public void cambiarPosicion(int fila, int columna) {
//        this.fila = fila;
//        this.columna = columna;
//        eg.notificarCambioPosicion(Utils.labelPositionX(columna), Utils.labelPositionY(fila));
//    }
    public void cambiarPosicion(Entidad entidad) {
        int fila = entidad.getFila();
        int columna = entidad.getColumna();
        entidad.setFila(this.fila);
        entidad.setColumna(this.columna);
        this.fila = fila;
        this.columna = columna;
        eg.notificarCambioPosicion(entidad.getEntidadGrafica());
//        int toX = eg.getX();
//        int toY = eg.getY();
//        eg.setLocation(entidad.getEntidadGrafica().getX(), entidad.getEntidadGrafica().getY());
//        entidad.getEntidadGrafica().setLocation(toX, toY);
    }
    public void cambiarPosicion(int fila, int columna) {
        eg.notificarCaida(Utils.labelPositionX(columna), Utils.labelPositionY(fila));
        //eg.setLocation(Utils.labelPositionX(columna), Utils.labelPositionY(fila));
        this.fila = fila;
        this.columna = columna;
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