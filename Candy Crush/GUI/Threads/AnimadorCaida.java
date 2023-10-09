package GUI.Threads;

import javax.swing.*;
import java.time.Duration;

public class AnimadorCaida extends Thread{
    protected JLabel jLabel;
    protected int toX;
    protected int toY;
    protected int delay;

    public AnimadorCaida(JLabel jLabel, int toX, int toY, int delay) {
        this.jLabel = jLabel;
        this.toX = toX;
        this.toY = toY;
        this.delay = delay;
    }

    public void run() {
        int posX = jLabel.getX();
        int posY = jLabel.getY();

        boolean stopX = posX == toX;
        boolean stopY = posY == toY;

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!stopX || !stopY) {
            if(!stopX) posX += posX > toX ? -1 : 1;
            if(!stopY) posY += posY > toY ? -1 : 1;
            jLabel.setLocation(posX, posY);
            stopX = posX == toX;
            stopY = posY == toY;
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        jLabel = null;
    }
}
