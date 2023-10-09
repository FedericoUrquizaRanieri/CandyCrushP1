package Entidad;

import Tablero.Tablero;

public class RalladoH extends Caramelo{

    //Constructor
    public RalladoH(int f, int c, Color color){
        //hacer case para enlazar el color del enum
        super(f, c, color);
        imagePath="Imagenes/Rallados/RalladosH/"+ color.toString().toUpperCase()+".png";
        //eg=new EntidadGrafica();
    }

    //Metodos
    public void destruirse(Tablero t){
        for(int i=0; i<t.getDimension(); i++){
            if(i != columna && t.getEntidad(fila, i) != null){
                t.getEntidad(fila, i).destruirse(t);
            }
        }
        t.getGrilla()[fila][columna] = null;
        //eg.metodo para notificar a la gui del cambio
    }

    public boolean es_posible_intercambiar(Entidad e) {
        return e.puede_recibir(this);
    }
}
