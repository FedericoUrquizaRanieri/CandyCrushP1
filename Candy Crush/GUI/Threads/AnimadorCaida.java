package GUI.Threads;

import GUI.EntidadGrafica;

public class AnimadorCaida extends Thread implements Animador{
    protected EntidadGrafica entidadGrafica;
    protected int toX;
    protected int toY;
    protected int delay;
    private ManejadorAnimaciones manager;

    public AnimadorCaida(ManejadorAnimaciones manager, int toX, int toY, EntidadGrafica entidadGrafica, int delay) {
        this.manager = manager;
        this.toX = toX;
        this.toY = toY;
        this.entidadGrafica = entidadGrafica;
        this.delay = delay;
    }

    public void run() {
        int posY = entidadGrafica.getY();
        boolean stopY = posY == toY;
        int step = 3;

        while(!stopY) {
            posY++;
            entidadGrafica.setLocation(toX, posY);
            stopY = posY == toY;
            try {
                if(posY%4 == 0)
                    sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        manager.terminoAnimacion(this);
    }

    public EntidadGrafica getEntidadGrafica() {
        return entidadGrafica;
    }

    public void comenzarAnimacion() {
        this.start();
    }
}
