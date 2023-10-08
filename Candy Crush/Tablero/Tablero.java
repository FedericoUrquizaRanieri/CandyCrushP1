package Tablero;

import Entidad.*;
import Juego.Juego;

public class Tablero{
    
    //Atributos
    protected int posJugadorX;
    protected int posJugadorY;
    protected Entidad grilla[][];
    protected Juego miJuego;
    protected int dimension;
    private final Color[] colores = {Color.AZUL, Color.AMARILLO, Color.ROJO, Color.NARANJA, Color.ROSA, Color.VERDE};

    //Constructor
    public Tablero(Juego j){
        miJuego=j;
        dimension = 10;
        grilla = new Entidad[dimension][dimension];
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
        if(n >= 0 && n < dimension) {
            posJugadorX = n;
            return true;
        }
        return false;
    }

    public boolean setPosJugadorY(int n){
        if(n >= 0 && n < dimension) {
            posJugadorY = n;
            return true;
        }
        return false;
    }

    public int getPosJugadorX(){
        return posJugadorX;
    }

    public int getPosJugadorY(){
        return posJugadorY;
    }

    public boolean swap(int x, int y) {
        Entidad e1 = grilla[x][y];
        Entidad e2 = grilla[posJugadorX][posJugadorY];
        grilla[x][y] = e2;
        grilla[posJugadorX][posJugadorY] = e1;
        return true;
    }

    public boolean ordenarColumnas() {
        boolean cambios = false;
        for(int j = 0; j < dimension; j++) {
            int idx = dimension - 1;
            for(int i = dimension - 1; i >= 0; i--) {
                if(grilla[i][j] != null) {
                    grilla[idx][j] = grilla[i][j];
                    idx--;
                }
            }
            for (int i = idx; i >= 0; i--) {
                grilla[i][j] = new Caramelo(i, j, colores[(int) (Math.random() * 6)]);
                cambios = true;
            }
        }
        return cambios;
    }

    public Entidad getEntidad(int f, int c){
        Entidad toReturn = null;
        if(f >= 0 && f<dimension && c >= 0 && c < dimension){
            toReturn = grilla[f][c];
        }
        return toReturn;
    }
    public void setCaramelos(){
        int aux;
        for(int i=0;i<dimension;i++) {
            for (int j = 0; j < dimension; j++) {
                if (grilla[i][j] == null) {
                    aux = (int) (Math.random() * 6);
                    grilla[i][j] = new Caramelo(i, j, colores[aux]);
                    System.out.print((grilla[i][j]).getColor() + " - ");
                }
            }
            System.out.println('\n');
        }
    }
//    public void setGelatina(int x,int y){
//        //llega un punto y llenar los que estan cerca como dijimos
//        grilla[x][y]=new Gelatina();
//        int cant=(int)(Math.random() * ((8 - 3) + 1)) + 3;
//        int xn=x;
//        int yn=y;
//        for(int i=0;i<cant;i++){
//            //revisar este truncado de cavernicola que se me ocurrio
//            xn = xn + (int)(Math.random() * ((1 - -1) + 1)) + -1;
//            yn = yn + (int)(Math.random() * ((1 - -1) + 1)) + -1;
//            if(grilla[xn][yn]==null){
//                grilla[xn][yn]=new Gelatina();
//            }
//            else
//                i--;
//        }
//    }
//    public void setGlaseado(int n){
//        //revisar despues, estoy llenando aleatoriamente una cantidad x
//        int cont=n;
//        for(int i=0;i<cont;i++){
//            int x=(int)Math.random()*10;
//            int y=(int)Math.random()*10;
//            if(grilla[x][y]==null)
//                grilla[x][y]=new Glaseado(n, x, y);
//            else
//                i--;
//        }
//    }
    //agregar metodos de intercambios de ale
    public void chequeoGeneral3(){
        for(int f=0; f < getDimension();f++){
                for(int c=0; c < getDimension() - 2;c++){
                    Entidad caramelo1 = grilla[f][c];
                    Entidad caramelo2 = grilla[f][c+1];
                    Entidad caramelo3 = grilla[f][c+2];
                    if(caramelo1!=null && caramelo2!=null && caramelo3!=null){
                        if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                        caramelo1.destruirse(this);
                        caramelo2.destruirse(this);
                        caramelo3.destruirse(this);
                        }
                    }   
                }
        }

