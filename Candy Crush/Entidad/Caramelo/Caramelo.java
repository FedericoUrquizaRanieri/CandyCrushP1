package Entidad.Caramelo;

import Entidad.Entidad;
import GUI.EntidadGrafica;
import Tablero.Tablero;

public class Caramelo extends Entidad{
    //Atributos
    protected EntidadGrafica eg;
    protected int posf;
    protected int posc;

    public Caramelo(int n, int f, int c){
        //hacer case para enlazar el color del enum
        posf = f;
        posc = c;
        eg=new EntidadGrafica();
    }
    public void destruirse(Tablero t){
        t.getGrilla()[posf][posc] = null;
    }
}