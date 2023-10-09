package Juego;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Nivel.Nivel;
import Tablero.Tablero;

public class GeneradorDeNivel {
    //Atributos
    private static String archivos[]=new String[]{"Archivo1.txt","Archivo2.txt","Archivo3.txt","Archivo4.txt","Archivo5.txt"};
    //Metodos
    //leer los archivos anda pero tengan en cuenta el salto de linea
    public static void generarGelatina(int Nivel,Tablero t){
        try{
            File f = new File("Juego/"+archivos[Nivel-1]);
            FileReader fr= new FileReader(f);
            char[] data=new char[1000];
            fr.read(data,0,1000);
            t.setGelatina(data[47]-48,data[49]-48);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void generarMerengue(int n,Tablero t){
        try{
            File f = new File("Juego/"+archivos[n-1]);
            FileReader fr= new FileReader(f);
            char[] data=new char[1000];
            fr.read(data,0,1000);
            t.setGlaseado(data[63]-48);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            
    }
    public static void generarCaramelos(Tablero t){
        t.setCaramelos();
    }
    public static void generarNivel(int nivel, Nivel n){
        try{
            File f = new File("Juego/"+archivos[nivel-1]);
            FileReader fr= new FileReader(f);
            char[] data=new char[1000];
            fr.read(data,0,1000);
            //arranco a hacer el lvl
            n.setMov(((data[12]-48)*10+data[13]-48));
            n.setObjetivoGlaseado((data[159]-48)*10+data[160]-48);
            n.setObjetivoGelOEnv((data[180]-48)*10+data[181]-48);
            n.setTiempo(data[23]-48);
            //revisar esto con tino
            if((data[85]-48)*10+data[86]-48!=0)
                n.setObjetivoCaramelo((data[85]-48)*10+data[86]-48,1);
            if((data[99]-48)*10+data[100]-48!=0)
                n.setObjetivoCaramelo((data[99]-48)*10+data[100]-48,2);
            if((data[111]-48)*10+data[112]-48!=0)
                n.setObjetivoCaramelo((data[111]-48)*10+data[112]-48,3);
            if((data[124]-48)*10+data[125]-48!=0)
                n.setObjetivoCaramelo((data[124]-48)*10+data[125]-48,4);
            if((data[134]-48)*10+data[135]-48!=0)
                n.setObjetivoCaramelo((data[134]-48)*10+data[135]-48,5);
            if((data[145]-48)*10+data[146]-48!=0)
                n.setObjetivoCaramelo((data[145]-48)*10+data[146]-48,6);
            fr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}