        for(int c=0; c<getDimension();c++){
            for(int f=0; f<getDimension()-2;f++){
                Entidad caramelo1 = grilla[f][c];
                Entidad caramelo2 = grilla[f+1][c];
                Entidad caramelo3 = grilla[f+2][c];
                if(caramelo1!=null && caramelo2!=null && caramelo3!=null){
                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                        caramelo1.destruirse(this);
                        caramelo2.destruirse(this);
                        caramelo3.destruirse(this);
                    }
                }   
           }
        }
    }

    public void crushCandy(){
        chequeoGeneral5();
        chequeoGeneral4();
        chequeoGeneral3();   
    }

    public void chequeoGeneral4(){
        for(int f=0; f<getDimension();f++){
                for(int c=0; c<getDimension() -3;c++){
                    Entidad caramelo1 = grilla[f][c];
                    Entidad caramelo2 = grilla[f][c+1];
                    Entidad caramelo3 = grilla[f][c+2];
                    Entidad caramelo4 = grilla[f][c+3];
                    if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null){
                        if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
                            caramelo1.destruirse(this);
                            caramelo2.destruirse(this);
                            caramelo3.destruirse(this);
                            caramelo4.destruirse(this);
                        }
                }
            }
        }

        for(int c=0; c<getDimension();c++){
           for(int f=0; f<getDimension()-3;f++){
                Entidad caramelo1 = grilla[f][c];
                Entidad caramelo2 = grilla[f+1][c];
                Entidad caramelo3 = grilla[f+2][c];
                Entidad caramelo4 = grilla[f+3][c];
                if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null){
                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
                        caramelo1.destruirse(this);
                        caramelo2.destruirse(this);
                        caramelo3.destruirse(this);
                        caramelo4.destruirse(this);
                    }
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
                    if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null && caramelo5!=null){
                        if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
                            caramelo1.destruirse(this);
                            caramelo2.destruirse(this);
                            caramelo3.destruirse(this);
                            caramelo4.destruirse(this);
                            caramelo5.destruirse(this);
                    }
                }
            }
        }

        for(int c=0; c<getDimension();c++){
           for(int f=0; f<getDimension()-4;f++){
                Entidad caramelo1 = grilla[f][c];
                Entidad caramelo2 = grilla[f+1][c];
                Entidad caramelo3 = grilla[f+2][c];
                Entidad caramelo4 = grilla[f+3][c];
                Entidad caramelo5 = grilla[f+4][c];
                if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null && caramelo5!=null){
                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
                        caramelo1.destruirse(this);
                        caramelo2.destruirse(this);
                        caramelo3.destruirse(this);
                        caramelo4.destruirse(this);
                        caramelo5.destruirse(this);
                    }
                }
            }
        }
    }

    void MovimientoValido4(int fila, int columna){
	    if((fila >= 0 && columna >= 1) && (fila < getDimension() && columna < getDimension()-2)){ //chequeo todos los dos a la derecha HORIZONTAL
	        if(grilla[fila][columna].getColor() == grilla[fila][columna-1].getColor() && grilla[fila][columna-1].getColor() == grilla[fila][columna+1].getColor() && grilla[fila][columna+1].getColor() == grilla[fila][columna+2].getColor()){
	            grilla[fila][columna] = new RalladoH(fila,  columna, grilla[fila][columna].getColor());
	            grilla[fila][columna-1].destruirse(this);
	            grilla[fila][columna+1].destruirse(this);
	            grilla[fila][columna+2].destruirse(this);
	        }
	    }

	    if((fila >= 0 && columna >= 2) && (fila < getDimension() && columna < getDimension()-1)){ //chequeo todos los dos a la izquierda HORIZONTAL
		    if(grilla[fila][columna].getColor() == grilla[fila][columna-1].getColor() && grilla[fila][columna-1].getColor() == grilla[fila][columna-2].getColor() && grilla[fila][columna-2].getColor() == grilla[fila][columna+1].getColor()){
		        grilla[fila][columna] = new RalladoH(fila,  columna, grilla[fila][columna].getColor());
	      	    grilla[fila][columna-1].destruirse(this);
	            grilla[fila][columna+1].destruirse(this);
	            grilla[fila][columna-2].destruirse(this);
	        }
	    }

        if((fila >= 2 && columna >= 0) && (fila < getDimension()-1 && columna < getDimension())){
           if(grilla[fila][columna].getColor() == grilla[fila+1][columna].getColor() && grilla[fila+1][columna].getColor() == grilla[fila-1][columna].getColor() && grilla[fila-1][columna].getColor() == grilla[fila-2][columna].getColor()){
                grilla[fila][columna] = new RalladoV(fila,  columna, grilla[fila][columna].getColor());
                grilla[fila+1][columna].destruirse(this);
                grilla[fila-1][columna].destruirse(this);
                grilla[fila-2][columna].destruirse(this);
            }
        }

        if((fila >= 1 && columna >= 0) && (fila < getDimension()-2 && columna < getDimension())){
            if(grilla[fila][columna].getColor() == grilla[fila+1][columna].getColor() && grilla[fila+1][columna].getColor() == grilla[fila-1][columna].getColor() && grilla[fila-1][columna].getColor() == grilla[fila+2][columna].getColor()){
                grilla[fila][columna] = new RalladoV(fila, columna, grilla[fila][columna].getColor());
                grilla[fila+1][columna].destruirse(this);
                grilla[fila-1][columna].destruirse(this);
                grilla[fila+2][columna].destruirse(this);
            }
        }
    }

