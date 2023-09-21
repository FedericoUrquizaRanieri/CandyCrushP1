package Juego;


import GUI.GUI;
import Juego.GeneradorDeNivel.GeneradorDeNivel;
import Tablero.Tablero;

/**
 * 
 */
public class Juego {

    //Atributos
    private GUI miGUI;
    private Tablero tablero;

    //Constructor
    public Juego() {
        int mov=GeneradorDeNivel.parseFile();
        int t=GeneradorDeNivel.parseFile();
        tablero=iniciarNivel(mov,t);
        miGUI=crearGUI();
    }
    //Metodos
    /**
     * @return
     */
    public Tablero iniciarNivel(int m,int t) {
        //cambiar con el generador
        return new Tablero(m,t);
    }
    /**
     * @return
     */
    public GUI crearGUI() {
        return new GUI(this);
    }
    /**
     * @return
     */
    public Tablero getTablero() {
        return tablero;
    }


}