
public class Producent implements Runnable {

    Magazyn m;
    int towarId;

    public Producent(Magazyn m)
    {
        this.m = m;
    }
    public void run()
    {
        try{
            while(true)
            {
                Thread.sleep((long) (500*Math.random()));
                m.set("Towar id: " + towarId);
                towarId++;
            }
        } catch (InterruptedException e) {}
    }
}