//    void Envuelto(){
//        for(int c = 0; c < getDimension()-2 ; c++){
//            for(int f = 0; f < getDimension()-2; f++){
//                Entidad caramelo1 = grilla[f][c];
//                Entidad caramelo2 = grilla[f][c+1];
//                Entidad caramelo3 = grilla[f][c+2];
//                Entidad caramelo4 = grilla[f-1][c];
//                Entidad caramelo5 = grilla[f-2][c];
//                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
//                    //caramelo1."Bombita";
//                    caramelo2.destruirse();
//                    caramelo3.destruirse();
//                    caramelo4.destruirse();
//                    caramelo5.destruirse();
//                }
//            }
//        }
//    }
    public void setGelatina(int x,int y){
        //llega un punto y llenar los que estan cerca como dijimos
        grilla[x][y]=new Gelatina(x,y, colores[(int) (Math.random() * 6)]);
        int cant=(int)(Math.random() * ((8 - 3) + 1)) + 3;
        int xn=x;
        int yn=y;
        while(cant!=0){
            int temp = (Math.random() <= 0.5) ? 1 : -1;
            int tempx = (Math.random() <= 0.5) ? 1 : -1;
            int tempY = (Math.random() <= 0.5) ? 1 : -1;
            if(temp==1){
                xn = xn + tempx;
            }
            else{
                yn = yn + tempY;
            }
            if(grilla[xn][yn]==null){
                grilla[xn][yn]=new Gelatina(x,y, colores[(int) (Math.random() * 6)]);
                cant--;
            }
        }
    }
    public void setGlaseado(int n){
        //estoy llenando aleatoriamente una cantidad x
        int cont=n;
        while(cont!=0){
            int x=(int)(Math.random() * ((9 - 0) + 1)) + 0;
            int y=(int)(Math.random() * ((9 - 0) + 1)) + 0;
            if(grilla[x][y]==null){
                grilla[x][y]=new Glaseado(x,y);
                cont--;
            }
        }
    }
}