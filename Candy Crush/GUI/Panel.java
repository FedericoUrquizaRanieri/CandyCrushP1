package GUI;

import GUI.Threads.AnimadorIntercambio;
import Juego.Juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {
    protected JLabel jugador;
    protected Juego juego;
    protected int labelWidth;
    protected int labelHeight;
    protected int labelSpacing;
    protected int dimension;
    private int posX;
    private int posY;

    public Panel(Juego juego, JLabel jugador, int labelWidth, int labelHeight, int labelSpacing, int dimension) {
        this.jugador = jugador;
        this.juego = juego;
        this.labelWidth = labelWidth;
        this.labelHeight = labelHeight;
        this.labelSpacing = labelSpacing;
        this.dimension = dimension;
        posX = 0; // Ubiacion del jugador en el tablero
        posY = 0; // Ubiacion del jugador en el tablero

        setLayout(null);
        setPreferredSize(new Dimension(dimension * labelWidth + (dimension + 1) * labelSpacing, dimension * labelHeight + (dimension + 1) * labelSpacing));
        setFocusable(true);
        setOpaque(false);
        addKeyListener(new KeyAdapter() {
            boolean toSwap = false;
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT, KeyEvent.VK_A -> {
                        int swapX = jugador.getX() - labelSpacing - labelWidth;
                        int swapY = jugador.getY();
                        if(toSwap && posY - 1 >= 0) {
                            trySwap(swapX, swapY);
                            juego.swap(posX, posY - 1);
                            toSwap = revertSwapState(toSwap);
                        } else if (posY - 1 >= 0) { // Mover Cursor
                            posY--;
                            juego.moverCursor(posX, posY);
                            jugador.setLocation(swapX, swapY);
                        }
                        break;
                    }
                    case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> {
                        int swapX = jugador.getX() + labelSpacing + labelWidth;
                        int swapY = jugador.getY();
                        if(toSwap && posY + 1 < dimension) {
                            trySwap(swapX, swapY);
                            juego.swap(posX, posY + 1);
                            toSwap = revertSwapState(toSwap);
                        } else if (posY + 1 < dimension) {
                            posY++;
                            juego.moverCursor(posX, posY);
                            jugador.setLocation(swapX, swapY);
                        }
                        break;
                    }
                    case KeyEvent.VK_UP, KeyEvent.VK_W -> {
                        int swapX = jugador.getX();
                        int swapY = jugador.getY() - labelSpacing - labelHeight;
                        if(toSwap && posX - 1 >= 0) {
                            trySwap(swapX, swapY);
                            juego.swap(posX - 1, posY);
                            toSwap = revertSwapState(toSwap);
                        } else if (posX - 1 >= 0) {
                            posX--;
                            juego.moverCursor(posX, posY);
                            jugador.setLocation(swapX, swapY);
                        }
                        break;
                    }
                    case KeyEvent.VK_DOWN, KeyEvent.VK_S -> {
                        int swapX = jugador.getX();
                        int swapY = jugador.getY() + labelSpacing + labelHeight;
                        if(toSwap && posX + 1 < dimension){
                            trySwap(swapX, swapY);
                            juego.swap(posX + 1, posY);
                            toSwap = revertSwapState(toSwap);
                        } else if (posX + 1 < dimension) {
                            posX++;
                            juego.moverCursor(posX, posY);
                            jugador.setLocation(swapX, swapY);
                        }
                        break;
                    }
                    case KeyEvent.VK_SPACE -> {
                        toSwap = revertSwapState(toSwap);
                    }
                    case KeyEvent.VK_ENTER -> {
                        juego.crushCandy();
                    }
                }
            }
        });
        setVisible(true);
    }

    public boolean revertSwapState(boolean toSwap) {
        if(toSwap){
            toSwap = false;
            jugador.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED, 8));
        } else {
            toSwap = true;
            jugador.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLUE, 8));
        }
        return toSwap;
    }

    public void trySwap(int swapX, int swapY) {
        JLabel jLabel1 = null;
        JLabel jLabel2 = null;
        for (Component component : getComponents()) {
            if(component.getX() == jugador.getX() && component.getY() == jugador.getY())
                jLabel1 = ((JLabel) component);
            if(component.getX() == swapX && component.getY() == swapY)
                jLabel2 = ((JLabel) component);
        }

        if(jLabel2 != null && jLabel1 != null) {
            AnimadorIntercambio animadorIntercambio = new AnimadorIntercambio(jLabel1,jLabel2,1);
            animadorIntercambio.start();
        }
    }
}
