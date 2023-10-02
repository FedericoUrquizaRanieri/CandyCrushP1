package Entidad.Caramelo.CarameloPotenciador.Envuelto;

import Entidad.Caramelo.Caramelo;
import GUI.EntidadGrafica;
import Entidad.Color;
import Tablero.Tablero;

public class Envuelto extends Caramelo{

    public Envuelto(int f, int c, Color color){
        //hacer case para enlazar el color del enum
        super(f, c, color);
        //eg=new EntidadGrafica();
    }
    public void destruirse(Tablero t){
        t.getEntidad(posf-1, posc-1).destruirse(t);
        t.getEntidad(posf-1, posc).destruirse(t);
        t.getEntidad(posf-1, posc+1).destruirse(t);
        t.getEntidad(posf, posc-1).destruirse(t);
        t.getEntidad(posf, posc+1).destruirse(t);
        t.getEntidad(posf+1, posc-1).destruirse(t);
        t.getEntidad(posf+1, posc).destruirse(t);
        t.getEntidad(posf+1, posc+1).destruirse(t);

        t.getGrilla()[posf][posc] = null;
        //eg.metodo para notificar a la gui del cambio
    }
}