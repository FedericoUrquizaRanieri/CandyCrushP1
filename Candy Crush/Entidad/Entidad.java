package Entidad;

import GUI.EntidadGrafica;
import Entidad.Color;
import Tablero.Tablero;

public abstract class Entidad {
    //Atributos
    protected EntidadGrafica eg;
    protected Color color;
    //Metodos
    public void destruirse(Tablero t){
        
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
}