package Entidad;

public class Glaseado extends Entidad{
    public Glaseado(int f, int c){
        super(f,c);
    }
    public void destruirse(){
        
    }

    public boolean puedeRecibir(Caramelo caramelo) {
        return false;
    }
    public boolean puedeRecibir(Envuelto envuelto) {
        return false;
    }
    public boolean puedeRecibir(RalladoV ralladoV) {
        return false;
    }
    public boolean puedeRecibir(RalladoH ralladoH) {
        return false;
    }
}