package Entidad.Gelatina;


import Entidad.Entidad;
import Entidad.Caramelo.Caramelo;

public class Gelatina extends Entidad {
    //Atributos
    private Caramelo caramelo;
    //Constructor
    public Gelatina() {
        caramelo=new Caramelo();
    }
    //Metodos
    /**
     * @return
     */
    public void Inmolarse() {
        //kys
        caramelo.Inmolarse();
    }
}