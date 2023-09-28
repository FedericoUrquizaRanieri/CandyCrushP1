package Juego;

import java.io.File;
import java.io.FileNotFoundException;
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
        tablero=iniciarNivel("Nivel1.txt");
        miGUI=crearGUI();
    }
    //Metodos
    /**
     * @return
     * @throws IOException
     */
    public Tablero iniciarNivel(String archivo) throws IOException {
        URL path = Juego.class.getResource(archivo);
        File f = new File(path.getFile());
        FileReader fr= new FileReader(f);
        return GeneradorDeNivel.parseFile(fr);
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
    public void pasarNivel(){
        tablero.reset();
    }
    public void hacerCambio(int x,int y,int z){
    }
    public void actualizarGUI(){
    }
}