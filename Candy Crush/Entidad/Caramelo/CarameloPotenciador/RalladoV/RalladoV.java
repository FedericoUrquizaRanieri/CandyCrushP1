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
            if(i != fila && t.getEntidad(i, columna) != null){
                t.getEntidad(i, columna).destruirse(t);
            }
        }
        t.getGrilla()[fila][columna] = null;
        //eg.metodo para notificar a la gui del cambio
    }

    public boolean match_con(RalladoV ralladoV) {
        return true;
    }
    public boolean match_con(Entidad.Caramelo.CarameloPotenciador.RalladoH.RalladoH ralladoH) {
        return true;
    }
    public boolean match_con(Entidad.Caramelo.CarameloPotenciador.Envuelto.Envuelto envuelto) {
        return true;
    }
} 