package Entidad;

public class Gelatina extends Entidad{
    //Atributos
    private int posf;
    private int posc;
    private Caramelo caramelo;
    
    //Constructor
    public Gelatina(int f, int c, Color color){
        super(f,c);
        caramelo = new Caramelo(f,c, color);
        //coincidir con el enum
        //eg=new EntidadGrafica();
    }
    //Metodos
    public void setCaramelo(Caramelo c){

    }
    public Caramelo getCaramelo(){
        return caramelo;
    }
    public void destruirse(){

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
}
