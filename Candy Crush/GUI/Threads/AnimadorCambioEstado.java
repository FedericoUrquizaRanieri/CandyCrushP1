package GUI.Threads;

import GUI.EntidadGrafica;
import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class AnimadorCambioEstado implements Animador {

    protected ManejadorAnimaciones manager;
    protected EntidadGrafica entidadGrafica;

    protected String path_img;

    public AnimadorCambioEstado(ManejadorAnimaciones manager, EntidadGrafica entidadGrafica) {
        this.manager = manager;
        this.entidadGrafica = entidadGrafica;

        path_img = entidadGrafica.getEntidad().getImage();
    }

    public EntidadGrafica getEntidadGrafica() {
        return entidadGrafica;
    }

    public void comenzarAnimacion() {
        int size_label = Utils.labelWidth;
        ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(path_img));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(size_label, size_label, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        entidadGrafica.setIcon(iconoEscalado);
        manager.terminoAnimacion(this);
    }
}
