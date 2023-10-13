package Entidad;

import Tablero.Tablero;

public class RalladoV extends Caramelo{
    boolean explotando;
    //Constructor
    public RalladoV(int f, int c, Color color){
        //hacer case para enlazar el color del enum
        super(f, c, color);
        this.explotando = false;
        imagePath="Candy Crush/Imagenes/Rallados/RalladosV/"+ color.toString().toUpperCase()+".png";
        //eg=new EntidadGrafica();
    }

    //Metodos
    public void destruirse(Tablero t){
        if(!explotando) {
            explotando = true;
            for(int i=0; i<t.getDimension(); i++){
                if(i != fila && t.getEntidad(i, columna) != null){
                    t.getEntidad(i, columna).destruirse(t);
                }
            }
            t.getGrilla()[fila][columna] = null;
            eg.destruirse();
        }
    }

    public boolean es_posible_intercambiar(Entidad e) {
        return e.puede_recibir(this);
    }
} 