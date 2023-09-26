package Tablero;

import java.util.Timer;
import java.util.TimerTask;

import Entidad.Entidad;
import Entidad.Gelatina.Gelatina;

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
        //no se que hago con el tiempo ayuda(milagro creo que lo arregle)
        class rt extends TimerTask{
            public void run(){
                vidas=0;
                //volver a lvl1?
            }
        }
        Timer t=new Timer();
        TimerTask terminar= new rt();
        t.schedule(terminar,tiempo*1000*60);
    }
    //Metodos
    /**
     * @return
     */
    public void llenarGrillaEspeciales(int x,int y) {
        grilla[x][y]=new Gelatina();
        //capaz es mejor idea hacer metodos separedos
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