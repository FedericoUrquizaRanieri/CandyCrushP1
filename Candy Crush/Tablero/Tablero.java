package Tablero;

import java.util.*;

import Entidad.Entidad;

/**
 * 
 */
public class Tablero {

    /**
     * Default constructor
     */
    public Tablero() {
        posicionX=0;
        posicionY=0;
        grilla=new Entidad[6][6];
        vidas=3;
        //agregar tiempo y movimientos que nos olvidamos
    }

    /**
     * 
     */
    private int posicionX;

    /**
     * 
     */
    private int tiempo;

    /**
     * 
     */
    private int posicionY;

    /**
     * 
     */
    private Entidad[][] grilla;

    /**
     * 
     */
    private int vidas;

    /**
     * @return
     */
    public void llenarGrillaEspeciales() {
        // TODO implement here
    }

    /**
     * @param int n 
     * @return
     */
    public void crearGrilla( int n) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void generarCaramelos() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void checkSwap() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void doSwap() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void cambiarPos() {
        // TODO implement here
    }

}