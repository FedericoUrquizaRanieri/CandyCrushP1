package Entidad;

import GUI.EntidadGrafica;
import Tablero.Tablero;

public abstract class Entidad implements Intercambiable{
    //Atributos
    protected EntidadGrafica eg;
    protected Color color;
    protected int fila;
    protected int columna;
    protected String imagePath;

    private final int labelWidth = 60;
    private final int labelSpacing = 5;
    private final int labelHeight = 60;

    protected Entidad(int fila, int columna,String i) {
        this.fila = fila;
        this.columna = columna;
        imagePath=i;
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
        eg.notificarCambioPosicion(columna * (labelSpacing + labelWidth) + labelSpacing, fila * (labelSpacing + labelHeight) + labelSpacing);
    }
    public String getImage(){
        return imagePath;
    }

    // Destruirse


}