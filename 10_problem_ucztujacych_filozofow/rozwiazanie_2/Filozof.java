
import java.util.concurrent.Semaphore;

public class Filozof extends Thread{

    Semaphore[] locks;
    int filozofID;
    static Semaphore extraLock;

    public Filozof (int nr, Semaphore[] paleczki, Semaphore stol)
    {
        filozofID = nr;
        locks = paleczki;
        extraLock = stol;
    }

    public void run(){
        try{
            while(true){
                System.out.println("Mysle " + filozofID);
                Thread.sleep( (long) (7 * Math.random()));

                extraLock.acquireUninterruptibly();
                locks[filozofID].acquireUninterruptibly();
                locks[(filozofID+1)%locks.length].acquireUninterruptibly();

                System.out.println("Zaczyna jesc " + filozofID);
                Thread.sleep( (long) (5* Math.random()));
                System.out.println("Konczy jesc " + filozofID);
                locks[filozofID].release();
                locks[(filozofID+1) % locks.length].release();
                extraLock.release();
            }
        }
        catch(InterruptedException ex){}

    }
}
