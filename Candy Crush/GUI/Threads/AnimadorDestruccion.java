package GUI.Threads;

import javax.swing.ImageIcon;

import GUI.EntidadGrafica;

public class AnimadorDestruccion extends Thread implements Animador{
    protected EntidadGrafica entidadGrafica;
    private ManejadorAnimaciones manager;

    public AnimadorDestruccion(EntidadGrafica entidadGrafica, ManejadorAnimaciones manager) {
        this.entidadGrafica = entidadGrafica;
        this.manager = manager;
    }

    public void run() {
        entidadGrafica.setIcon(new ImageIcon("Candy Crush/Imagenes/Extras/Explosion.gif"));
        entidadGrafica.repaint();
        try {
            sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        entidadGrafica.destruirse();
        manager.terminoAnimacion(this);
    }

    @Override
    public EntidadGrafica getEntidadGrafica() {
        return null;
    }

    @Override
    public void comenzarAnimacion() {
        this.start();
    }
}
