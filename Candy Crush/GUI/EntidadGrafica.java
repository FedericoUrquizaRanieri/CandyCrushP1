package GUI;

import Entidad.Entidad;
import Entidad.Color;

import javax.swing.*;
import java.awt.*;

public class EntidadGrafica extends JLabel{
    private Entidad entidad;

    public EntidadGrafica(int x, int y, int labelWidth, int labelHeight, Color color) {
        ImageIcon ico = new ImageIcon("Candy Crush/Imagenes/Caramelos/"+ color.toString().toLowerCase() +".png");
        Image img = ico.getImage();
        Image new_img = img.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(new_img));
        setBounds(x, y, labelWidth, labelHeight);
        setOpaque(false);
    }

    public void destruirse() {
    }
}