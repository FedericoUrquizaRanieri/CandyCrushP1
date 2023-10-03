package Juego;
import java.awt.EventQueue;
import java.io.IOException;

import GUI.GUI;
import Juego.GeneradorDeNivel.GeneradorDeNivel;
import Nivel.Nivel;
import Tablero.Tablero;
import Entidad.Entidad;
import GUI.EntidadGrafica;
import Entidad.Caramelo.Caramelo;

public class Juego{
    //Atributos
    protected GUI miGUI;
    protected Tablero miTablero;
    protected Nivel miNivel;

    //Constructor
    public Juego() throws IOException{  //esta exception me tiene que me quiero matar, hay que corregirla
        miNivel = new Nivel(this);
        miTablero = new Tablero(this);
        miGUI = new GUI(this);
        //Asociar entidades
        regenerar(1);
        asociar_entidades_logicas_graficas();
    }

    //Metodos
    public void regenerar(int i) throws IOException{
        generarNivel(i);
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
    public boolean haySwapValido(int x, int y){
        return true;
    }

    public void crushCandy() {
        miTablero.crushCandy();
        for(int i=0;i< miTablero.getDimension();i++) {
            for (int j = 0; j < miTablero.getDimension(); j++) {
                if(miTablero.getEntidad(i,j) == null) {
                    System.out.print("NULO - ");
                } else System.out.print(miTablero.getEntidad(i,j).getColor() + " - ");
            }
            System.out.println('\n');
        }
    }
    private void asociar_entidades_logicas_graficas() {
        Entidad e;
        EntidadGrafica eg;

        for (int f=0; f<miTablero.getDimension(); f++) {
            for (int c=0; c<miTablero.getDimension(); c++) {
                e = miTablero.getEntidad(f,c);
                eg = new EntidadGrafica(f,c,e.getColor());
                e.setEntidadGrafica(eg);
                miGUI.insertarEntidadGrafica(eg);
            }
        }
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
