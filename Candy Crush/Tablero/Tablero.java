package Tablero;

import Entidad.*;
import GUI.EntidadGrafica;
import Juego.Juego;
import utils.Utils;

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
        dimension = Utils.dimension;
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
        if(e2.es_posible_intercambiar(e1)) {
            grilla[x][y] = e2;
            grilla[posJugadorX][posJugadorY] = e1;
            e1.cambiarPosicion(e2);

            if(chequeoMovimiento(x,y) | chequeoMovimiento(posJugadorX, posJugadorY)) {
                mostrarGrilla();
                ordenarColumnas();
                mostrarGrilla();
                return true;
            } else {
                grilla[x][y] = e1;
                grilla[posJugadorX][posJugadorY] = e2;
                e1.cambiarPosicion(e2);
                mostrarGrilla();
            }
        }
        return false;
    }

    public void mostrarGrilla() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                //System.out.println(getEntidad(i,j).getClass().toString().substring(getEntidad(i,j).getClass().toString().lastIndexOf(".")+1));
                if(getEntidad(i,j) != null)
                    System.out.print(getEntidad(i,j).getColor().toString().substring(0,3).toUpperCase() + " - ");
                else
                    System.out.print("NUL - ");
            }
            System.out.println('\n');
        }
        System.out.println("-------------------------------------------------------");
    }

    public boolean chequeoMovimiento(int fila, int columna){
        return checkCambioPosible(fila, columna);
        //return MovimientoValido3(fila, columna);
        //return MovimientoValido5(fila, columna) || MovimientoValido4(fila, columna) || MovimientoValido3(fila, columna);
        //return MovimientoValido5(fila, columna) || MovimientoValido4(fila, columna) || MovimientoValido3(fila, columna);
    }

    public void ordenarColumnas() {
        for(int j = 0; j < dimension; j++) {
            int idx = dimension - 1;
            for(int i = dimension - 1; i >= 0; i--) {
                if(grilla[i][j] != null) {
                    if(idx != i) {
                        grilla[i][j].cambiarPosicion(idx,j);
                        grilla[idx][j] = grilla[i][j];
                    }
                    idx--;
                }
            }
            for (int i = idx; i >= 0; i--) {
//                grilla[i][j] = null;
                Entidad e = new Caramelo(i, j, colores[(int) (Math.random() * 6)]);
                EntidadGrafica eg = new EntidadGrafica(i==0?-1:-i,j, e, miJuego.getMiGUI().getPanel());
                e.setEntidadGrafica(eg);
                grilla[i][j] = e;
                miJuego.asociar_entidad_grafica(eg);
                eg.notificarCaida(Utils.labelPositionX(j),Utils.labelPositionY(i));
            }
        }
    }


