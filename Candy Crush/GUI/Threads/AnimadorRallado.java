package GUI.Threads;

public class AnimadorRallado extends Thread{
    public AnimadorRallado() {

    }

    public void run() {

        // To DO : animador para el rallado horizontal y vertical

        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
