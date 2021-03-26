
import static java.lang.Thread.sleep;

public class Koordynator implements I_Koordynator{

    boolean blokadaA = true;
    boolean blokadaB = true;
    boolean blokadaC = false;

    @Override
    public synchronized void startA() throws InterruptedException {

        while(blokadaA)
        {
            wait();
        }
        blokadaC = true;
    }

    @Override
    public synchronized void startB() throws InterruptedException {

        while(blokadaB)
        {
            wait();
        }
        blokadaC = true;
    }

    public synchronized void startC() throws InterruptedException {

        while(blokadaC)
        {
            this.wait();
        }
        blokadaA = true;
        blokadaB = true;
    }

    @Override
    public synchronized void koniecA() {

        blokadaA = true;
        blokadaC = !(blokadaA & blokadaB);

        notifyAll();
    }

    @Override
    public synchronized void koniecB() {

        blokadaB = true;
        blokadaC = !(blokadaA & blokadaB);

        notifyAll();
    }
    public synchronized void koniecC() {

        this.blokadaA = false;
        this.blokadaB = false;
        this.blokadaC = true;

        notifyAll();
    }
}
