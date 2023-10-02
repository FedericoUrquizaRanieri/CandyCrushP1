package GUI;

import javax.swing.*;

import GUI.Threads.AnimadorCaida;
import Juego.Juego;
import GUI.Panel;
import GUI.EntidadGrafica;

import java.awt.*;

public class GUI extends JFrame{
    private final int labelWidth = 60;
    private final int labelHeight = 60;
    private final int labelSpacing = 5;
    private final int dimension = 10;

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
        jugador.setBounds(0,-100, labelWidth, labelHeight);

        panel = new Panel(juego, jugador, labelWidth, labelHeight, labelSpacing, dimension);
        panel.add(jugador);

        int panelWidth = (int) panel.getPreferredSize().getWidth();
        int panelHeight = (int) panel.getPreferredSize().getHeight();

        JLabel labelInfo = new JLabel();
        labelInfo.setPreferredSize(new Dimension(panelWidth, labelHeight));
        labelInfo.setOpaque(false);

        getContentPane().add(labelInfo, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);
        //generarCaramelos();
        pack();
        getContentPane().add(new JLabel(new ImageIcon("Candy Crush/Imagenes/fondo.png")));
        setVisible(true);

        AnimadorCaida animadorCaida = new AnimadorCaida(jugador, labelSpacing,labelSpacing, 1);
        animadorCaida.start();
    }

//    public void generarCaramelos() {
//        int x = labelSpacing;
//        int y = labelSpacing;
//
//        for(int i = 0; i < dimension; i++){
//            for(int j = 0; j < dimension; j++) {
//                int random = (int) (Math.random() * 6);
//                EntidadGrafica eg = null;
//                if(random == 1) {
//                    eg = new EntidadGrafica(x, -100, labelWidth, labelHeight, Entidad.Color.AZUL);
//                } else if(random == 2) {
//                    eg = new EntidadGrafica(x, -100, labelWidth, labelHeight, Entidad.Color.AMARILLO);
//                } else if(random == 3) {
//                    eg = new EntidadGrafica(x, -100, labelWidth, labelHeight, Entidad.Color.ROJO);
//                } else if(random == 4) {
//                    eg = new EntidadGrafica(x, -100, labelWidth, labelHeight, Entidad.Color.NARANJA);
//                } else if(random == 5) {
//                    eg = new EntidadGrafica(x, -100, labelWidth, labelHeight, Entidad.Color.VERDE);
//                } else {
//                    eg = new EntidadGrafica(x, -100, labelWidth, labelHeight, Entidad.Color.ROSA);
//                }
//
//                panel.add(eg);
//
//                AnimadorCaida animadorCaida = new AnimadorCaida(eg, x, y, 1);
//                animadorCaida.start();
//
//                x += labelWidth + labelSpacing;
//            }
//
//            x = labelSpacing;
//            y += labelHeight + labelSpacing;
//        }
//        AnimadorCaida animadorCaida = new AnimadorCaida(jugador, labelSpacing,labelSpacing, 1);
//        animadorCaida.start();
//    }

    public void insertarEntidadGrafica(EntidadGrafica eg) {
        if(eg != null) {
            int posEG_X = eg.getX();
            int posEG_Y = eg.getY();
            eg.setLocation(posEG_X, -100);
            panel.add(eg);
            AnimadorCaida animadorCaida = new AnimadorCaida(eg, posEG_X, posEG_Y, 1);
            animadorCaida.start();
        }
    }

    public static void main(String[] args) {
        GUI g = new GUI(null);
        g.setVisible(true);
    }
}