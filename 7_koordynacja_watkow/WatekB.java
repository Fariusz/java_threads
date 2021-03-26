
import static java.lang.Thread.sleep;

public class WatekB extends Thread {

    Koordynator koordynator;

    public WatekB(Koordynator koordynator) {
        this.koordynator = koordynator;
    }

    @Override
    public void run() {
        try {
            while (true) {
                koordynator.startB();
                System.out.println("Watek B =====");
                sleep((int) (Math.random() * 20));
                koordynator.koniecB();
            }
        } catch (InterruptedException e) {
            System.out.println("wyjatek w watku B");
        }
    }
}
