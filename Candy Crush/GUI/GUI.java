package GUI;

import javax.swing.JFrame;

import Juego.Juego;

public class GUI extends JFrame{
    //Atributos
    private Juego miJuego;
    //Constructor
    public GUI(Juego j){
        miJuego=j;
    }
    //Metodos
    public void moverCursor(int x,int y){
        if(!(miJuego.moverCursor(x,y))){
            //deshacer cambio
        }
    }
}