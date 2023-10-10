package GUI.Threads;

import GUI.EntidadGrafica;
import GUI.GUI;
import GUI.Panel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CentralAnimaciones implements ManejadorAnimaciones{

    protected Panel gui;
    protected HashMap<EntidadGrafica, List<Animador>> hashMap;

    public CentralAnimaciones(Panel panel) {
        this.gui = panel;
        hashMap = new HashMap<EntidadGrafica, List<Animador>>();
    }

    public void animarCambioPosicion(EntidadGrafica entidadGrafica, int toX, int toY) {
        Animador animador = new AnimadorCaida(this, toX, toY, entidadGrafica);
        gui.notificarAnimacion();

        if (animacionesEnProgreso(entidadGrafica) ) {
            hashMap.get(entidadGrafica).add(animador);
        }else {
            hashMap.put(entidadGrafica, new LinkedList<Animador>());
            hashMap.get(entidadGrafica).add(animador);
            animador.comenzarAnimacion();
        }
    }

    public void animarCambioEstado(EntidadGrafica entidadGrafica) {
        Animador animador = new AnimadorCambioEstado(this, entidadGrafica);
        gui.notificarAnimacion();

        if (animacionesEnProgreso(entidadGrafica) ) {
            hashMap.get(entidadGrafica).add(animador);
        }else {
            hashMap.put(entidadGrafica, new LinkedList<Animador>());
            hashMap.get(entidadGrafica).add(animador);
            animador.comenzarAnimacion();
        }
    }

    public void terminoAnimacion(Animador a) {
        Animador animador;
        List<Animador> animaciones_para_celda;

        gui.terminarAnimacion();

        animaciones_para_celda = hashMap.get(a.getEntidadGrafica());
        animaciones_para_celda.remove(a);

        if (!animaciones_para_celda.isEmpty()) {
            animador = animaciones_para_celda.get(0);
            animador.comenzarAnimacion();
        }
    }

    private boolean animacionesEnProgreso(EntidadGrafica c) {
        boolean toReturn = false;
        if (hashMap.get(c) != null) {
            toReturn = !hashMap.get(c).isEmpty();
        }
        return toReturn;
    }
}
