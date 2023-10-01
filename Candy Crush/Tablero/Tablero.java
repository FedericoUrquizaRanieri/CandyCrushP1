package Tablero;

import Entidad.Entidad;
import Entidad.Caramelo.Caramelo;
import Entidad.Gelatina.Gelatina;
import Entidad.Glaseado.Glaseado;
import Juego.Juego;

public class Tablero{
    
    //Atributos
    protected int posJugadorX;
    protected int posJugadorY;
    protected Entidad grilla[][]=new Entidad[10][10];
    protected Juego miJuego;
    protected int dimension;

    //Constructor
    public Tablero(Juego j){
        miJuego=j;
        posJugadorX=0;
        posJugadorY=0;
    }

    //Metodos
    public void setDimension(int n){
        dimension = n;
    }

    public int getDimension(){
        return dimension;
    }

    public boolean setPosJugadorX(int n){
        if(posJugadorY+n>=0 && posJugadorY+n<dimension){
            posJugadorX = posJugadorX+n;
            return true;
        }
        return false;
    }

    public boolean setPosJugadorY(int n){
        if(posJugadorY+n>=0 && posJugadorY+n<dimension){
            posJugadorY = posJugadorY+n;
            return true;
        }
        return false;
    }

    public int getPosJugadorX(int n){
        return posJugadorX;
    }

    public int getPosJugadorY(int n){
        return posJugadorY;
    }

    public Entidad getEntidad(int f, int c){
        return grilla[f][c];

    }
    public void setCaramelos(){
        int aux;
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(grilla[i][j]==null){
                    aux=(int)(Math.random() * ((6 - 1) + 1)) + 1;
                    grilla[i][j]=new Caramelo(aux);
                }
    }
    public void setGelatina(int x,int y){
        //llega un punto y llenar los que estan cerca como dijimos
        grilla[x][y]=new Gelatina();
        int cant=(int)(Math.random() * ((8 - 3) + 1)) + 3;
        int xn=x;
        int yn=y;
        for(int i=0;i<cant;i++){
            //revisar este truncado de cavernicola que se me ocurrio
            xn = xn + (int)(Math.random() * ((1 - -1) + 1)) + -1;
            yn = yn + (int)(Math.random() * ((1 - -1) + 1)) + -1;
            if(grilla[xn][yn]==null){
                grilla[xn][yn]=new Gelatina();
            }
            else
                i--;
        }
    }
    public void setGlaseado(int n){
        //revisar despues, estoy llenando aleatoriamente una cantidad x
        int cont=n;
        for(int i=0;i<cont;i++){
            int x=(int)Math.random()*10;
            int y=(int)Math.random()*10;
            if(grilla[x][y]==null)
                grilla[x][y]=new Glaseado();
            else
                i--;
        }
    }
    //agregar metodos de intercambios de ale
}