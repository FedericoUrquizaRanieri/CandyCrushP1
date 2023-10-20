package Nivel;

import java.util.Timer;
import java.util.TimerTask;

import Entidad.Color;
import Juego.Juego;

public class Nivel{
    //Atributos
    protected Juego miJuego;
    protected int nivel;
    protected int vidas = 3;
    protected int tiempo;
    protected int movimientos;
    protected int objetivoCaramelo;
    protected Color tipoCaramelo;
    protected int objetivoGlaseado;
    protected int objetivoGelOEnv;
    protected contadorTiempo time;



    //Constructor
    public Nivel(Juego j,int nivel){
        miJuego=j;
        this.nivel=nivel;
        tiempo = 300000;
        time = new contadorTiempo();
    }
        class contadorTiempo {
        Timer t;
        public contadorTiempo() {
            t = new Timer();
            t.scheduleAtFixedRate(new contador(), 0,1000);
        }
        class contador extends TimerTask {
            public void run() {
                if (tiempo > 0) {
                    tiempo--;
                    if(miJuego.getMiGUI()!=null)
                        miJuego.getMiGUI().notificarTiempo(tiempo);
                }
                else {
                    restarVida();
                }
            }
        }
    }
    public void restarVida(){
        vidas--;
        if(vidas==0){
            nivel=1;
            miJuego.regenerar(1);
            vidas=3;
        }
        else
            miJuego.regenerar(nivel);
    }
    public int getVidas(){
        return vidas;
    }
    public void setTiempo(String t){
        tiempo=(((t.charAt(0)-48)*10+t.charAt(1)-48)*60+((t.charAt(3)-48)*10+t.charAt(4)-48));
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
    public Color getColorObjetivo(){
        return tipoCaramelo;
    }
    public void setObjetivoCaramelo(int o, Color c){
        objetivoCaramelo=o;
        tipoCaramelo=c;
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
    public void restarCaramelo(Color c){
        if(objetivoCaramelo>0){
            if(c==tipoCaramelo){
                objetivoCaramelo--;
                miJuego.getMiGUI().notificarObjetivoCaramelo();
            }
        }
    }

    public void restarGlaseado(){
        if(objetivoGlaseado>0){
            objetivoGlaseado--;
            miJuego.getMiGUI().notificarObjetivoGlaseado();
        }
    }

    public void restarGelOEnv(){
        if(objetivoGelOEnv>0){
            objetivoGelOEnv--;
            miJuego.getMiGUI().notificarObjetivoGelOEnv();
        }
    }

    public void restarMov(){
        if(movimientos>0){
            movimientos--;
            miJuego.getMiGUI().notificarMovimiento();
        }
        if(movimientos==0){
            restarVida();
        }
    }

    public int getNivel(){
        return nivel;
    }

    public boolean objetivosTerminados(){
        return (objetivoCaramelo<=0 && objetivoGelOEnv<=0 && objetivoGlaseado<=0);
    }
    
    public void setNivel(int numero){
        nivel = numero;
    }
}