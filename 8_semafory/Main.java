
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        Semaphore semA = new Semaphore(0,true);
        Semaphore semB = new Semaphore(0,true);
        Semaphore semC = new Semaphore(2,true);

        Thread thA = new WatekA(semA, semB, semC);
        Thread thB = new WatekB(semA, semB, semC);
        Thread thC = new WatekC(semA, semB, semC);

        thA.start();
        thB.start();
        thC.start();

        Thread.sleep(2000);

        thA.interrupt();
        thB.interrupt();
        thC.interrupt();
    }
}
