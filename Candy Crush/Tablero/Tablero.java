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
    public Tablero(int movimientos,int tiempo, int dimension) {
        posX=0;
        posY=0;
        grilla=new Entidad[dimension][dimension];
        vidas=3;
        this.movimientos=movimientos;
        this.tiempo=tiempo;
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
        //hacer cambio primero
        movimientos--;
        if(movimientos==0)
            vidas--;
        if(vidas==0){

        }
        //volver a lvl1
    }

    /**
     * @return
     */
    public void movePos(int x, int y) {
        if(posX+x>=0 || posX+x<=grilla.length)
            posX=posX+x;
        if(posY+y>=0 || posY+y<=grilla.length)
            posY=posY+y;
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