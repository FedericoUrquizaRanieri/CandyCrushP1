package Entidad.Caramelo.CarameloPotenciador.Envuelto;

import Entidad.Caramelo.Caramelo;
import GUI.EntidadGrafica;
import Tablero.Tablero;

public class Envuelto extends Caramelo{

    public Envuelto(int n, int f, int c){
        //hacer case para enlazar el color del enum
        super(n, f, c);
        //eg=new EntidadGrafica();
    }
    public void destruirse(Tablero t){
        t.getEntidad(posf-1, posc-1).destruirse();
        t.getEntidad(posf-1, posc).destruirse();
        t.getEntidad(posf-1, posc+1).destruirse();
        t.getEntidad(posf, posc-1).destruirse();
        t.getEntidad(posf, posc+1).destruirse();
        t.getEntidad(posf+1, posc-1).destruirse();
        t.getEntidad(posf+1, posc).destruirse();
        t.getEntidad(posf+1, posc+1).destruirse();

        t.getGrilla()[posf][posc] = null;
        //eg.metodo para notificar a la gui del cambio
    }
}