//    public void ordenarColumnas() {
//        int aux;
//        for (int c = 0; c < getDimension(); c++) {
//            for (int f = getDimension()- 1; f >= 0; f--) {
//                if (grilla[f][c] == null) {
//                    aux = f - 1;
//                    while (aux >= 0 && grilla[aux][c] == null) {
//                        aux--;
//                    }
//
//                    if (aux >= 0) {
//                        grilla[aux][c].cambiarPosicion(f,c);
//                        grilla[f][c] = grilla[aux][c];
//                        grilla[aux][c] = null;
//                    }
//                }
//            }
//
//        }
//    }

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

    public boolean checkCambioPosible(int x, int y) {
        Entidad e1,e2,e3;
        boolean huboCambio = false;
        boolean check3 = false;
        boolean check4 = false;
        boolean check5 = false;
        for (int j = 0; j < dimension - 2 && (!check3 && !check4 && !check5); j++) {
            e1 = grilla[x][j];
            e2 = grilla[x][j+1];
            e3 = grilla[x][j+2];

            if (e1!=null && e2!=null && e3!=null && e1.getColor() == e2.getColor() && e2.getColor() == e3.getColor()) {
                check3 = true;
                if (j + 3 < dimension && grilla[x][j + 3]!=null && e3.getColor() == grilla[x][j + 3].getColor()) {
                    check4 = true;
                    if (j + 4 < dimension && grilla[x][j + 4]!=null && e3.getColor() == grilla[x][j + 4].getColor()) {
                        check5 = true;
                    }
                }
            }
            if(check5){
                grilla[x][j+4].destruirse(this);
                grilla[x][j+3].destruirse(this);
                e3.destruirse(this);
                e2.destruirse(this);
                e1.destruirse(this);
            } else if(check4) {
                grilla[x][j+3].destruirse(this);
                e3.destruirse(this);
                e2.destruirse(this);
                e1.destruirse(this);
            } else if(check3) {
                e3.destruirse(this);
                e2.destruirse(this);
                e1.destruirse(this);
            }
            huboCambio = huboCambio || check3 || check4 || check5;
        }
        //check3 = check4 = check5 = false;
        for (int j = 0; j < dimension - 2 && (!check3 && !check4 && !check5); j++) {
            e1 = grilla[j][y];
            e2 = grilla[j+1][y];
            e3 = grilla[j+2][y];
            if (e1!=null && e2!=null && e3!=null && e1.getColor() == e2.getColor() && e2.getColor() == e3.getColor()) {
                check3 = true;
                if (j + 3 < dimension && grilla[x][j + 3]!=null && e3.getColor() == grilla[j + 3][x].getColor()) {
                    check4 = true;
                    if (j + 4 < dimension && grilla[x][j + 4]!=null && e3.getColor() == grilla[j + 4][x].getColor()) {
                        check5 = true;
                    }
                }
            }
            if(check5){
                grilla[j+4][y].destruirse(this);
                grilla[j+3][y].destruirse(this);
                e3.destruirse(this);
                e2.destruirse(this);
                e1.destruirse(this);
            } else if(check4) {
                grilla[j+3][y].destruirse(this);
                e3.destruirse(this);
                e2.destruirse(this);
                e1.destruirse(this);
            } else if(check3) {
                e3.destruirse(this);
                e2.destruirse(this);
                e1.destruirse(this);
            }
            huboCambio = huboCambio || check3 || check4 || check5;
        }
        check3 = check4 = check5 = false;
        if(x == posJugadorX) {
            for (int j = 0; j < dimension - 2 && (!check3 && !check4 && !check5); j++) {
                e1 = grilla[j][posJugadorY];
                e2 = grilla[j+1][posJugadorY];
                e3 = grilla[j+2][posJugadorY];
                if (e1!=null && e2!=null && e3!=null && e1.getColor() == e2.getColor() && e2.getColor() == e3.getColor()) {
                    check3 = true;
                    if (j + 3 < dimension && grilla[x][j + 3]!=null && e3.getColor() == grilla[j + 3][posJugadorY].getColor()) {
                        check4 = true;
                        if (j + 4 < dimension && grilla[x][j + 3]!=null && e3.getColor() == grilla[j + 4][posJugadorY].getColor()) {
                            check5 = true;
                        }
                    }
                }
                if(check5){
                    grilla[j+4][posJugadorY].destruirse(this);
                    grilla[j+3][posJugadorY].destruirse(this);
                    e3.destruirse(this);
                    e2.destruirse(this);
                    e1.destruirse(this);
                } else if(check4) {
                    grilla[j+3][posJugadorY].destruirse(this);
                    e3.destruirse(this);
                    e2.destruirse(this);
                    e1.destruirse(this);
                } else if(check3) {
                    e3.destruirse(this);
                    e2.destruirse(this);
                    e1.destruirse(this);
                }
                huboCambio = huboCambio || check3 || check4 || check5;
            }
        } else {
            for (int j = 0; j < dimension - 2 && (!check3 && !check4 && !check5); j++) {
                e1 = grilla[posJugadorX][j];
                e2 = grilla[posJugadorX][j+1];
                e3 = grilla[posJugadorX][j+2];
                if (e1!=null && e2!=null && e3!=null && e1.getColor() == e2.getColor() && e2.getColor() == e3.getColor()) {
                    check3 = true;
                    if (j + 3 < dimension && grilla[x][j + 3]!=null && e3.getColor() == grilla[posJugadorX][j + 3].getColor()) {
                        check4 = true;
                        if (j + 4 < dimension && grilla[x][j + 4]!=null && e3.getColor() == grilla[posJugadorX][j + 4].getColor()) {
                            check5 = true;
                        }
                    }
                }
                if(check5){
                    grilla[posJugadorX][j+4].destruirse(this);
                    grilla[posJugadorX][j+3].destruirse(this);
                    e3.destruirse(this);
                    e2.destruirse(this);
                    e1.destruirse(this);
                } else if(check4) {
                    grilla[posJugadorX][j+3].destruirse(this);
                    e3.destruirse(this);
                    e2.destruirse(this);
                    e1.destruirse(this);
                } else if(check3) {
                    e3.destruirse(this);
                    e2.destruirse(this);
                    e1.destruirse(this);
                }
                huboCambio = huboCambio || check3 || check4 || check5;
            }
        }
        return huboCambio;
    }
    //agregar metodos de intercambios de ale

