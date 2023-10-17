package GUI.Threads;

import Entidad.Entidad;
import GUI.EntidadGrafica;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AnimadorDestruccion extends Thread implements Animador{
    protected EntidadGrafica entidadGrafica;
    private ManejadorAnimaciones manager;

    public AnimadorDestruccion(EntidadGrafica entidadGrafica, ManejadorAnimaciones manager) {
        this.entidadGrafica = entidadGrafica;
        this.manager = manager;
    }

    public void run() {
        try {
            sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        manager.terminoAnimacion(this);
    }

    @Override
    public EntidadGrafica getEntidadGrafica() {
        return null;
    }

    @Override
    public void comenzarAnimacion() {
        this.start();
    }
}
