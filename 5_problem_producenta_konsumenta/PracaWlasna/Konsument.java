
public class Konsument implements Runnable {

    MagazynImpl m;

    public Konsument(MagazynImpl m) {
        this.m = m;
    }

    @Override
    public void run() {

        while(true)
        {
            m.get();
            System.out.println("Zabrałem towar numer: " + m.getTowarID());
        }

    }
}
