package Entidad.Glaseado;

import Entidad.Entidad;
import GUI.EntidadGrafica;

public class Glaseado extends Entidad{
    //Atributos
    private EntidadGrafica eg;
    private int posf;
    private int posc;

    public Glaseado(int n, int f, int c){
        posf = f;
        posc = c;
        //eg = new EntidadGrafica();
    }
    public void destruirse(){
        
    }
}