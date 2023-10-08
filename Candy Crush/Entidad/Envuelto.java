package Entidad;

import Tablero.Tablero;

public class Envuelto extends Caramelo{

    public Envuelto(int f, int c, Color color){
        //hacer case para enlazar el color del enum
        super(f, c, color);
        //eg=new EntidadGrafica();
    }

    public Color getColor() {
        return color;
    }
    
    public void destruirse(Tablero t){
        t.getEntidad(fila-1, columna-1).destruirse(t);
        t.getEntidad(fila-1, columna).destruirse(t);
        t.getEntidad(fila-1, columna+1).destruirse(t);
        t.getEntidad(fila, columna-1).destruirse(t);
        t.getEntidad(fila, columna+1).destruirse(t);
        t.getEntidad(fila+1, columna-1).destruirse(t);
        t.getEntidad(fila+1, columna).destruirse(t);
        t.getEntidad(fila+1, columna+1).destruirse(t);

        t.getGrilla()[fila][columna] = null;
        //eg.metodo para notificar a la gui del cambio
    }

    public boolean match_con(RalladoV ralladoV) {
        return true;
    }
    public boolean match_con(RalladoH ralladoH) {
        return true;
    }
    public boolean match_con(Envuelto envuelto) {
        return true;
    }
}