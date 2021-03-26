
import java.util.concurrent.Semaphore;

public class WatekB extends Thread {

    Semaphore semA;
    Semaphore semB;
    Semaphore semC;

    WatekB(Semaphore semA, Semaphore semB, Semaphore semC) {
        this.semA = semA;
        this.semB = semB;
        this.semC = semC;
    }

    @Override
    public void run() {
        try {
            while(true)
            {
                semB.acquire();
                sleep(50);
                System.out.println("WatekB =====");
                semC.release();
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

    }
}
