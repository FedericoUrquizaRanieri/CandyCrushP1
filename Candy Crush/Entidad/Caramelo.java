package Entidad;

import GUI.EntidadGrafica;
import Tablero.Tablero;

public class Caramelo extends Entidad{
    //Atributos

    public Caramelo(int f, int c, Color color){
        //hacer case para enlazar el color del enum
        super(f,c,"Candy Crush/Imagenes/Caramelos/"+ color.toString().toLowerCase()+".png");
        this.color = color;
    }

    public void setEntidadGrafica(EntidadGrafica eg){
        this.eg = eg;
    }

    public void destruirse(Tablero t){
        eg.destruirse();
        t.getGrilla()[fila][columna] = null;
    }

    public Color getColor() {
        return color;
    }
    public boolean es_posible_intercambiar(Entidad e) {
        return e.puede_recibir(this);
    };
    public boolean puede_recibir(Caramelo c) {
        return true;
    }
    public boolean puede_recibir(Glaseado g) {
        return false;
    }
    public boolean puede_recibir(Envuelto p) {
        return true;
    }
    public boolean puede_recibir(RalladoH rh) {
        return true;
    }
    public boolean puede_recibir(RalladoV rv) {
        return true;
    }
}