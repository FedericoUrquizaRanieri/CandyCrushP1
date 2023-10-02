package Entidad.Caramelo;

import Entidad.Entidad;
import GUI.EntidadGrafica;
import Tablero.Tablero;
import Entidad.Color;

public class Caramelo extends Entidad{
    //Atributos
    protected EntidadGrafica eg;
    protected int posf;
    protected int posc;

    protected Color color;

    public Caramelo(int f, int c, Color color){
        //hacer case para enlazar el color del enum
        posf = f;
        posc = c;
        this.color = color;
        //eg=new EntidadGrafica();
    }

    public void setEntidadGrafica(EntidadGrafica eg){
        this.eg = eg;
    }

    public void destruirse(Tablero t){
        eg.setLocation(eg.getX(), -100);
        t.getGrilla()[posf][posc] = null;
    }

    public Color getColor() {
        return color;
    }
}