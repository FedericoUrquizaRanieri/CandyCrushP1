package Entidad;

public class Glaseado extends Entidad{
    public Glaseado(int f, int c){
        super(f,c,"Candy Crush/Imagenes/Extras/Merengue.png");
    }
    public void destruirse(){
        
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
}