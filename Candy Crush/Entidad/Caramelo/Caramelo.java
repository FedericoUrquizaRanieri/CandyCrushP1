package Entidad.Caramelo;

import Entidad.Entidad;
import GUI.EntidadGrafica;
import Tablero.Tablero;

public class Caramelo extends Entidad{
    //Atributos
    private EntidadGrafica eg;
    private int posf;
    private int posc;

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