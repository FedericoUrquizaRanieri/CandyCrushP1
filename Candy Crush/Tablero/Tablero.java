package Tablero;

import Entidad.Entidad;
import Entidad.Caramelo.Caramelo;
import Entidad.Caramelo.CarameloPotenciador.RalladoV.RalladoV;
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
    public Entidad[][] getGrilla(){
        return grilla;
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
        if(f >= 0 && f<dimension && c >= 0 && c < dimension){
            return grilla[f][c];
        }
        return null;

    }
    public void setCaramelos(){
        int aux;
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(grilla[i][j]==null){
                    aux=(int)(Math.random() * ((6 - 1) + 1)) + 1;
                    grilla[i][j]=new Caramelo(aux, i, j);
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
                grilla[x][y]=new Glaseado(n, x, y);
            else
                i--;
        }
    }
    //agregar metodos de intercambios de ale
    void chequeoGeneral3(){
        for(int f=0; f<getDimension();f++){
                for(int c=0; c<getDimension() -2;c++){
                    Entidad caramelo1 = grilla[f][c];
                    Entidad caramelo2 = grilla[f][c+1];
                    Entidad caramelo3 = grilla[f][c+2];
                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                        caramelo1.destruirse(); //RETORNA UNA LISTA Y DESPUES 
                        caramelo2.destruirse();
                        caramelo3.destruirse();
                    }
                }
        }

        for(int c=0; c<getDimension();c++){
            for(int f=0; f<getDimension()-2;f++){
                Entidad caramelo1 = grilla[f][c];
                Entidad caramelo2 = grilla[f][c+1];
                Entidad caramelo3 = grilla[f][c+2];
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                    caramelo1.destruirse();
                    caramelo2.destruirse();
                    caramelo3.destruirse(); 
                }
           }
        }
    }

    void chequeoGeneral4(){
        for(int f=0; f<getDimension();f++){
                for(int c=0; c<getDimension() -3;c++){
                    Entidad caramelo1 = grilla[f][c];
                    Entidad caramelo2 = grilla[f][c+1];
                    Entidad caramelo3 = grilla[f][c+2];
                    Entidad caramelo4 = grilla[f][c+3];
                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
                        caramelo1.destruirse();
                        caramelo2.destruirse();
                        caramelo3.destruirse();
                        caramelo4.destruirse();
                    }
                }
        }
        
        for(int c=0; c<getDimension();c++){
           for(int f=0; f<getDimension()-3;f++){
                Entidad caramelo1 = grilla[f][c];
                Entidad caramelo2 = grilla[f][c+1];
                Entidad caramelo3 = grilla[f][c+2];
                Entidad caramelo4 = grilla[f][c+3];
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
                    caramelo1.destruirse();
                    caramelo2.destruirse();
                    caramelo3.destruirse();
                    caramelo4.destruirse();
                }
           }
        }
    }

    void chequeoGeneral5(){
        for(int f=0; f<getDimension(); f++){
                for(int c=0; c< getDimension()-4;c++){
                    Entidad caramelo1 = grilla[f][c];
                    Entidad caramelo2 = grilla[f][c+1];
                    Entidad caramelo3 = grilla[f][c+2];
                    Entidad caramelo4 = grilla[f][c+3];
                    Entidad caramelo5 = grilla[f][c+4];
                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
                        caramelo1.destruirse();
                        caramelo2.destruirse();
                        caramelo3.destruirse();
                        caramelo4.destruirse();
                        caramelo5.destruirse();
                    }
                }
        }

        for(int c=0; c<getDimension();c++){
           for(int f=0; f<getDimension()-3;f++){
                Entidad caramelo1 = grilla[f][c];
                Entidad caramelo2 = grilla[f][c+1];
                Entidad caramelo3 = grilla[f][c+2];
                Entidad caramelo4 = grilla[f][c+3];
                Entidad caramelo5 = grilla[f][c+4];
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
                    caramelo1.destruirse();
                    caramelo2.destruirse();
                    caramelo3.destruirse();
                    caramelo4.destruirse();
                    caramelo5.destruirse();
                }
           }
        }
    }

    void MovimientoValido4(int fila, int columna){ 
	    if((fila >= 0 && columna >= 1) && (fila < getDimension() && columna < getDimension()-2)){ //chequeo todos los dos a la derecha HORIZONTAL
	        if(grilla[fila][columna].getColor() == grilla[fila][columna-1].getColor() && grilla[fila][columna-1].getColor() == grilla[fila][columna+1].getColor() && grilla[fila][columna+1].getColor() == grilla[fila][columna+2].getColor()){
	            grilla[fila][columna] = new RalladoH(grilla[fila][columna].getColor(), fila,  columna);
	            grilla[fila][columna-1].destruirse();
	            grilla[fila][columna+1].destruirse();
	            grilla[fila][columna+2].destruirse();
	        }
	    }

	    if((fila >= 0 && columna >= 2) && (fila < getDimension() && columna < getDimension()-1)){ //chequeo todos los dos a la izquierda HORIZONTAL
		    if(grilla[fila][columna].getColor() == grilla[fila][columna-1].getColor() && grilla[fila][columna-1].getColor() == grilla[fila][columna-2].getColor() && grilla[fila][columna-2].getColor() == grilla[fila][columna+1].getColor()){
		        grilla[fila][columna] = new RalladoH(grilla[fila][columna].getColor(), fila,  columna);
	      	    grilla[fila][columna-1].destruirse();
	            grilla[fila][columna+1].destruirse();
	            grilla[fila][columna-2].destruirse();
	        }
	    }
	    
        if((fila >= 2 && columna >= 0) && (fila < getDimension()-1 && columna < getDimension())){
            if(grilla[fila][columna].getColor() == grilla[fila+1][columna].getColor() && grilla[fila+1][columna].getColor() == grilla[fila-1][columna].getColor() && grilla[fila-1][columna].getColor() == grilla[fila-2][columna].getColor()){
                grilla[fila][columna] = new RalladoVgrilla[fila][columna].getColor(), fila,  columna);
                grilla[fila+1][columna].destruirse();
                grilla[fila-1][columna].destruirse();
                grilla[fila-2][columna].destruirse();
            }
        }

        if((fila >= 1 && columna >= 0) && (fila < getDimension()-2 && columna < getDimension())){
            if(grilla[fila][columna].getColor() == grilla[fila+1][columna].getColor() && grilla[fila+1][columna].getColor() == grilla[fila-1][columna].getColor() && grilla[fila-1][columna].getColor() == grilla[fila+2][columna].getColor()){
                grilla[fila][columna] = new RalladoV(grilla[fila][columna].getColor(), fila,  columna);
                grilla[fila+1][columna].destruirse();
                grilla[fila-1][columna].destruirse();
                grilla[fila+2][columna].destruirse();
            }
        }
    }

    void Bombita(){
        for(int c = 0; c < getDimension()-2 ; c++){
            for(int f = 0; f < getDimension()-2; f++){
                Entidad caramelo1 = grilla[f][c];
                Entidad caramelo2 = grilla[f][c+1];
                Entidad caramelo3 = grilla[f][c+2];
                Entidad caramelo4 = grilla[f-1][c];
                Entidad caramelo5 = grilla[f-2][c];
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
                    caramelo1."Bombita";
                    caramelo2.destruirse();
                    caramelo3.destruirse();
                    caramelo4.destruirse();
                    caramelo5.destruirse();
                }
            }
        }
    }
}