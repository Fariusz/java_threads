
import static java.lang.Thread.sleep;

public class WatekA extends Thread {

    Koordynator koordynator;

    public WatekA(Koordynator koordynator) {
        this.koordynator = koordynator;
    }

    @Override
    public void run()
    {
        try{
            while(true)
            {
                koordynator.startA();
                System.out.println("Watek A"); //System.out.println("Watek B");
                sleep((int) (Math.random() * 20));
                koordynator.koniecA();
            }
        }catch(InterruptedException ex){
            System.out.println("wyjatek w watku A");
        }
    }
}
