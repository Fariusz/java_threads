
import static java.lang.Thread.sleep;

public class WatekC extends Thread {

    Koordynator koordynator;

    public WatekC(Koordynator koordynator) {
        this.koordynator = koordynator;
    }

    @Override
    public void run() {
        try {
            while (true) {
                koordynator.startC();
                System.out.println("Watek C ================");
                sleep( (int) (Math.random() * 20));
                koordynator.koniecC();
            }
        } catch (InterruptedException e) {
            System.out.println("wyjatek w watku C");
        }
    }
}
