package Entidad.Caramelo;

import Entidad.Entidad;
import GUI.EntidadGrafica;
import Tablero.Tablero;
import Entidad.Color;

public class Caramelo extends Entidad{
    //Atributos

    public Caramelo(int f, int c, Color color){
        //hacer case para enlazar el color del enum
        super(f,c);
        this.color = color;
    }

    public void setEntidadGrafica(EntidadGrafica eg){
        this.eg = eg;
    }

    public void destruirse(Tablero t){
        eg.setLocation(eg.getX(), -100);
        t.getGrilla()[fila][columna] = null;
    }

    public Color getColor() {
        return color;
    }
}