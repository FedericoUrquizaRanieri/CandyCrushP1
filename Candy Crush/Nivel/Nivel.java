package Nivel;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Juego.Juego;

public class Nivel{
    //Atributos
    protected Juego miJuego;
    protected int vidas=3;
    protected int tiempo;
    protected int movimientos;
    protected int objetivoCaramelo;
    //revisar esto con el enum
    protected int tipoCaramelo;
    protected int objetivoGlaseado;
    protected int objetivoGelOEnv;

    class contadorTiempo {
        Timer t;
        //cambiar el 2 por el tiempo del archivo
        public contadorTiempo() {
            t = new Timer();
            t.schedule(new contador(), 0,1000);
        }
        class contador extends TimerTask {
            public void run() {
                if (tiempo > 0) {
                    tiempo--;
                }
                else {
                    try {
                        restarVida();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    //Constructor
    public Nivel(Juego j){
        miJuego=j;
    }
    public void restarVida() throws IOException{
        vidas--;
        if(vidas==0)
            miJuego.regenerar(1);
    }
    public void setVidas(int v){
        vidas=v;
    }
    public int getVidas(){
        return vidas;
    }
    public void setTiempo(int t){
        tiempo=t;
        new contadorTiempo();
    }
    public void setMov(int m){
        movimientos=m;
    }
    public int getMov(){
        return movimientos;
    }
    public int getObjetivoCaramelo(){
        return objetivoCaramelo;
    }
    public void setObjetivoCaramelo(int o, int c){
        objetivoCaramelo=o;
        tipoCaramelo=c;
        //que caramelo es no se
    }
    public int getObjetivoGlaseado(){
        return objetivoGlaseado;
    }
    public void setObjetivoGlaseado(int o){
        objetivoGlaseado=o;
    }
    public int getObjetivoGelOEnv(){
        return objetivoGelOEnv;
    }
    public void setObjetivoGelOEnv(int o){
        objetivoGelOEnv=o;
    }
}