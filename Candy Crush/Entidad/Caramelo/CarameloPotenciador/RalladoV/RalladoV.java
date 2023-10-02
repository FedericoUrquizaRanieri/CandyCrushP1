package Entidad.Caramelo.CarameloPotenciador.RalladoV;

import Entidad.Caramelo.Caramelo;
import GUI.EntidadGrafica;
import Tablero.Tablero;

public class RalladoV extends Caramelo{
    //Atributos
    private EntidadGrafica eg;
    private int posf;
    private int posc; 

    //Constructor
    public RalladoV(int n, int f, int c){
        //hacer case para enlazar el color del enum
        super(n, f, c);
        eg=new EntidadGrafica();
    }

    //Metodos
    public void destruirse(Tablero t){
        for(int i=0; i<t.getDimension(); i++){
            if(i != posf && t.getEntidad(i, posc) != null){
                t.getEntidad(i, posc).destruirse();
            }
        }
        t.getGrilla()[posf][posc] = null;
        //eg.metodo para notificar a la gui del cambio
    }
} 