package GUI;

import Entidad.Entidad;
import Entidad.Color;

import javax.swing.*;
import java.awt.*;

public class EntidadGrafica extends JLabel{
    private Entidad entidad;
    private final int labelWidth = 60;
    private final int labelSpacing = 5;
    private final int labelHeight = 60;

    public EntidadGrafica(int x, int y, Color color) {
        if(color == null) {
            setBackground(java.awt.Color.WHITE);
        } else {
            ImageIcon ico = new ImageIcon("Candy Crush/Imagenes/Caramelos/"+ color.toString().toLowerCase() +".png");
            Image img = ico.getImage();
            Image new_img = img.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(new_img));
        }
        setBounds(y * (labelSpacing + labelWidth) + labelSpacing, x * (labelSpacing + labelHeight) + labelSpacing, labelWidth, labelHeight);
        setOpaque(false);
    }

    public void destruirse() {
    }
}