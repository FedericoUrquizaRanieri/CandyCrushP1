package Entidad.Caramelo.CarameloPotenciador.RalladoH;

import Entidad.Caramelo.Caramelo;
import GUI.EntidadGrafica;
import Tablero.Tablero;

public class RalladoH extends Caramelo{

    //Constructor
    public RalladoH(int n, int f, int c){
        //hacer case para enlazar el color del enum
        super(n, f, c);
        eg=new EntidadGrafica();
    }

    //Metodos
    public void destruirse(Tablero t){
        for(int i=0; i<t.getDimension(); i++){
            if(i != posc && t.getEntidad(posf, i) != null){
                t.getEntidad(posf, i).destruirse();
            }
        }
        t.getGrilla()[posf][posc] = null;
        //eg.metodo para notificar a la gui del cambio
    }
}
