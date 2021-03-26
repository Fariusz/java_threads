
import java.util.concurrent.Semaphore;

public class Filozof extends Thread {

    Semaphore[] locks;
    int filozofID;

    public Filozof(int nr, Semaphore[] paleczki)
    {
        filozofID = nr;
        locks = paleczki;
    }

    public void run()
    {
        try{
            while(true)
            {
                System.out.println("Mysle " + filozofID);
                Thread.sleep( (long) (7 * Math.random()));
                locks[filozofID].acquireUninterruptibly();
                locks[(filozofID+1) % locks.length].acquireUninterruptibly();
                System.out.println("Zaczyna jesc " + filozofID);
                Thread.sleep( (long) (5 * Math.random()));
                System.out.println("Konczy jesc " + filozofID);
                locks[filozofID].release();
                locks[(filozofID + 1) % locks.length].release();
            }
        }
        catch(InterruptedException ex){}
    }
}
