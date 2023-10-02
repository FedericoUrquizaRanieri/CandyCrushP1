package GUI.Threads;

import javax.swing.*;
import java.util.List;

public class AnimadorEnvuelto extends Thread{
    private int delay;
    private List<JLabel> jLabels;
    private JLabel toExplode;

    public AnimadorEnvuelto(List<JLabel> jLabels, JLabel toExplode, int delay) {
        this.jLabels = jLabels;
        this.toExplode = toExplode;
        this.delay = delay;
    }

    public void run() {

        // To DO : simular la explosion del caramelo pasado por parametro y todos sus adyacentes

        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
