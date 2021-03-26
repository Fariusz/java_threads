
public class Producent implements Runnable {

    MagazynImpl m;

    public Producent(MagazynImpl m) {
        this.m = m;
    }

    @Override
    public void run() {
        while(true)
        {
            m.add("towar");
            System.out.println("Dodałem towar numer: " + m.getTowarID());
        }
    }
}

