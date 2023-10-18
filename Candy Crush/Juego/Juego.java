package Juego;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import GUI.GUI;
import GUI.Panel;
import Nivel.Nivel;
import Tablero.Tablero;
import Entidad.Color;
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
        miTablero.vaciarTablero();
        miGenerador.parseLvl(nivel,miTablero,miNivel);
        miGUI.notificarMovimiento();
        
    }
        
    public boolean moverCursor(int x,int y){
        return miTablero.setPosJugadorX(x) & miTablero.setPosJugadorY(y);
    }

    public void swap(int x, int y) {
        miTablero.swap(x, y);
        miNivel.restarMov();
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

    public void animacionesTerminadas(){
        if(miNivel.objetivosTerminados()){
            ImageIcon icon = new ImageIcon("Candy Crush/Imagenes/Extras/creeper.gif");
            JOptionPane.showMessageDialog(null, "Has pasado de nivel", "Felicidades!", JOptionPane.INFORMATION_MESSAGE, icon);
            miNivel.setNivel(NivelActual()+1);
            regenerar(NivelActual());
        }
    }
}
