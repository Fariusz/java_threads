
import java.util.concurrent.Semaphore;

public class WatekC extends Thread
{
    Semaphore semA;
    Semaphore semB;
    Semaphore semC;

    WatekC(Semaphore semA, Semaphore semB, Semaphore semC)
    {
        this.semA = semA;
        this.semB = semB;
        this.semC = semC;
    }

    @Override
    public void run() {
        try
        {
            while(true)
            {
                semC.acquire(2);
                sleep(50);
                System.out.println("WatekC ==============");
                semA.release();
                semB.release();
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex);
        }

    }
}
