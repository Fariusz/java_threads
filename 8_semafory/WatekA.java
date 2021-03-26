
import java.util.concurrent.Semaphore;

public class WatekA extends Thread
{
    Semaphore semA;
    Semaphore semB;
    Semaphore semC;

    WatekA(Semaphore semA, Semaphore semB, Semaphore semC)
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
                semA.acquire();
                sleep(50);
                System.out.println("WatekA");
                semC.release();
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex);
        }

    }
}