//    private boolean chequeoGeneral3(){
//        boolean retorno=false;
//        for(int f=0; f < getDimension();f++){
//                for(int c=0; c < getDimension() - 2;c++){
//                    Entidad caramelo1 = grilla[f][c];
//                    Entidad caramelo2 = grilla[f][c+1];
//                    Entidad caramelo3 = grilla[f][c+2];
//                    if(caramelo1!=null && caramelo2!=null && caramelo3!=null){
//                        if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
//                            caramelo1.destruirse(this);
//                            caramelo2.destruirse(this);
//                            caramelo3.destruirse(this);
//                            retorno=true;
//                        }
//                    }
//                }
//        }
//
//        for(int c=0; c<getDimension();c++){
//            for(int f=0; f<getDimension()-2;f++){
//                Entidad caramelo1 = grilla[f][c];
//                Entidad caramelo2 = grilla[f+1][c];
//                Entidad caramelo3 = grilla[f+2][c];
//                if(caramelo1!=null && caramelo2!=null && caramelo3!=null){
//                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
//                        caramelo1.destruirse(this);
//                        caramelo2.destruirse(this);
//                        caramelo3.destruirse(this);
//                        retorno=true;
//                    }
//                }
//            }
//        }
//        return retorno;
//    }
//
//    public void crushCandy(){
//        boolean terminar=true;
//        do{
//            terminar=chequeoGeneral5() | chequeoGeneral4() | chequeoGeneral3();
//            ordenarColumnas();
//        }while(terminar);
//    }
//
//    private boolean chequeoGeneral4(){
//        boolean retorno=false;
//        for(int f=0; f<getDimension();f++){
//            for(int c=0; c<getDimension() -3;c++){
//                Entidad caramelo1 = grilla[f][c];
//                Entidad caramelo2 = grilla[f][c+1];
//                Entidad caramelo3 = grilla[f][c+2];
//                Entidad caramelo4 = grilla[f][c+3];
//                if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null){
//                    if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4)){
//                        if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
//                            caramelo1.destruirse(this);
//                            caramelo2.destruirse(this);
//                            caramelo3.destruirse(this);
//                            caramelo4.destruirse(this);
//                            retorno=true;
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int c=0; c<getDimension();c++){
//           for(int f=0; f<getDimension()-3;f++){
//                Entidad caramelo1 = grilla[f][c];
//                Entidad caramelo2 = grilla[f+1][c];
//                Entidad caramelo3 = grilla[f+2][c];
//                Entidad caramelo4 = grilla[f+3][c];
//                if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null){
//                    if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4)){
//                        if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
//                            caramelo1.destruirse(this);
//                            caramelo2.destruirse(this);
//                            caramelo3.destruirse(this);
//                            caramelo4.destruirse(this);
//                            retorno=true;
//                        }
//                    }
//                }
//            }
//        }
//        return retorno;
//    }
//
//    private boolean chequeoGeneral5(){
//        boolean retorno=false;
//        for(int f=0; f<getDimension(); f++){
//            for(int c=0; c< getDimension()-4;c++){
//                Entidad caramelo1 = grilla[f][c];
//                Entidad caramelo2 = grilla[f][c+1];
//                Entidad caramelo3 = grilla[f][c+2];
//                Entidad caramelo4 = grilla[f][c+3];
//                Entidad caramelo5 = grilla[f][c+4];
//                if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null && caramelo5!=null){
//                    if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4) && caramelo4.es_posible_intercambiar(caramelo5)){
//                        if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
//                            caramelo1.destruirse(this);
//                            caramelo2.destruirse(this);
//                            caramelo3.destruirse(this);
//                            caramelo4.destruirse(this);
//                            caramelo5.destruirse(this);
//                            retorno=true;
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int c=0; c<getDimension();c++){
//           for(int f=0; f<getDimension()-4;f++){
//                Entidad caramelo1 = grilla[f][c];
//                Entidad caramelo2 = grilla[f+1][c];
//                Entidad caramelo3 = grilla[f+2][c];
//                Entidad caramelo4 = grilla[f+3][c];
//                Entidad caramelo5 = grilla[f+4][c];
//                if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null && caramelo5!=null){
//                    if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4) && caramelo4.es_posible_intercambiar(caramelo5)){
//                        if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
//                            caramelo1.destruirse(this);
//                            caramelo2.destruirse(this);
//                            caramelo3.destruirse(this);
//                            caramelo4.destruirse(this);
//                            caramelo5.destruirse(this);
//                            retorno=true;
//                        }
//                    }
//                }
//            }
//        }
//        return retorno;
//    }
//
//    boolean MovimientoValido4(int fila, int columna){
//        boolean HuboCambios = false;
//	    if((fila >= 0 && columna >= 1) && (fila < getDimension() && columna < getDimension()-2)){ //chequeo todos los dos a la derecha HORIZONTAL
//            Entidad caramelo1 = grilla[fila][columna];
//            Entidad caramelo2 = grilla[fila][columna-1];
//            Entidad caramelo3 = grilla[fila][columna+1];
//            Entidad caramelo4 = grilla[fila][columna+2];
//            if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null)
//                if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4)){
//                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
//                        //caramelo1 = new RalladoH(fila,  columna, caramelo1.getColor());
//                        caramelo1.destruirse(this);
//                        caramelo2.destruirse(this);
//                        caramelo3.destruirse(this);
//                        caramelo4.destruirse(this);
//                        HuboCambios = true;
//                    }
//	            }
//	    }
//
//	    if((fila >= 0 && columna >= 2) && (fila < getDimension() && columna < getDimension()-1)){ //chequeo todos los dos a la izquierda HORIZONTAL
//            Entidad caramelo1 = grilla[fila][columna];
//            Entidad caramelo2 = grilla[fila][columna-1];
//            Entidad caramelo3 = grilla[fila][columna+1];
//            Entidad caramelo4 = grilla[fila][columna-2];
//            if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null)
//                if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4)){
//                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
//                        //caramelo1 = new RalladoH(fila,  columna, caramelo1.getColor());
//                        caramelo1.destruirse(this);
//                        caramelo2.destruirse(this);
//                        caramelo3.destruirse(this);
//                        caramelo4.destruirse(this);
//                        HuboCambios = true;
//                    }
//                }
//        }
//
//        if((fila >= 2 && columna >= 0) && (fila < getDimension()-1 && columna < getDimension())){
//            Entidad caramelo1 = grilla[fila][columna];
//            Entidad caramelo2 = grilla[fila-1][columna];
//            Entidad caramelo3 = grilla[fila-2][columna];
//            Entidad caramelo4 = grilla[fila+1][columna];
//            if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null)
//                if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4)){
//                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
//                        //caramelo1 = new RalladoH(fila,  columna, caramelo1.getColor());
//                        caramelo1.destruirse(this);
//                        caramelo2.destruirse(this);
//                        caramelo3.destruirse(this);
//                        caramelo4.destruirse(this);
//                        HuboCambios = true;
//                    }
//                }
//        }
//
//        if((fila >= 1 && columna >= 0) && (fila < getDimension()-2 && columna < getDimension())){
//            Entidad caramelo1 = grilla[fila][columna];
//            Entidad caramelo2 = grilla[fila-1][columna];
//            Entidad caramelo3 = grilla[fila+2][columna];
//            Entidad caramelo4 = grilla[fila+1][columna];
//            if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null)
//                if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4)){
//                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor()){
//                        //caramelo1 = new RalladoH(fila,  columna, caramelo1.getColor());
//                        caramelo1.destruirse(this);
//                        caramelo2.destruirse(this);
//                        caramelo3.destruirse(this);
//                        caramelo4.destruirse(this);
//                        HuboCambios = true;
//                    }
//                }
//        }
//        return HuboCambios;
//    }
//
    boolean MovimientoValido3(int fila, int columna){
        //CHEQUEO HORIZONTALES
        if(columna >= 2 && columna < getDimension() && fila < getDimension()){
            Entidad caramelo1 = grilla[fila][columna];
            Entidad caramelo2 = grilla[fila][columna-1];
            Entidad caramelo3 = grilla[fila][columna-2];
            if(caramelo1!=null && caramelo2!=null && caramelo3!=null)
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                    caramelo1.destruirse(this);
                    caramelo2.destruirse(this);
                    caramelo3.destruirse(this);
                    return true;
                }
        }
        if(columna >= 0 && columna < getDimension() -2 && fila < getDimension()){
            Entidad caramelo1 = grilla[fila][columna];
            Entidad caramelo2 = grilla[fila][columna+1];
            Entidad caramelo3 = grilla[fila][columna+2];
            if(caramelo1!=null && caramelo2!=null && caramelo3!=null)
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                    caramelo1.destruirse(this);
                    caramelo2.destruirse(this);
                    caramelo3.destruirse(this);
                    return true;
                }
        }

        if(columna >= 1 && columna < getDimension() - 1 && fila < getDimension()){
            Entidad caramelo1 = grilla[fila][columna];
            Entidad caramelo2 = grilla[fila][columna-1];
            Entidad caramelo3 = grilla[fila][columna+1];
            if(caramelo1!=null && caramelo2!=null && caramelo3!=null)
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                    caramelo1.destruirse(this);
                    caramelo2.destruirse(this);
                    caramelo3.destruirse(this);
                    return true;
                }
        }

        //CHEQUEO VERTICALES
        if(fila >= 2 && fila < getDimension() && columna < getDimension()){
            Entidad caramelo1 = grilla[fila][columna];
            Entidad caramelo2 = grilla[fila-1][columna];
            Entidad caramelo3 = grilla[fila-2][columna];
            if(caramelo1!=null && caramelo2!=null && caramelo3!=null)
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                    caramelo1.destruirse(this);
                    caramelo2.destruirse(this);
                    caramelo3.destruirse(this);
                    return true;
                }
        }

        if(fila >= 0 && fila < getDimension()-2 && columna < getDimension()){
            Entidad caramelo1 = grilla[fila][columna];
            Entidad caramelo2 = grilla[fila+1][columna];
            Entidad caramelo3 = grilla[fila+2][columna];
            if(caramelo1!=null && caramelo2!=null && caramelo3!=null)
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                    caramelo1.destruirse(this);
                    caramelo2.destruirse(this);
                    caramelo3.destruirse(this);
                    return true;
                }
        }

        if(fila >= 1 && fila < getDimension()-1 && columna < getDimension()){
            Entidad caramelo1 = grilla[fila][columna];
            Entidad caramelo2 = grilla[fila+1][columna];
            Entidad caramelo3 = grilla[fila-1][columna];
            if(caramelo1!=null && caramelo2!=null && caramelo3!=null)
                if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor()){
                    caramelo1.destruirse(this);
                    caramelo2.destruirse(this);
                    caramelo3.destruirse(this);
                    return true;
                }
        }
        return false;
    }
