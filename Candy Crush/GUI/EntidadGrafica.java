package GUI;

import Entidad.Entidad;
import Entidad.Color;
import GUI.Threads.AnimadorCaida;

import javax.swing.*;
import java.awt.*;

public class EntidadGrafica extends JLabel{
    private Entidad entidad;
    private Panel panel;
    private final int labelWidth = 60;
    private final int labelSpacing = 5;
    private final int labelHeight = 60;

    public EntidadGrafica(int x, int y,Entidad e, Panel panel) {
        entidad=e;
        this.panel = panel;
        ImageIcon ico = new ImageIcon(entidad.getImage());
        Image img = ico.getImage();
        Image new_img = img.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(new_img));
        setBounds(y * (labelSpacing + labelHeight) + labelSpacing,x * (labelSpacing + labelHeight) + labelSpacing, labelWidth, labelHeight);
        setOpaque(false);
    }

    public void destruirse() {
        panel.remove(this);
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void notificarCambio() {
        panel.animarCambioEstado(this);
    }

    public void notificarCambioPosicion(int toX, int toY) {
        panel.animarMovimiento(this, toX, toY);
    }
}