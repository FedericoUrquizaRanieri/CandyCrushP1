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
                    miJuego.getMiGUI().notificarTiempo(tiempo);
                }
                else {
                    restarVida();
                    t.cancel();
                }
            }
        }
    }

    //Constructor
    public Nivel(Juego j,int nivel){
        miJuego=j;
        this.nivel=nivel;
    }
    public void restarVida(){
        vidas--;
        miJuego.regenerar(nivel);
        if(vidas==0){
            miJuego.regenerar(1);
            vidas=3;
        }
    }
    public int getVidas(){
        return vidas;
    }
    public void setTiempo(String t){
        tiempo=(((t.charAt(0)-48)*10+t.charAt(1)-48)*60+((t.charAt(3)-48)*10+t.charAt(4)-48));
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
        if(c==tipoCaramelo){
            objetivoCaramelo--;
            if(objetivoCaramelo==0){
                miJuego.regenerar(++nivel);
                miJuego.getMiGUI().notificarMovimiento();
            }
        }
    }
    public void restarGlaseado(){
        objetivoGlaseado--;
        if(objetivoGlaseado==0){
            miJuego.regenerar(++nivel);
            miJuego.getMiGUI().notificarMovimiento();
        }
    }
    public void restarGelOEnv(){
        objetivoGelOEnv--;
        if(objetivoGelOEnv==0){
            miJuego.regenerar(++nivel);
            miJuego.getMiGUI().notificarMovimiento();
        }
    }
    public void restarMov(){
        movimientos--;
        if(movimientos==0){
            vidas--;
            miJuego.getMiGUI().notificarMovimiento();
        }
    }

    public int getNivel(){
        return nivel;
    }


}