//
//    boolean MovimientoValido5(int fila, int columna){
//        //CHEQUEO HORIZONTALES
//        boolean HuboMovimiento = false;
//        if(columna >= 2 && columna < getDimension()-2 && fila < getDimension()){
//            Entidad caramelo1 = grilla[fila][columna];
//            Entidad caramelo2 = grilla[fila][columna+1];
//            Entidad caramelo3 = grilla[fila][columna+2];
//            Entidad caramelo4 = grilla[fila][columna-1];
//            Entidad caramelo5 = grilla[fila][columna-2];
//            if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null && caramelo5!=null)
//                if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4) && caramelo4.es_posible_intercambiar(caramelo5)){
//                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
//                        caramelo1.destruirse(this);
//                        caramelo2.destruirse(this);
//                        caramelo3.destruirse(this);
//                        caramelo4.destruirse(this);
//                        caramelo5.destruirse(this);
//                        return true;
//                    }
//                }
//        }
//
//        if(fila >= 2 && fila < getDimension() -2 && columna < getDimension()){
//            Entidad caramelo1 = grilla[fila][columna];
//            Entidad caramelo2 = grilla[fila+1][columna];
//            Entidad caramelo3 = grilla[fila+2][columna];
//            Entidad caramelo4 = grilla[fila-1][columna];
//            Entidad caramelo5 = grilla[fila-2][columna];
//            if(caramelo1!=null && caramelo2!=null && caramelo3!=null && caramelo4!=null && caramelo5!=null)
//                if(caramelo1.es_posible_intercambiar(caramelo2) && caramelo2.es_posible_intercambiar(caramelo3) && caramelo3.es_posible_intercambiar(caramelo4) && caramelo4.es_posible_intercambiar(caramelo5)){
//                    if(caramelo1.getColor() == caramelo2.getColor() && caramelo2.getColor() == caramelo3.getColor() && caramelo3.getColor() == caramelo4.getColor() && caramelo4.getColor() == caramelo5.getColor()){
//                        caramelo1.destruirse(this);
//                        caramelo2.destruirse(this);
//                        caramelo3.destruirse(this);
//                        caramelo4.destruirse(this);
//                        caramelo5.destruirse(this);
//                        return true;
//                    }
//                }
//        }
//        return HuboMovimiento;

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
            if(xn+temp>=0 && xn+tempx<10)
                xn = xn + tempx;
        }
        else{
            if(yn+tempY>=0 && yn+tempY<10)
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