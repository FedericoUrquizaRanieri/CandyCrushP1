package Juego.GeneradorDeNivel;

import java.io.FileReader;
import java.io.IOException;

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
    public static char[] parseFile(FileReader f) throws IOException {
        char[] c=new char[1000];
        f.read(c,0,1000);
        return c;
    }
}