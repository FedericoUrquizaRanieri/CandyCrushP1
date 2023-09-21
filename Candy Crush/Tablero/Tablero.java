package Tablero;

import Entidad.Entidad;

public class Tablero {

    //Atributos
    private int posX;
    private int tiempo;
    private int posY;
    private Entidad[][] grilla;
    private int vidas;
    private int movimientos;

    //Constructor
    public Tablero(int m,int t) {
        posX=0;
        posY=0;
        grilla=new Entidad[6][6];
        vidas=3;
        movimientos=m;
        tiempo=t;
    }
    //Metodos
    /**
     * @return
     */
    public void llenarGrillaEspeciales() {
    }

    /**
     * @param int n 
     * @return
     */
    public void crearGrilla( int n) {
    }

    /**
     * @return
     */
    public void generarCaramelos() {
    }

    /**
     * @return
     */
    public void checkSwap() {
    }

    /**
     * @return
     */
    public void doSwap() {
    }

    /**
     * @return
     */
    public void movePos(int x, int y) {
    }
    /**
     * @return
     */
    public void emptyT(){

    }
       /**
     * @return
     */
    public int getTam(){
        return grilla.length;
    }
}