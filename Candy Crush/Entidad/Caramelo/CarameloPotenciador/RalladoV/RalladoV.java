package Entidad.Caramelo.CarameloPotenciador.RalladoV;

import Entidad.Caramelo.Caramelo;
import Entidad.Color;
import GUI.EntidadGrafica;
import Tablero.Tablero;

public class RalladoV extends Caramelo{

    //Constructor
    public RalladoV(int f, int c, Color color){
        //hacer case para enlazar el color del enum
        super(f, c, color);
        //eg=new EntidadGrafica();
    }

    //Metodos
    public void destruirse(Tablero t){
        for(int i=0; i<t.getDimension(); i++){
            if(i != posf && t.getEntidad(i, posc) != null){
                t.getEntidad(i, posc).destruirse(t);
            }
        }
        t.getGrilla()[posf][posc] = null;
        //eg.metodo para notificar a la gui del cambio
    }
} 