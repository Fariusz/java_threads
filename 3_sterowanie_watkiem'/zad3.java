
class Watek extends Thread{
    private int numer;
    static Licznik licznik = new Licznik();
    Watek(int id)
    {
        numer = id;
    }

    @Override
    public void run() {
        System.out.println("Watek" + numer);
        for(int i = 0; i<100000; ++i)
        {
            licznik.increment();
        }
    }
}

class Licznik
{
    int licznik;

    public Licznik()
    {
        licznik=0;
    }

    synchronized void increment()
    {
        licznik++;
        System.out.println("Watek " + Thread.currentThread().getId() + " Licznik: " + licznik);
    }

    int get ()
    {
        return licznik;
    }
}

public class zad3 {
    public static void main(String[] args) throws InterruptedException{

        System.out.println(Watek.licznik.get());
        int ileWatkow = 10;
        Watek watki[] = new Watek[ileWatkow];
        for(int i = 0; i<ileWatkow; i++)
        {
            watki[i] = new Watek(i+1);
            watki[i].start();
        }
        for(int i = 0; i<ileWatkow; i++)
        {
            watki[i].join();
        }
        System.out.println(Watek.licznik.get());
    }
}
