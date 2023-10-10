package GUI;

import GUI.Threads.CentralAnimaciones;
import Juego.Juego;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {
    protected JLabel jugador;
    protected Juego juego;
    private int posX;
    private int posY;
    private int animacionesPendientes;
    private boolean bloquearIntercambios;
    private CentralAnimaciones centralAnimaciones;

    public Panel(Juego juego, JLabel jugador) {
        this.jugador = jugador;
        this.juego = juego;
        this.centralAnimaciones = new CentralAnimaciones(this);
        animacionesPendientes = 0;
        bloquearIntercambios = false;
        posX = 0; // Ubiacion del jugador en el tablero
        posY = 0; // Ubiacion del jugador en el tablero

        setLayout(null);
        setPreferredSize(new Dimension(Utils.panelWidth(), Utils.panelHeight()));
        setFocusable(true);
        setOpaque(false);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:{
                        int swapX = jugador.getX() - Utils.labelSpacing - Utils.labelWidth;
                        int swapY = jugador.getY();
                        if (!bloquearIntercambios && posY - 1 >= 0) {
                            posY--;
                            juego.moverCursor(posX, posY);
                            jugador.setLocation(swapX, swapY);
                        }
                        break;
                    }
                    case KeyEvent.VK_A:{
                        if(posY - 1 >= 0) {
                            juego.swap(posX, posY - 1);
                        }
                        break;
                    }
                    case KeyEvent.VK_RIGHT:{
                        int swapX = jugador.getX() + Utils.labelSpacing + Utils.labelWidth;
                        int swapY = jugador.getY();
                        if (!bloquearIntercambios && posY + 1 < Utils.dimension) {
                            posY++;
                            juego.moverCursor(posX, posY);
                            jugador.setLocation(swapX, swapY);
                        }
                        break;
                    }
                    case KeyEvent.VK_D:{
                        if(posY + 1 < Utils.dimension) {
                            juego.swap(posX, posY + 1);
                        }
                        break;
                    }
                    case KeyEvent.VK_UP:{
                        int swapX = jugador.getX();
                        int swapY = jugador.getY() - Utils.labelSpacing - Utils.labelHeight;
                        if (!bloquearIntercambios && posX - 1 >= 0) {
                            posX--;
                            juego.moverCursor(posX, posY);
                            jugador.setLocation(swapX, swapY);
                        }
                        break;
                    }
                    case KeyEvent.VK_W:{
                        if(posX - 1 >= 0) {
                            juego.swap(posX - 1, posY);
                        }
                        break;
                    }
                    case KeyEvent.VK_DOWN:{
                        int swapX = jugador.getX();
                        int swapY = jugador.getY() + Utils.labelSpacing + Utils.labelHeight;
                        if (!bloquearIntercambios && posX + 1 < Utils.dimension) {
                            posX++;
                            juego.moverCursor(posX, posY);
                            jugador.setLocation(swapX, swapY);
                        }
                        break;
                    }
                    case KeyEvent.VK_S:{
                        if(posX + 1 < Utils.dimension){
                            juego.swap(posX + 1, posY);
                        }
                        break;
                    }
                }
            }
        });
        setVisible(true);
    }

    public void animarMovimiento(EntidadGrafica entidadGrafica, int toX, int toY) {
        centralAnimaciones.animarCambioPosicion(entidadGrafica, toX, toY);
    }

    public void animarCambioEstado(EntidadGrafica entidadGrafica) {
        centralAnimaciones.animarCambioEstado(entidadGrafica);
    }

    public void terminarAnimacion() {
        synchronized(this){
            animacionesPendientes--;
            bloquearIntercambios = animacionesPendientes > 0;
        }
    }

    public void notificarAnimacion() {
        synchronized(this){
            animacionesPendientes++;
            bloquearIntercambios = true;
        }
    }
}
