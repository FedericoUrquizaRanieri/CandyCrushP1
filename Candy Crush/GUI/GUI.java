package GUI;

import javax.swing.JLabel;

import GUI.EntidadGrafica.EntidadGrafica;
import Juego.Juego;

public class GUI {

    //Atributos
    private Juego miJuego;
    private EntidadGrafica[][] grilla;
    //Contructor
    public GUI(Juego j) {
        miJuego=j;
        int k=j.getTablero().getTam();
        grilla=new EntidadGrafica[k][k];
    }
    //Metodos
    public void intercambiar(JLabel l){

    }
}