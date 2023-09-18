package Juego;

import java.util.*;

import GUI.GUI;
import Tablero.Tablero;

/**
 * 
 */
public class Juego {

    /**
     * Default constructor
     */
    public Juego() {
        tablero=iniciarNivel();
        crearGUI();
    }

    /**
     * 
     */
    private GUI miGUI;
    /**
     * 
     */
    private Tablero tablero;

    /**
     * @return
     */
    public Tablero iniciarNivel() {
        return new Tablero();
    }

    /**
     * @return
     */
    public void crearGUI() {
        miGUI=new GUI();
    }

}