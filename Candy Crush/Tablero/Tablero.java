package Tablero;

import Entidad.*;
import GUI.EntidadGrafica;
import Juego.Juego;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

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

            if(chequeoMovimiento(x,y) | chequeoMovimiento(posJugadorX,posJugadorY)) {
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
        return checkCombinaciones(fila, columna);
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
                Entidad e = new Caramelo(i, j, colores[(int) (Math.random() * 6)]);
                EntidadGrafica eg = new EntidadGrafica(-1,j, e, miJuego.getMiGUI().getPanel());
                e.setEntidadGrafica(eg);
                grilla[i][j] = e;
                miJuego.asociar_entidad_grafica(eg);
                eg.notificarCaida(Utils.labelPositionX(j),Utils.labelPositionY(i));
            }
        }
    }

    public Entidad getEntidad(int f, int c){
        Entidad toReturn = null;
        if(f >= 0 && f<dimension && c >= 0 && c < dimension){
            toReturn = grilla[f][c];
        }
        return toReturn;
    }

    public boolean checkCombinaciones(int x, int y) {
        if(grilla[x][y] == null) return false;
        Color color = grilla[x][y].getColor();
        Entidad e1,e2,e3,especialCreado=null;
        boolean huboCambios = false;
        List<Entidad> verticales = new ArrayList<>();
        List<Entidad> horizontales = new ArrayList<>();

        for (int i = 0; i < dimension-2; i++) {
            e1 = grilla[x][i];
            e2 = grilla[x][i+1];
            e3 = grilla[x][i+2];
            if(e1!=null && e2!=null && e3!=null && color == e1.getColor() && color == e2.getColor() && color == e3.getColor()) {
                verticales.add(e1);
                verticales.add(e2);
                verticales.add(e3);
            }
            e1 = grilla[i][y];
            e2 = grilla[i+1][y];
            e3 = grilla[i+2][y];
            if(e1!=null && e2!=null && e3!=null && color == e1.getColor() && color == e2.getColor() && color == e3.getColor()) {
                horizontales.add(e1);
                horizontales.add(e2);
                horizontales.add(e3);
            }
        }

        if(horizontales.isEmpty() ^ verticales.isEmpty()) {
            for (Entidad e:horizontales)
                e.destruirse(this);
            for (Entidad e:verticales)
                e.destruirse(this);
            if(horizontales.size() > 3)
                especialCreado = grilla[x][y] = new RalladoH(x,y,color);
            else if(verticales.size() > 3)
                especialCreado = grilla[x][y] = new RalladoV(x,y,color);
            huboCambios = true;
        } else if(!horizontales.isEmpty() && !verticales.isEmpty()) {
            for (Entidad e : horizontales)
                e.destruirse(this);
            for (Entidad e : verticales)
                e.destruirse(this);
            for (int i = 0; i < horizontales.size(); i++)
                if(verticales.contains(horizontales.get(i)))
                    especialCreado = grilla[horizontales.get(i).getFila()][horizontales.get(i).getColumna()] = new Envuelto(x, y, color);
            huboCambios = true;
        }
        if(especialCreado != null) {
            EntidadGrafica eg = new EntidadGrafica(especialCreado.getFila(),especialCreado.getColumna(),especialCreado,miJuego.getMiGUI().getPanel());
            especialCreado.setEntidadGrafica(eg);
            miJuego.asociar_entidad_grafica(eg);
        }
        return huboCambios;
    }

    public void setCaramelos(){
        int aux;
        for(int i=0;i<dimension;i++) {
            for (int j = 0; j < dimension; j++) {
                if (grilla[i][j] == null) {
                    aux = (int) (Math.random() * 6);
                    grilla[i][j] = new Caramelo(i, j, colores[aux]);
                }
            }
        }
    }

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