package GUI.Threads;

import GUI.EntidadGrafica;
import GUI.Panel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CentralAnimaciones implements ManejadorAnimaciones{

    protected Panel gui;
//    protected HashMap<EntidadGrafica, List<Animador>> hashMap;
    protected Queue<Animador> swapQueue, destroyQueue, fallingQueue;
    protected boolean animacionesActivas;


    public CentralAnimaciones(Panel panel) {
        this.gui = panel;
//        this.hashMap = new HashMap<EntidadGrafica, List<Animador>>();
        this.swapQueue = new LinkedList<>();
        this.destroyQueue = new LinkedList<>();
        this.fallingQueue = new LinkedList<>();
    }

//    public void animarCambioPosicion(EntidadGrafica entidadGrafica, int toX, int toY) {
//        Animador animador = new AnimadorCaida(this, toX, toY, entidadGrafica, 1);
//        gui.notificarAnimacion();
//
//        if (animacionesEnProgreso(entidadGrafica) ) {
//            hashMap.get(entidadGrafica).add(animador);
//        }else {
//            hashMap.put(entidadGrafica, new LinkedList<Animador>());
//            hashMap.get(entidadGrafica).add(animador);
//            animador.comenzarAnimacion();
//        }
//    }
//
//    public void animarCambioEstado(EntidadGrafica entidadGrafica) {
//        Animador animador = new AnimadorCambioEstado(this, entidadGrafica);
//        gui.notificarAnimacion();
//
//        if (animacionesEnProgreso(entidadGrafica) ) {
//            hashMap.get(entidadGrafica).add(animador);
//        }else {
//            hashMap.put(entidadGrafica, new LinkedList<Animador>());
//            hashMap.get(entidadGrafica).add(animador);
//            animador.comenzarAnimacion();
//        }
//    }
//
//    public void terminoAnimacion(Animador a) {
//        Animador animador;
//        List<Animador> animaciones_para_celda;
//
//        gui.terminarAnimacion();
//
//        animaciones_para_celda = hashMap.get(a.getEntidadGrafica());
//        animaciones_para_celda.remove(a);
//
//        if (!animaciones_para_celda.isEmpty()) {
//            animador = animaciones_para_celda.get(0);
//            animador.comenzarAnimacion();
//        }
//    }
//
//    private boolean animacionesEnProgreso(EntidadGrafica c) {
//        boolean toReturn = false;
//        if (hashMap.get(c) != null) {
//            toReturn = !hashMap.get(c).isEmpty();
//        }
//        return toReturn;
//    }

    public void ejecutarAnimadores() {
        if(!swapQueue.isEmpty()) {
            animacionesActivas = true;
            Animador animador = swapQueue.poll();

            animador.comenzarAnimacion();
        } else if(!destroyQueue.isEmpty()) {
            animacionesActivas = true;
            Animador animador = fallingQueue.poll();

            animador.comenzarAnimacion();
        } else if(!fallingQueue.isEmpty()) {
            animacionesActivas = true;
            Animador animador = fallingQueue.poll();

            animador.comenzarAnimacion();
        } else {
            animacionesActivas = false;
            gui.terminoAnimacion();
        }
    }

    public void animarSwap(EntidadGrafica origen, EntidadGrafica destino) {
        Animador animador = new AnimadorSwap(this, origen, destino, 1);
        gui.comenzoAnimacion();
        swapQueue.offer(animador);
        if(!animacionesActivas) {
            ejecutarAnimadores();
        }
    }

    public void animarCaida(EntidadGrafica entidadGrafica, int toX, int toY) {
        Animador animador = new AnimadorCaida(this, toX, toY, entidadGrafica, 1);
        gui.comenzoAnimacion();
        fallingQueue.offer(animador);
        if(!animacionesActivas) {
            ejecutarAnimadores();
        }
    }

    public void terminoAnimacion(Animador a) {
        animacionesActivas = false;
        gui.terminoAnimacion();
        ejecutarAnimadores();
    }
}
