package GUI.Threads;

import GUI.EntidadGrafica;

public class AnimadorCaida extends Thread implements Animador{
    protected EntidadGrafica entidadGrafica;
    protected int toX;
    protected int toY;
    protected int delay;
    private ManejadorAnimaciones manager;

    public AnimadorCaida(ManejadorAnimaciones manager, int toX, int toY, EntidadGrafica entidadGrafica) {
        this.entidadGrafica = entidadGrafica;
        this.toX = toX;
        this.toY = toY;
        this.manager = manager;
    }

    public void run() {
        int posX = entidadGrafica.getX();
        int posY = entidadGrafica.getY();

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
            entidadGrafica.setLocation(posX, posY);
            stopX = posX == toX;
            stopY = posY == toY;
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        manager.terminoAnimacion(this);
        entidadGrafica = null;
    }

    public EntidadGrafica getEntidadGrafica() {
        return entidadGrafica;
    }

    public void comenzarAnimacion() {
        this.start();
    }
}
