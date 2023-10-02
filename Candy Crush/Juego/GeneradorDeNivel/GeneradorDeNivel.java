package Juego.GeneradorDeNivel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import Juego.Juego;
import Nivel.Nivel;
import Tablero.Tablero;

public class GeneradorDeNivel {
    //Atributos
    private static String archivos[]=new String[]{"Archivo1.txt","Archivo2.txt","Archivo3.txt","Archivo4.txt","Archivo5.txt"};
    //Metodos
    //leer los archivos anda pero tengan en cuenta el salto de linea
    public static void generarTablero(int nivel, Tablero t) throws IOException {
        URL path = Juego.class.getResource(archivos[nivel-1]);
        File f = new File("Candy Crush/Juego/Archivo1.txt");
        FileReader fr= new FileReader(f);
        char[] data=new char[1000];
        fr.read(data,0,1000);
        //arranco a llenar el tablero
        //t.setDimension(data[32]);
        //t.setGelatina(data[44],data[46]);
        //t.setGlaseado(data[58]);
        t.setCaramelos();
        fr.close();
    }
    //REVISAR ESTA EXCEPTION URGENTE
    public static void generarNivel(int nivel,Nivel n) throws IOException{
        URL path = Juego.class.getResource(archivos[nivel-1]);
        File f = new File("Candy Crush/Juego/Archivo1.txt");
        FileReader fr= new FileReader(f);
        char[] data=new char[1000];
        fr.read(data,0,1000);
        //arranco a hacer el lvl
        //78 y 79 verde
        //91 y 92 amarillo
        //102 y 103 violeta
        //114 y 115 naranja
        //123 y 124 rojo
        //133 y 134 azul
        //146 y 147 glaseado
        //166 y 167 gelatina
        n.setMov(data[13]*10+data[14]);
        n.setObjetivoGlaseado(data[146]*10+data[147]);
        n.setObjetivoGelOEnv(data[166]*10+data[167]);
        n.setTiempo(data[23]);
        if(data[78]*10+data[79]!=0)
            n.setObjetivoCaramelo(data[78]*10+data[79],1);
        if(data[91]*10+data[92]!=0)
            n.setObjetivoCaramelo(data[91]*10+data[92],2);
        if(data[102]*10+data[103]!=0)
            n.setObjetivoCaramelo(data[102]*10+data[103],3);
        if(data[114]*10+data[115]!=0)
            n.setObjetivoCaramelo(data[114]*10+data[115],4);
        if(data[123]*10+data[124]!=0)
            n.setObjetivoCaramelo(data[123]*10+data[124],5);
        if(data[133]*10+data[134]!=0)
            n.setObjetivoCaramelo(data[133]*10+data[134],6);
        fr.close();
    }
}