package Entidad;

import Tablero.Tablero;

public class Glaseado extends Entidad{
    public Glaseado(int f, int c){
        super(f,c,"Candy Crush/Imagenes/Extras/Merengue.png");
        this.color = Color.NEGRO;
    }
    public void destruirse(Tablero t){
        t.getGrilla()[fila][columna] = null;
        eg.notificarDestruccion();
        eg = null;
        t.notificarDestruccion(this.color);
    }
    public boolean se_destruye_con(Entidad entidad) {
        return entidad.se_destruyen(this);
    }
    public void chequeoDestruccion(Tablero tablero){
        destruirse(tablero);
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

    public void cambiarPosicionCon(Entidad entidad, Tablero tablero) {

    }
    public void cambiarPosicion(Caramelo caramelo, Tablero tablero) {

    }
    public void cambiarPosicion(Gelatina gelatina, Tablero tablero) {

    }

    public boolean es_posible_intercambiar(Entidad e) {
        return false;
    };
    public boolean puede_recibir(Caramelo c) {
        return false;
    }
    public boolean puede_recibir(Glaseado g) {
        return false;
    }
    public boolean puede_recibir(Envuelto p) {
        return false;
    }
    public boolean puede_recibir(RalladoH rh) {
        return false;
    }
    public boolean puede_recibir(RalladoV rv) {
        return false;
    }

    public boolean match(Entidad entidad) {
        return false;
    }

    public boolean match_with(Caramelo caramelo) {
        return false;
    }

    public boolean match_with(RalladoH ralladoH) {
        return false;
    }

    public boolean match_with(RalladoV ralladoV) {
        return false;
    }

    public boolean match_with(Envuelto envuelto) {
        return false;
    }

    public boolean match_with(Glaseado glaseado) {
        return false;
    }
}