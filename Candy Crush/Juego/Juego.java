package Juego;
import java.awt.EventQueue;
import java.io.IOException;

import GUI.GUI;
import Juego.GeneradorDeNivel.GeneradorDeNivel;
import Nivel.Nivel;
import Tablero.Tablero;
public class Juego{
    //Atributos
    protected GUI miGUI;
    protected Tablero miTablero;
    protected Nivel miNivel;

    //Constructor
    public Juego() throws IOException{  //esta exception me tiene que me quiero matar, hay que corregirla
        miTablero = new Tablero(this);
        System.out.println("TABLERO");
        miGUI = new GUI(this);
        System.out.println("GUI");
        miNivel = new Nivel(this);
        System.out.println("NIVEL");
        //Asociar entidades
        regenerar(1);
    }

    //Metodos
    public void regenerar(int i) throws IOException{
        generarNivel(i);
        System.out.println("nivel generacion");
        generarTablero(i);
    }
    private void generarNivel(int i) throws IOException{
        GeneradorDeNivel.generarNivel(i,miNivel);
    }
    private void generarTablero(int i) throws IOException{
        GeneradorDeNivel.generarTablero(i, miTablero);
    }
    public boolean moverCursor(int x,int y){
        return miTablero.setPosJugadorX(x) && miTablero.setPosJugadorY(y);
    }
    public void swap(){

    }
    public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	new Juego();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
