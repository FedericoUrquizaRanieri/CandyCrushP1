package Entidad.Gelatina;

import Entidad.Entidad;
import Entidad.Caramelo.Caramelo;
import GUI.EntidadGrafica;

public class Gelatina extends Entidad{
    //Atributos
    private int posf;
    private int posc;
    private Caramelo caramelo;
    
    //Constructor
    public Gelatina(){
        caramelo = null;
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
}
