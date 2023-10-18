package Juego;
import java.awt.EventQueue;

import GUI.GUI;
import GUI.Threads.CentralAnimaciones;
import Nivel.Nivel;
import Tablero.Tablero;
import Entidad.Entidad;
import Entidad.Color;
import Entidad.Gelatina;
import GUI.EntidadGrafica;

public class Juego{
    //Atributos
    protected GUI miGUI;
    protected Tablero miTablero;
    protected Nivel miNivel;
    protected GeneradorDeNivel miGenerador;

    //Constructor
    public Juego(){
        miNivel = new Nivel(this,1);
        miTablero = new Tablero(this);
        miGUI = new GUI(this);
        miGenerador = new GeneradorDeNivel();
        regenerar(1);
    }

    public void notificarDestruccion(Color color) {
        miNivel.restarCaramelo(color);
    }

    //Metodos
    public void regenerar(int nivel){
        while(!miGUI.getPanel().getAnimacionesPendientes()){

        }
            miTablero.vaciarTablero();

            miGenerador.parseLvl(nivel,miTablero,miNivel);
    }

    public boolean moverCursor(int x,int y){
        return miTablero.setPosJugadorX(x) & miTablero.setPosJugadorY(y);
    }

    public void swap(int x, int y) {
        miTablero.swap(x, y);
    }

    public GUI getMiGUI() {
        return miGUI;
    }

    public void asociar_entidad_grafica(EntidadGrafica entidadGrafica) {
        miGUI.insertarEntidadGrafica(entidadGrafica);
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

    public Nivel getNivel(){
        return miNivel;
    }

    public int NivelActual(){
        return miNivel.getNivel();
    }

    //public void actualizarPantalla(){
        //GUI.actualizar();
    //}
}
