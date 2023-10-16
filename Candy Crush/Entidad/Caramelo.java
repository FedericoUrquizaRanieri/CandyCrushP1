package Entidad;

import GUI.EntidadGrafica;
import Tablero.Tablero;

public class Caramelo extends Entidad{

    public Caramelo(int f, int c, Color color){
        super(f,c,"Candy Crush/Imagenes/Caramelos/"+ color.toString().toLowerCase()+".png");
        this.color = color;
    }

    public void setEntidadGrafica(EntidadGrafica eg){
        this.eg = eg;
    }

    public Color getColor() {
        return color;
    }

    public void destruirse(Tablero t){
        t.getGrilla()[fila][columna] = null;
        eg.destruirse();
    }

    public boolean se_destruye_con(Entidad entidad) {
        return entidad.se_destruyen(this);
    }
    public boolean se_destruyen(Caramelo caramelo) {
        return false;
    }
    public boolean se_destruyen(RalladoH ralladoH) {
        return false;
    }
    public boolean se_destruyen(RalladoV ralladoV) {
        return false;
    }
    public boolean se_destruyen(Envuelto envuelto) {
        return false;
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

    public boolean match(Entidad entidad) {
        return entidad.match_with(this);
    }
    public boolean match_with(Caramelo caramelo) {
        return this.color == caramelo.getColor();
    }
    public boolean match_with(RalladoH ralladoH) {
        return this.color == ralladoH.getColor();
    }
    public boolean match_with(RalladoV ralladoV) {
        return this.color == ralladoV.getColor();
    }
    public boolean match_with(Envuelto envuelto) {
        return this.color == envuelto.getColor();
    }
    public boolean match_with(Glaseado glaseado) {
        return false;
    }
}