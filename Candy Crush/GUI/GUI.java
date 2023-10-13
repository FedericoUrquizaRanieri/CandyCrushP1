package GUI;

import javax.swing.*;

import Juego.Juego;
import utils.Utils;

import java.awt.*;

public class GUI extends JFrame{
    private Panel panel;
    private JLabel jugador;
    private Juego juego;

    public GUI(Juego juego) {
        this.juego = juego;

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        jugador = new JLabel();
        jugador.setOpaque(false);
        jugador.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED,8));
        jugador.setBounds(Utils.labelSpacing, Utils.labelSpacing, Utils.labelWidth, Utils.labelHeight);

        panel = new Panel(juego, jugador);
        panel.add(jugador);

        JLabel labelInfo = new JLabel();
        labelInfo.setPreferredSize(new Dimension(Utils.panelWidth()/2, Utils.panelHeight()));
        labelInfo.setOpaque(true);
        labelInfo.setBackground(Color.BLACK);

        getContentPane().add(labelInfo, BorderLayout.EAST);
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        getContentPane().add(new JLabel(new ImageIcon("Candy Crush/Imagenes/fondo.png")));
        setVisible(true);
    }

    public void insertarEntidadGrafica(EntidadGrafica eg) {
        if(eg != null) {
            panel.add(eg);
        }
    }

    public Panel getPanel() {
        return panel;
    }
}