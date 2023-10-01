package Entidad.Gelatina;

import Entidad.Entidad;
import Entidad.Caramelo.Caramelo;
import GUI.EntidadGrafica;

public class Gelatina extends Entidad{
    //Atributos
    private Caramelo caramelo;
    //Constructor
    public Gelatina(){
        caramelo=new Caramelo((int)(Math.random() * ((6 - 1) + 1)) + 1);
        //coincidir con el enum
        eg=new EntidadGrafica();
    }
    //Metodos
    public void setCaramelo(Caramelo c){

    }
    public Caramelo getCaramelo(){
        return caramelo;
    }
    public void destruirse(){
        
    }
}
