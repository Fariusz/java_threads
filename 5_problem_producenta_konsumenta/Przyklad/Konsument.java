
public class Konsument implements Runnable{

    Magazyn m;

    public Konsument(Magazyn m) {
        this.m = m;
    }

    @Override
    public void run() {
        try{
            while(true)
            {
                Thread.sleep((long) (500*Math.random()));
                String s = m.get();
                System.out.println("Pobrałem towar: " + s);
            }
        } catch (InterruptedException e) {}
    }
}
