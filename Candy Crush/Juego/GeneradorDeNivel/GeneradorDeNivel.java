package Juego.GeneradorDeNivel;

import java.io.FileReader;
import java.io.IOException;

import Tablero.Tablero;

/**
 * 
 */
public class GeneradorDeNivel {
    //Atributos
    //Constructor
    public GeneradorDeNivel() {
    }
    //Metodos
    /**
     * @return
     * @throws IOException
     */
    public static Tablero parseFile(FileReader f) throws IOException {
        char[] data=new char[1000];
        f.read(data,0,1000);
        int m=data[12]*10+data[13];
        int t=data[21];
        int d=data[29];
        Tablero tab=new Tablero(m,t,d);
        tab.llenarGelatina(data[40], data[42]);
        tab.llenarGlaseado();
        tab.generarCaramelos();
        //meter objetivos
        return tab;
    }
}