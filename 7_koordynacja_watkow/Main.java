
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Koordynator koordynator = new Koordynator();

        Thread tA = new WatekA(koordynator);
        Thread tB = new WatekB(koordynator);
        Thread tC = new WatekC(koordynator);

        tC.start();
        tA.start();
        tB.start();

        Thread.sleep( 1000);

        tA.interrupt();
        tB.interrupt();
        tC.interrupt();
    }
}
