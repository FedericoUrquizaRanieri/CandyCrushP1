package Juego;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import GUI.GUI;
import Juego.GeneradorDeNivel.GeneradorDeNivel;
import Tablero.Tablero;

/**
 * 
 */
public class Juego {

    //Atributos
    private GUI miGUI;
    private Tablero tablero;

    //Constructor
    public Juego() throws IOException {
        URL path = Juego.class.getResource("Nivel1.txt");
        File f = new File(path.getFile());
        FileReader fr= new FileReader(f);
        char[] data=GeneradorDeNivel.parseFile(fr);
        int m=data[12]*10+data[13];
        int t=data[21];
        int d=data[29];
        tablero=iniciarNivel(m,t,d);
        miGUI=crearGUI();
        tablero.llenarGrillaEspeciales(data[40], data[42]);
    }
    //Metodos
    /**
     * @return
     */
    public Tablero iniciarNivel(int m,int t, int d) {
        //cambiar con el generador
        return new Tablero(m,t,d);
    }
    /**
     * @return
     */
    public GUI crearGUI() {
        return new GUI(this);
    }
    /**
     * @return
     */
    public Tablero getTablero() {
        return tablero;
    }

}