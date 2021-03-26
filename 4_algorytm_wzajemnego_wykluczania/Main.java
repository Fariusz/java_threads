
class Licznik{
    public int licznik = 0;

    public void increment(){
        licznik++;
    }

    public int get(){
        return licznik;
    }
}

class Watek1 extends Thread{
    Licznik l;
    Monitor m;

    public Watek1(Licznik l, Monitor n)
    {
        this.l = l;
        this.m = n;
    }

    public void run()
    {
        try{
            for(int i = 0; i<100; i++)
            {
                m.proceduraWejsciowaWatek1();
                l.increment();
                m.proceduraWyjsciowaWatek1();
                System.out.println("W1, increment ");
                sleep(10);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}

class Watek2 extends Thread{
    Licznik l;
    Monitor m;

    public Watek2(Licznik l, Monitor n)
    {
        this.l = l;
        this.m = n;
    }

    public void run()
    {
        try{
            for(int i = 0; i<100; i++)
            {
                m.proceduraWejsciowaWatek2();
                l.increment();
                m.proceduraWyjsciowaWatek2();
                System.out.println("W2, increment");
                sleep(10);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Licznik l = new Licznik();
        Monitor n = new MonitorImpl();

        Thread th1 = new Watek1(l, n);
        Thread th2 = new Watek2(l, n);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(l.get());
    }
}
