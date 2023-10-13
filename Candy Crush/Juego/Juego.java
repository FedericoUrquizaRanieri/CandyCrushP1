package Juego;
import java.awt.EventQueue;

import GUI.GUI;
import Nivel.Nivel;
import Tablero.Tablero;
import Entidad.Entidad;
import Entidad.Gelatina;
import GUI.EntidadGrafica;
import utils.Utils;

public class Juego{
    //Atributos
    protected GUI miGUI;
    protected Tablero miTablero;
    protected Nivel miNivel;

    //Constructor
    public Juego(){
        miNivel = new Nivel(this);
        miTablero = new Tablero(this);
        miGUI = new GUI(this);
        regenerar(1);
    }

    //Metodos
    public void regenerar(int i){
        GeneradorDeNivel.generarNivel(i,miNivel);
        //GeneradorDeNivel.generarGelatina(i, miTablero);
        //asociar_gelatinas_graficas();
        //GeneradorDeNivel.generarMerengue(i, miTablero);
        GeneradorDeNivel.generarCaramelos(miTablero); // Genero caramelos especiales para testear funcionamiento
        // To Do funcion para dejar al tablero sin ningun match
        //miTablero.crushCandy();
        asociar_entidades_logicas_graficas();
    }
    public boolean moverCursor(int x,int y){
        return miTablero.setPosJugadorX(x) & miTablero.setPosJugadorY(y);
    }

    public void swap(int x, int y) {
        boolean swap = miTablero.swap(x, y);
    }

    public GUI getMiGUI() {
        return miGUI;
    }

    public void asociar_entidad_grafica(EntidadGrafica entidadGrafica) {
        miGUI.insertarEntidadGrafica(entidadGrafica);
    }

    private void asociar_entidades_logicas_graficas() {
        Entidad e;
        EntidadGrafica eg;

        for (int f=0; f<miTablero.getDimension(); f++) {
            for (int c=0; c<miTablero.getDimension(); c++) {
                e = miTablero.getEntidad(f,c);
                eg = new EntidadGrafica(f, c, e, miGUI.getPanel());
                e.setEntidadGrafica(eg);
                miGUI.insertarEntidadGrafica(eg);
            }
        }
    }
    private void asociar_gelatinas_graficas(){
        Gelatina e;
        EntidadGrafica eg;
        for (int f=0; f<miTablero.getDimension(); f++) {
            for (int c=0; c<miTablero.getDimension(); c++) {
                if(miTablero.getEntidad(f,c)!=null){
                    e =(Gelatina) miTablero.getEntidad(f, c);
                    eg = new EntidadGrafica(f, c, e.getCaramelo(), miGUI.getPanel());
                    e.setEntidadGrafica(eg);
                    miGUI.insertarEntidadGrafica(eg);
                }
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
