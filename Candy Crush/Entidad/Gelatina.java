package Entidad;

import Tablero.Tablero;

public class Gelatina extends Entidad{

    private Caramelo caramelo;

    public Gelatina(int f, int c, Color color){
        super(f,c,"Candy Crush/Imagenes/Extras/Gelatina.png");
        this.color = Color.GRIS;
        caramelo = new Caramelo(f,c, color);
    }

    public void setCaramelo(Caramelo caramelo){
        this.caramelo = caramelo;
    }

    public void cambiarPosicion(int fila, int columna) {
        caramelo.cambiarPosicion(fila,columna);
    }

    public void cambiarPosicion(Entidad entidad) {
        caramelo.cambiarPosicion(entidad);
    }

    public Caramelo getCaramelo(){
        return caramelo;
    }

    public void destruirse(Tablero t){
        t.getGrilla()[fila][columna] = null;
        eg.destruirse();
        caramelo.destruirse(t);
        caramelo = null;
    }
    public boolean se_destruye_con(Entidad entidad) {
        return entidad.se_destruyen(caramelo);
    }
    public boolean se_destruyen(Caramelo caramelo) {
        return false;
    }
    public boolean se_destruyen(RalladoH ralladoH) {
        return ralladoH.se_destruyen(caramelo);
    }
    public boolean se_destruyen(RalladoV ralladoV) {
        return ralladoV.se_destruyen(caramelo);
    }
    public boolean se_destruyen(Envuelto envuelto) {
        return envuelto.se_destruyen(caramelo);
    }

    public boolean es_posible_intercambiar(Entidad e) {
        return e.puede_recibir(this.getCaramelo());
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
        return entidad.match_with(this.caramelo);
    }
    public boolean match_with(Caramelo caramelo) {
        return this.caramelo.getColor() == caramelo.getColor();
    }
    public boolean match_with(RalladoH ralladoH) {
        return this.caramelo.getColor() == ralladoH.getColor();
    }
    public boolean match_with(RalladoV ralladoV) {
        return this.caramelo.getColor() == ralladoV.getColor();
    }
    public boolean match_with(Envuelto envuelto) {
        return this.caramelo.getColor() == envuelto.getColor();
    }
    public boolean match_with(Glaseado glaseado) {
        return false;
    }
}
