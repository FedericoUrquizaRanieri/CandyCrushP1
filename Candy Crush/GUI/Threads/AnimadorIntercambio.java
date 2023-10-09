package GUI.Threads;

import javax.swing.*;

public class AnimadorIntercambio extends Thread {
    protected JLabel jLabel1;
    protected JLabel jLabel2;
    protected int delay;

    public AnimadorIntercambio(JLabel jLabel1, JLabel jLabel2, int delay) {
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.delay = delay;
    }

    public void run() {
        int jl1_posX = jLabel1.getX();
        int jl1_posY = jLabel1.getY();
        int jl2_posX = jLabel2.getX();
        int jl2_posY = jLabel2.getY();

        int jl1_to_posX = jl2_posX;
        int jl1_to_posY = jl2_posY;
        int jl2_to_posX = jl1_posX;
        int jl2_to_posY = jl1_posY;

        boolean stopX = jl1_posX == jl2_posX;
        boolean stopY = jl1_posY == jl2_posY;

        while(!stopX || !stopY) {
            if(!stopX) {
                jl1_posX += jl1_posX > jl1_to_posX ? -1 : 1;
                jl2_posX += jl2_posX > jl2_to_posX ? -1 : 1;
            }
            if(!stopY) {
                jl1_posY += jl1_posY > jl1_to_posY ? -1 : 1;
                jl2_posY += jl2_posY > jl2_to_posY ? -1 : 1;
            }
            jLabel1.setLocation(jl1_posX, jl1_posY);
            jLabel2.setLocation(jl2_posX, jl2_posY);
            stopX = jl1_posX == jl1_to_posX && jl2_posX == jl2_to_posX;
            stopY = jl1_posY == jl1_to_posY && jl2_posY == jl2_to_posY;
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        jLabel1 = null;
        jLabel2 = null;
    }
}
